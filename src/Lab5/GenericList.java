/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;
import Lab4.Widget;

/**
 *
 * @author jaden
 */
public class GenericList<T extends Comparable> {
    private GenericNode<T> items;
    private GenericNode<T> current;
    
    public void add(T item){
        if(items==null){
            items = new GenericNode(item);
            current=items;
        }else{
            current.next=new GenericNode(item);
            current = current.next;
        }
    }
    
    public void print(){
        GenericNode<T> temp = items;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }
    
    public T getCurrent(){
        return current.getData();
    }
    
    public T findMax(){
        if(items==null){
            return null;
        }else{
            return findMax(items, items.getData());
        }
    }
    
    public T findMax(GenericNode<T> temp, T max){
        if(temp==null)
            return max;
        if(max.compareTo(temp.getData())<0)
            return max = temp.getData();
        return findMax(temp.next, max);
    }
    
    public static void main(String[] args) {
        GenericList<Widget> list = new GenericList<Widget>();
        list.add(new Widget(50, "Saw"));
        list.add(new Widget(30, "Hammer"));
        list.add(new Widget(75, "Axe"));
        list.add(new Widget(15, "Drill"));
        list.add(new Widget(26, "Apple"));
        list.add(new Widget(64, "Banana"));
        list.add(new Widget(55, "Orange"));
        list.add(new Widget(70, "Screw"));
        list.print();
        
        Widget x = list.getCurrent();
        System.out.println(">>>"+x);
        
        Widget y = list.findMax();
        System.out.println("Max>>>" + y);
    }
}
