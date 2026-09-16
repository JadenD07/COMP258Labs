/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

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
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(11);
        list.add(77);
        list.add(99);
        list.add(55);
        list.add(33);
        list.start();
        list.advance();
        list.advance();
        list.addAfter(66);
        list.print();
    }
}
