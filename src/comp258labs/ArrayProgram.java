/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;

/**
 *
 * @author jaden
 */
public class ArrayProgram extends ConsoleFramework {
    
    private int[] numbers;
    
    public static void main(String[] args) {
        ArrayProgram ap = new ArrayProgram();
        ap.run();
    }
    
    public void startProgram(){
        numbers = new int[20];
        for(int i=1; i<numbers.length; i++){
            numbers[i] = (int)(Math.random()*100)+1;
            
        }
    }
    
    public void endProgram(){
        System.out.println("Thanks for using my program. Good bye");
    }
    
    public int showMenu(){
        System.out.println("1. Print numbers");
        System.out.println("2. Search for a number");
        System.out.println("3. Find and replace");
        System.out.println(QUIT_OPTION + ". Quit");
        int option = readInt("Please select an option");
        return option;
    }
    
    public void executeAction(int choice){
        if(choice==1){
            printNumbers();
        }
        else if(choice == 2){
            searchForNumber();
        }
        else if(choice == 3){
            findAndReplace();
        }
    }
    
    public void printNumbers(){
        for(int i=0; i<numbers.length; i++){
            System.out.println(i + 1 + ". " + numbers[i]);
        }
    }
    
    public void searchForNumber(){
        boolean found = false;
        int target = this.readInt("Please enter a number to search for: ");
        for(int i=0; i<numbers.length; i++){
            if(target == numbers[i]){
                found = true;
                System.out.println("Found. First occurence at: " + (i+1));
                break;
            }
        }
        if(!found){
            System.out.println("Target not in collection");
        }
    }
    
    public void findAndReplace(){
        boolean found = false;
        int target = this.readInt("Please enter a number to replace: ");
        int newValue = this.readInt("Enter new value: ");
        for(int i=0; i<numbers.length; i++){
            if(target == numbers[i]){
                found = true;
                numbers[i]=newValue;
                System.out.println("Found. First value at: " + (i+1)+ " replaces with "+newValue);
                break;
            }
        }
        if(!found){
            System.out.println("Target not in collection");
        }
    }
}
