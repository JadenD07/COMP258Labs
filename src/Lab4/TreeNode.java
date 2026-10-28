/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author jaden
 */
public class TreeNode {
    private Comparable data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Comparable item){
        data=item;
    }
    
    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }
    
    
}
