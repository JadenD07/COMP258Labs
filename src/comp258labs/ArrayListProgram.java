/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;
import java.util.ArrayList;
/**
 *
 * @author jaden
 */
public class ArrayListProgram extends ConsoleFramework{
    
    private ArrayList numbers;
    
    
    public static void main(String[] args) {
        ArrayListProgram alp = new ArrayListProgram();
        alp.run();
    }
    
    public void startProgram(){
        int capacity = 20;
        numbers = new ArrayList();
        for(int i=0; i<capacity; i++){
            numbers.add(i, (int)(Math.random()*100)+1);
        }
    }
    
    public void endProgram(){
        System.out.println("I want an ice cream");
    }
    
    public int showMenu(){
        System.out.println("1. Display ArrayList size");
        System.out.println("2. Display all items");
        System.out.println("3. Add item to list");
        System.out.println("4. Insert item into list");
        System.out.println("5. Remove item by position");
        System.out.println("6. Get item by position");
        System.out.println("7. Change value at position");
        System.out.println(QUIT_OPTION + ". Quit");
        int option = this.readInt(">>");
        return option;
    }
    
    public void executeAction(int choice){
        if(choice == 1){
            displaySize();
        }else if(choice == 2){
            displayAllItems();
        }else if(choice == 3){
            addItem();
        }else if(choice == 4){
            addAt();
        }else if(choice == 5){
            removeAt();
        }else if(choice == 6){
            displayItem();
        }else if (choice == 7){
            swap();
        }
    }
    
    public void displaySize(){
        System.out.println("Array list size is "+ numbers.size());
    }
    
    public void displayAllItems(){
        for(int i=0; i<numbers.size(); i++){
            System.out.println((i+1)+". "+numbers.get(i));
        }
    }
    
    public void addItem(){
        int x = this.readInt("Enter number to add: ");
        numbers.add(x);
    }
    
    public void addAt(){
        int pos = this.readInt("Position: ");
        int value = this.readInt("Numbers: ");
        numbers.add(pos, value);
        System.out.println("Added");
    }
    
    public void removeAt(){
        int pos = this.readInt("Position: ");
        numbers.remove(pos);
        System.out.println("Removed");
    }
    
    public void displayItem(){
        int pos = this.readInt("Position: ");
        System.out.println("Item: " + numbers.get(pos));
    }
    
    public void swap(){
        int pos = this.readInt("Position: ");
        int newValue = readInt("New value: ");
        
        numbers.remove(pos);
        numbers.add(pos,newValue);
        System.out.println("Changed");
    }
}
