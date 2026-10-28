/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author jaden
 */
public class Widget implements Comparable{
    private int id;
    private String description;

    public String toString(){
        return this.id+":"+this.description;
    }
    
    public Widget() {
    }
    
    public Widget(int id) {
        this.id = id;
    }

    public Widget(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public int compareTo(Object o){
        Widget w = (Widget)o;
        if(this.id < w.id)
            return -1;
        else if(this.id > w.id)
            return 1;
        else
            return 0;
    }
    
    public boolean equals(Object o){
        Widget w = (Widget)o;
        return w.getId() == this.getId();
    }
}
