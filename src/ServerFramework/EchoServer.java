package ServerFramework;

public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
  	
        super(port);
  	
  	
  	try 
    {
      this.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
    
  
  }
  
   
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    
    if(msg instanceof Envelope){
        
        Envelope env = (Envelope)msg;
        handleEnvelopeCommand(env, client);
    }else{
        this.sendToAllClientsInRoom(msg, client);
    }
  }
    
  public void handleEnvelopeCommand(Envelope env, ConnectionToClient client){
      if(env.getCommand().equals("login")){
          String userName = env.getArg1();
          userName = userName.trim();
          client.setInfo("userName", userName);
          client.setInfo("room", "lobby");
          this.sendToAllClients(userName + " has just joined");
      }
      else if(env.getCommand().equals("join")){
          client.setInfo("room", env.getArg1());
          this.sendDirectlyToClient("You are now in " + env.getArg1(), client);
      }
      else if(env.getCommand().equals("pm")){
          String user = env.getArg1();
          String msg = env.getArg2();
          
          this.sendToAClient(msg, user);
      }
      
  }
  
  public void sendDirectlyToClient(String message, ConnectionToClient client){
      try{
              client.sendToClient(message);
          }catch(Exception e){
              e.printStackTrace();
          }
  }
  
  public void sendToAClient(Object msg, String user)
  {
    Thread[] clientThreadList = getClientConnections();
    

    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        ConnectionToClient target =   (ConnectionToClient)clientThreadList[i];
        String thisUser = target.getInfo("userName").toString();
        if(thisUser.equals(user)){
            target.sendToClient(msg);
        }
        
      }
      catch (Exception ex) {
          ex.printStackTrace();
      }
    }
  }
  
  public void sendToAllClientsInRoom(Object msg, ConnectionToClient client)
  {
    Thread[] clientThreadList = getClientConnections();
    String room = client.getInfo("room").toString();

    for (int i=0; i<clientThreadList.length; i++)
    {
      try
      {
        ConnectionToClient target =   (ConnectionToClient)clientThreadList[i];
        String targetRoom = target.getInfo("room").toString();
        if(targetRoom.equals(room)){
            target.sendToClient(msg);
        }
        
      }
      catch (Exception ex) {
          ex.printStackTrace();
      }
    }
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args)  
  {
    int port = 0; //Port to listen on

   
    port = DEFAULT_PORT; //Set port to 5555
    
	
    EchoServer sv = new EchoServer(port);
    
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
    
  }

  
  
  
  protected void clientConnected(ConnectionToClient client) {
  	
  		System.out.println("<Client Connected:"+client+">");
  	
  	}
  
  protected void clientDisconnected(ConnectionToClient client) {
  	
  		System.out.println("<Client Disconnected:"+client+">");
  	
  	}
  
  synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
      System.out.println("<Client Disconnected:"+client+" was removed from session>");
  }

  
}
//End of EchoServer class
