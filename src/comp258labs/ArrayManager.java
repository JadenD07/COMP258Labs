/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;

/**
 *
 * @author jaden
 */
public class ArrayManager {
    
    private Object[] items;
    private int count; //the number of items used in the array
    
    public ArrayManager(){
        items = new Object[5];
        count = 0;
    }
    
    public ArrayManager(int capacity){
        items = new Object[capacity];
        count = 0;
    }
    
    public ArrayManager(Object[] items){
        this.items = items;
        count = items.length;
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
    public int size(){
        return count;
    }
    
    public Object get(int index) throws OutOfBoundsException{
        if(index<0 || index >= count){
            throw new OutOfBoundsException();
        }
        return items[index];
    }
    
    public void add(Object item){
        if(count>=items.length){
            Object[] temp = new Object[items.length+10];
            System.arraycopy(items,0,temp,0,count);
            items = temp;
        }
        items[count] = item;
        count++;
    }
    
    public void remove(int pos) throws NoItemsException, OutOfBoundsException{
        if(isEmpty())
            throw new NoItemsException();
        if(pos<0 || pos>=count)
            throw new OutOfBoundsException();
        
        
        Object[] temp = new Object[items.length];
        System.arraycopy(items, 0, temp, 0, pos);
        System.arraycopy(items, pos+1, temp, pos, items.length-pos-1);
        items=temp;
    }
    
    public void addAt(Object item, int pos){
        //resize the array if needed
        Object[] temp;
        
        if(count>=items.length){
            temp = new Object[items.length+10];
        }else{
            temp = new Object[items.length];
        }
        //copy 0-pos to new array
        System.arraycopy(items, 0, temp, 0, pos);
        //add item to pos
        temp[pos] = item;
        //copy pos-end to new array
        System.arraycopy(items, pos, temp, pos+1, items.length-pos-1);
        //assign new array back to items
        items=temp;
        
        count++;
    }
    
    public void print(){
        for(int i=0; i<count; i++){
            System.out.println(items[i]);
        }
    }
    
    public void printArray(){
        for(int i=0; i<items.length; i++){
            System.out.println(items[i]);
        }
    }
    
    public static void main(String[] args) {
        ArrayManager am = new ArrayManager();
        am.add(5);
        am.add(17);
        am.add("Hello");
        am.add(15);
        am.add(47);
        am.add(2);
        am.print();
        System.out.println("After");
        am.addAt(55,0);
        am.addAt("Gandalf",5);
        try{
            System.out.println("GET: " + am.get(120));
        }catch(Exception e){
            System.out.println(e.toString());
        }
        try{
           am.remove(3); 
        }catch(NoItemsException e){
            System.out.println(e.toString());
        }catch(OutOfBoundsException e){
            System.out.println(e.toString());
        }
        
        am.print();
        //am.printArray();
    }
}
