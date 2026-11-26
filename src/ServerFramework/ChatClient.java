package ServerFramework;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 */
public class ChatClient extends AbstractClient {
    //Instance variables **********************************************

    /**
     * The interface type variable. It allows the implementation of the display
     * method in the client.
     */
    ChatIF clientUI;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Constructors ****************************************************
    /**
     * Constructs an instance of the chat client.
     *
     * @param host The server to connect to.
     * @param port The port number to connect on.
     * @param clientUI The interface type variable.
     */
    public ChatClient(String host, int port, ChatIF clientUI)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
    }

    public ChatClient(String host, int port, ChatIF clientUI, String userName)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        setUserName(userName);
        openConnection();

        Envelope env = new Envelope("login", userName, "");
        sendToServer(env);
    }

    //Instance methods ************************************************
    /**
     * This method handles all data that comes in from the server.
     *
     * @param msg The message from the server.
     */
    public void handleMessageFromServer(Object msg) {
        if (msg instanceof Envelope) {
            handleEnvelopeFromServer(msg);
        } else {
            clientUI.display(msg.toString());
        }
    }

    public void handleEnvelopeFromServer(Object msg) {
        Envelope env = (Envelope) msg;
        if (env.getCommand().equals("who")) {
            ArrayList<String> users = (ArrayList<String>) env.getArg2();
            System.out.println("count:" + users.size());
            for (int i = 0; i < users.size(); i++) {

                clientUI.display(users.get(i));
            }

        }
    }

    /**
     * This method handles all data coming from the UI
     *
     * @param message The message from the UI.
     */
    public void handleMessageFromClientUI(String message) {

        if (message.charAt(0) == '#') {

            handleClientCommand(message);

        } else {
            try {
                sendToServer(message);
            } catch (IOException e) {
                clientUI.display("Could not send message to server.  Terminating client.......");
                quit();
            }
        }
    }

    /**
     * This method terminates the client.
     */
    public void quit() {
        try {
            closeConnection();
        } catch (IOException e) {
        }
        System.exit(0);
    }

    public void connectionClosed() {

        System.out.println("Connection closed");

    }

    public void handleClientCommand(String message) {

        if (message.equals("#quit")) {
            clientUI.display("Shutting Down Client");
            quit();

        } else if (message.equals("#logoff")) {
            clientUI.display("Disconnecting from server");
            try {
                closeConnection();
            } catch (IOException e) {
            };

        } else if (message.indexOf("#setHost") > 0) {

            if (isConnected()) {
                clientUI.display("Cannot change host while connected");
            } else {
                setHost(message.substring(8, message.length()));
            }

        } else if (message.indexOf("#setPort") > 0) {

            if (isConnected()) {
                clientUI.display("Cannot change port while connected");
            } else {
                setPort(Integer.parseInt(message.substring(8, message.length())));
            }

        } else if (message.equals("#login")) {

            if (isConnected()) {
                clientUI.display("already connected");
            } else {

                try {

                    openConnection();
                } catch (IOException e) {
                    clientUI.display("failed to connect to server.");
                }
            }
        } else {
            Envelope env = null;
            if (message.indexOf("#join") == 0) {
                String command = "join";
                String arg = message.substring(message.indexOf(" "), message.length());
                arg = arg.trim();
                env = new Envelope(command, arg, "");
            } else if (message.indexOf("#pm") == 0) {
                String command = "pm";
                String args[] = message.split(" ");
                String arg1 = args[1];
                String arg2 = args[2];
                env = new Envelope();
                env.setCommand(command);
                env.setArg1(arg1);

                arg2 = message.substring(message.indexOf(arg1) + arg1.length(), message.length());

                env.setArg2(arg2);
            } else if (message.indexOf("#yell") == 0) {
                String command = "yell";
                String arg1 = message.substring(message.indexOf(" "), message.length());
                arg1 = arg1.trim();
                env = new Envelope(command, arg1);
            } else if (message.indexOf("#who") == 0) {
                env = new Envelope();
                env.setCommand("who");
            }
            try {
                sendToServer(env);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //Hook method implementations
    //These hooks are implemented from epmty methods in the parent class

    @Override
    protected void connectionException(Exception exception) {
        System.out.println("The connection to the server has been lost. Please try again");
    }

}
//End of ChatClient class
