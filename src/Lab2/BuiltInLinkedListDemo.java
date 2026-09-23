/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;
import java.util.LinkedList;
/**
 *
 * @author jaden
 */
public class BuiltInLinkedListDemo {
    
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        
        numbers.add(12);
        numbers.add(7);
        numbers.add(25);
        numbers.add(4);
        numbers.add(18);
        
        System.out.println("1. Display the number of items: "+ numbers.size());
        
        System.out.println("2. Display all items: "+ numbers);
        
        numbers.add(30);
        System.out.println("3. Add item: " + numbers);
        
        numbers.add(2, 15);
        System.out.println("4. Add item at position: "+ numbers);
        
        numbers.remove(4);
        System.out.println("5. Remove at position: "+ numbers);
        
        System.out.println("6. Get item at position: " + numbers.get(5));
        
        numbers.set(0, 100);
        System.out.println("7. Replace item at position: " + numbers);
        
        numbers.add(0,26);
        System.out.println("8. Add to front: "+ numbers);
        
        numbers.add(52);
        System.out.println("9. Add to end: "+ numbers);
        
        numbers.remove(0);
        System.out.println("10. Remove first: "+ numbers);
        
        numbers.removeLast();
        System.out.println("11. Remove last: "+ numbers);
        
        System.out.println("Finished: "+ numbers + " size: " + numbers.size());
    }
}
