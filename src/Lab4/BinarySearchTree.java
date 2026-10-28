/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab4;

/**
 *
 * @author jaden
 */
public class BinarySearchTree {

    private TreeNode root;
    /**
     * @param args the command line arguments
     */
    
    public void addNode(Comparable item){
        addNode(root, item);
    }
    
    public void addNode(TreeNode current, Comparable item){
        //if the tree is empty
        if(root==null){
            root = new TreeNode(item);//item is the first node
        }
        else if(current.getData().compareTo(item)>=0){//else we are looking at the left of the tree
            if(current.left==null){
                current.left = new TreeNode(item);//if left empty assign left
            }
            else{
                addNode(current.left, item);//otherwise run addNode on left side of tree
            }
        }
        else{
            if(current.right==null){
                current.right = new TreeNode(item);
            }
            else{
                addNode(current.right,item);
            }
        }
    }
    
    public void printTree(){
        printTree(root);
    }
    
    public void printTree(TreeNode current){
        if(current.left != null){
            printTree(current.left);
        }
        System.out.println(current.getData());
        if(current.right != null){
            printTree(current.right);
        }
    }
    public Comparable searchTree(Comparable target){
        if(root==null){
            return null;
        }else{
            return searchTree(root, target);
        }
    }
    public Comparable searchTree(TreeNode current, Comparable item){
        if(current.getData().equals(item)){
            return current.getData();
        }else if(current.getData().compareTo(item) >= 1 && current.left!=null){
            return searchTree(current.left, item);
        }else if(current.getData().compareTo(item) < 1 && current.right!=null){
            return searchTree(current.right, item);
        }
        return null;
    }
    
    public Object findMax(){
        if(root==null){
            return null;
        }
        return findMax(root);
    }
    
    public Object findMax(TreeNode current){
        if(current.right==null){
            return current.getData();
        }else{
            return findMax(current.right);
        }
    }
    
    public Object findMin(){
        if(root==null){
            return null;
        }
        return findMin(root);
    }
    
    public Object findMin(TreeNode current){
        if(current.left==null){
            return current.getData();
        }else{
            return findMin(current.left);
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(new Widget(50, "Saw"));
        bst.addNode(new Widget(30, "Hammer"));
        bst.addNode(new Widget(75, "Axe"));
        bst.addNode(new Widget(15, "Drill"));
        bst.addNode(new Widget(26, "Apple"));
        bst.addNode(new Widget(64, "Banana"));
        bst.addNode(new Widget(55, "Orange"));
        bst.addNode(new Widget(70, "Screw"));
        bst.printTree();
        
        Widget w = (Widget)bst.searchTree(new Widget(26));
        if(w!=null){
            System.out.println("Description: " + w.getDescription());
        }else{
            System.out.println("Not Found");
        }
        w = (Widget)bst.searchTree(new Widget(75));
        if(w!=null){
            System.out.println("Description: " + w.getDescription());
        }else{
            System.out.println("Not Found");
        }
        w = (Widget)bst.searchTree(new Widget(550));
        if(w!=null){
            System.out.println("Description: " + w.getDescription());
        }else{
            System.out.println("Not Found");
        }
        w = (Widget)bst.searchTree(new Widget(64));
        if(w!=null){
            System.out.println("Description: " + w.getDescription());
        }else{
            System.out.println("Not Found");
        }
        
        Widget max = (Widget)bst.findMax();
        System.out.println("Max: " + max.getId()+": "+max.getDescription());
        Widget min = (Widget)bst.findMin();
        System.out.println("Min: " + min.getId()+": "+min.getDescription());
        
    }
}
