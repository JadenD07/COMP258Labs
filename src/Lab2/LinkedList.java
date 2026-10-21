/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;
import Exceptions.NoItemsException;
/**
 *
 * @author jaden
 */
public class LinkedList {
    
    private Node items;
    private Node current;

    public LinkedList() {
    }
    

    public Node getItems() {
        return items;
    }

    public void setItems(Node items) {
        this.items = items;
    }

    public Node getCurrent() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }
    
    public void add(Object item){
        Node n = new Node(item);
        if(items==null){
            items = n;
            current = items;
        }else{
            current.next = n;
            current = current.next;
        }
    }
    
    public void print(){
        Node temp=items;
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.next;
        }
    }
    
    public boolean advance(){
        if(current.next == null){
            return false;
        }else{
            current = current.next;
        }
        return true;
    }
    
    public void start(){
        current = items;
    }
    
    public void addAfter(Object item){
        Node n = new Node(item);
        if(items==null){
            items = n;
            current = items;
        }else{
            n.next = current.next;
            current.next = n;
        }
    }
    
    public void addBefore(Object item){
        Node temp = items;
        Node n = new Node(item);
        if(items==null){
            items = n;
            current = items;
        }else if(current==items){
            n.next = items;
            items = n;
            current = n;
        }else{
            while(temp.next!=current){
                temp=temp.next;
            }
            temp.next=n;
            n.next=current;
            current=n;
        }
    }
    
    public void removeCurrent() throws NoItemsException{
        
        Node temp = items;
        if(items==null){
          throw new NoItemsException();  
        }
        if(current == items){
            items=items.next;
            current=items;
        }
        else if(temp == current){
        if(items==null){                    
          throw new NoItemsException();     
        }
        if(current == items){              
            items=items.next;
            current=items;
        }
        else if(temp == current){          
            //only 1 item in list
            items=null;
            current=null;
        }else{
            while(temp.next!=current){      
                temp=temp.next;
            }
            temp.next=current.next; //or temp.next = temp.next.next;
            current = temp.next;
        }
        }
    }
    
    public void removeAllOccurances(Object o) throws NoItemsException{
        start();
        while(current.next!=null){
            if(current.getData()==o){
                removeCurrent();
        start();                           
        while(current.next!=null){          
            if(current.getData()==o){       
                removeCurrent();            
            }else{
                current = current.next;
            }
        }
    }
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        try{
           list.removeCurrent(); 
        }catch(NoItemsException e){
            System.out.println(e.toString());
        }
        
        list.add(65);
        list.add(11);
        list.add(77);
        list.add(99);
        list.add(65);
        list.add(33);
        list.start();
        list.advance();
        list.advance();
        list.addAfter(66);
        list.addBefore(64);
        list.addBefore(65);
        list.addBefore(65);
 
        System.out.println("Before removeAllOccurances of 65: ");
        list.print();
        System.out.println("After removeAllOccurances of 65: ");
        try{
            list.removeAllOccurances(65);
        }catch(NoItemsException e){
            System.out.println(e.toString());
        }
        list.print();
    }
    
    public void recursivePrint(){
        recursivePrint(items);
    }
    public void recursivePrint(Node temp){
        if(temp==null)
            return;
        System.out.println(temp.getData());
        recursivePrint(temp.next);
    }
    
    public void recursivePrintReverse(){
        recursivePrintReverse(items);
    }
    public void recursivePrintReverse(Node temp){
        if(temp==null)
            return;
        recursivePrintReverse(temp.next);
        System.out.println(temp.getData());
    }
}
