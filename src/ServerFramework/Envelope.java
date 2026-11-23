/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerFramework;
import java.io.Serializable;

/**
 *
 * @author jaden
 */
public class Envelope implements Serializable{
    
    private String command;
    private String arg1;
    private Object arg2;

    public Envelope() {
    }

    public Envelope(String command, String arg1, Object arg2) {
        this.command = command;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    
    public Envelope(String command, String arg1) {
        this.command = command;
        this.arg1 = arg1;
        this.arg2 = null;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public Object getArg2() {
        return arg2;
    }

    public void setArg2(Object arg2) {
        this.arg2 = arg2;
    }
    
    
}
