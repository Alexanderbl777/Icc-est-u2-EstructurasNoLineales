package Materia.models;

public class  Node{
    private int value;
    private Node right;
    private Node left;
    private int height;
    

    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node right, Node left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Node [value=" + value+ "";
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

}