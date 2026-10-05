/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author jaden
 */
public class NoItemsException extends Exception {
    
    public String toString(){
        return "Operation not allowed on empty collection.";
    }
}
