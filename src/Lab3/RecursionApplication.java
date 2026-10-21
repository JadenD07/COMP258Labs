/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;
import Lab2.LinkedList;
/**
 *
 * @author jaden
 */
public class RecursionApplication {
    //A recursive method is a method that:
    // 1. Calls itself (is recursive)
    // 2. Works towards a base case (or base cases)
    public static int sumNumbersTo(int x){
        if(x==1)
            return 1;
        return x + sumNumbersTo(x-1);
    }
    
    //1.
    public static int factorial(int x){
        if(x==1)
            return 1;
        return x * factorial(x-1);
    }
    
    //2.
    public static int myPow(int a, int b){
        if(b==1)
            return a;
        return a * myPow(a, b-1);
    }
    
    //3.
    //not recursive
    public static boolean isPalindrome(String s){
        return isPalindrome(s,0,s.length()-1);
    }
    //recursive
    public static boolean isPalindrome(String s, int start, int end){
        if(s.charAt(start) != s.charAt(end))
            return false;
        else if(start>end)
            return true;
        return  isPalindrome(s, start+1, end-1);
    }
    
    //4. 
    public static void printList(){
       LinkedList ls = new LinkedList();
       ls.add(5);
       ls.add(2);
       ls.add(7);
       ls.add(3);
       ls.add(8);
       ls.add(6);
       
       ls.recursivePrint();
    }
    
    //5.
    public static void printListReverse(){
        LinkedList ls = new LinkedList();
        ls.add(5);
        ls.add(2);
        ls.add(7);
        ls.add(3);
        ls.add(8);
        ls.add(6);
        
        ls.recursivePrintReverse();
    }
    
    //6.
    public static void indentToTron(int n){
        indentToTron(1,n);
        indentToTronBack(1,n);
    }
    public static void indentToTron(int n, int x){
        if(n>x)
            return;
        for(int i=1; i<n;i++){
            System.out.print(" ");
        }
        System.out.println("This was written by call number " + n + ".");
        indentToTron(n+1, x); 
    }
    public static void indentToTronBack(int n, int x){
        if(n>x)
            return;
        indentToTronBack(n+1,x);
        for(int i=1; i<n;i++){
            System.out.print(" ");
        }
        System.out.println("This ALSO written by call number " + n + ".");
    }
    
    //7.
    public static int fibonacci(int n){
        if(n==1 || n==0)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        System.out.println("Sum of numbers between 1 and 20 = " + sumNumbersTo(20));
        System.out.println("Factorial of 5 = " + factorial(5));
        System.out.println("MyPow of 4^5 = " + myPow(4,5));
        System.out.println("isPalindrom of racecar = " + isPalindrome("racecar"));
        System.out.println("printList: ");
        printList();
        System.out.println("printListReverse: ");
        printListReverse();
        System.out.println("indentToTron: ");
        indentToTron(4);
        System.out.println("Fibonacci: f(7) = " + fibonacci(7));
    }
    
}
