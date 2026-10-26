/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;
import Lab2.LinkedList;
import FrameWork.ConsoleFramework;
import java.util.Scanner;
/**
 *
 * @author jaden
 */
public class RecursionApplication extends ConsoleFramework{
    public Scanner input = new Scanner(System.in);
    public final int QUIT_OPTION = 0;
    private LinkedList list;
    
    public int showMenu(){
        System.out.println("1. Sum Numbers");
        System.out.println("2. Factorial");
        System.out.println("3. MyPow");
        System.out.println("4. IsPalindrome");
        System.out.println("5. PrintList: Forward");
        System.out.println("6. PrintList: Backward");
        System.out.println("7. IndentToTron");
        System.out.println("8. Fibonacci");
        System.out.println("0. Exit");
        int option = this.readInt(">>");
        return option;
    }
    
    public void startProgram() {
       list = new LinkedList();
       list.add(5);
       list.add(23);
       list.add(77);
       list.add(13);
       list.add(800);
       list.add(64);
    }
    
    public void executeAction(int choice){
        if(choice == 1){
            int n = this.readInt("Enter a number: ");
            System.out.println(this.sumNumbersTo(n));
        }else if(choice == 2){
            int n = this.readInt("Enter a number: ");
            System.out.println(this.factorial(n));
        }else if(choice == 3){
            int n = this.readInt("Enter a base: ");
            int x = this.readInt("Enter an exponent: ");
            System.out.println(this.myPow(n,x));
        }else if(choice == 4){
            String s = this.readString("Enter a word: ");
            System.out.println(this.isPalindrome(s));
        }else if(choice == 5){
            System.out.println("List forward:");
            this.printList();
        }else if(choice == 6){
            System.out.println("List backward:");
            this.printListReverse();
        }else if(choice == 7){
            int n = this.readInt("Enter a number to indent to: ");
            this.indentToTron(n);
        }else if(choice == 8){
            int n = this.readInt("Enter a number: ");
            System.out.println(this.fibonacci(n));
        }
    }
    //A recursive method is a method that:
    // 1. Calls itself (is recursive)
    // 2. Works towards a base case (or base cases)
    public int sumNumbersTo(int x){
        if(x==1)
            return 1;
        return x + sumNumbersTo(x-1);
    }
    
    //1.
    public int factorial(int x){
        if(x==1)
            return 1;
        return x * factorial(x-1);
    }
    
    //2.
    public int myPow(int a, int b){
        if(b==1)
            return a;
        return a * myPow(a, b-1);
    }
    
    //3.
    //not recursive
    public boolean isPalindrome(String s){
        return isPalindrome(s,0,s.length()-1);
    }
    //recursive
    public boolean isPalindrome(String s, int start, int end){
        if(s.charAt(start) != s.charAt(end))
            return false;
        else if(start>end)
            return true;
        return  isPalindrome(s, start+1, end-1);
    }
    
    //4. 
    public void printList(){
       list.recursivePrint();
    }
    
    //5.
    public void printListReverse(){
        list.recursivePrintReverse();
    }
    
    //6.
    public void indentToTron(int n){
        indentToTron(1,n);
        indentToTronBack(1,n);
    }
    public void indentToTron(int n, int x){
        if(n>x)
            return;
        for(int i=1; i<n;i++){
            System.out.print(" ");
        }
        System.out.println("This was written by call number " + n + ".");
        indentToTron(n+1, x); 
    }
    public void indentToTronBack(int n, int x){
        if(n>x)
            return;
        indentToTronBack(n+1,x);
        for(int i=1; i<n;i++){
            System.out.print(" ");
        }
        System.out.println("This ALSO written by call number " + n + ".");
    }
    
    //7.
    public int fibonacci(int n){
        if(n==1 || n==0)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        RecursionApplication ra = new RecursionApplication();
        ra.run();
    }
    
}
