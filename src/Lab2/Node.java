/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

/**
 *
 * @author jaden
 */
public class Node {
    private Object data;
    public Node next;
    
    public Node(){}
    
    public Node(Object data){
        this.data = data;
    }
    
    public Object getData(){
        return data;
    }
    
    public void setData(Object data){
        this.data = data;
    }
    
    public static void main(String[] args) {
        
        Node n1 = new Node(7);
        Node n2 = new Node(15);
        Node n3 = new Node(26);
        Node n4 = new Node(33);
        Node n5 = new Node(77);
        Node n6 = new Node(99);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        
        Node start = n1;
        
        //Linked list traversal algorithm
        Node temp = start;
        while(temp!=null){
            System.out.println(">>" + temp.getData());
            temp=temp.next;
        }
        
    }
}
