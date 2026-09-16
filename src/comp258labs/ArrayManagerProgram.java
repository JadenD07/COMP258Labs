/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;

/**
 *
 * @author jaden
 */
public class ArrayManagerProgram extends ConsoleFramework{
    
    private ArrayManager numbers;
    
    
    public static void main(String[] args) {
        ArrayManagerProgram amp = new ArrayManagerProgram();
        amp.run();
    }
    
    public void startProgram(){
        int capacity = 20;
        numbers = new ArrayManager();
        for(int i=0; i<capacity; i++){
            int number = (int)(Math.random()*100)+1;
            numbers.addAt(number, i);
        }
    }
    
    public void endProgram(){
        System.out.println("You are done managing your array");
    }
    
    public int showMenu(){
        System.out.println("1. Display number of items");
        System.out.println("2. Display all items");
        System.out.println("3. Add an item");
        System.out.println("4. Add an item at a position");
        System.out.println("5. Remove an item");
        System.out.println("6. Get item by position");
        System.out.println("0. Exit");
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
        }
    }
    
    public void displaySize(){
        System.out.println("Array list size is "+ numbers.size());
    }
    
    public void displayAllItems(){
        try{
            for(int i=0; i<numbers.size(); i++){
                System.out.println((i+1)+". "+numbers.get(i));
            }
        }catch(Exception e){
            System.out.println(e.toString() + " :Tried to print non-existant item");
        }
    }
    
    public void addItem(){
        int x = this.readInt("Enter number to add: ");
        numbers.add(x);
    }
    
    public void addAt(){
        int pos = this.readInt("Position: ");
        int value = this.readInt("Numbers: ");
        try{
            numbers.addAt(value, pos);
            System.out.println("Added");
        }catch(Exception e){
            System.out.println("Unable to add at that location");
            System.out.println("Not added");
        }
    }
    
    public void removeAt(){
        int pos = this.readInt("Position: ");
        try{
        numbers.remove(pos);
            System.out.println("Removed");
        }catch(Exception e){
            System.out.println("Failed to remove at that position");
        }
    }
    
    public void displayItem(){
        int pos = this.readInt("Position: ");
        try{
            System.out.println("Item: " + numbers.get(pos));
        }catch(Exception e){
            System.out.println("Unable to display at that position");
        }
    }
}
