package Materia.controllers;

import Materia.models.Node;

public class BinaryTree {
    
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value){
        //null, 50
        root = insertRec(root, value);

    }

    private Node insertRec(Node padre, int value){
                                    //null, 50
        if(padre == null){
            return new Node(value);
        }
        if(value < padre.getValue()){
            Node newNode = insertRec(padre.getLeft(), value);
            padre.setLeft(newNode);
        }else if(value > padre.getValue()){
            
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void imprimirArbol(){
        printPreOrderRec(root);
    }

    public void imprimirArbolPos(){
        printPosOrderRec(root);
    }

    public void imprimirArbolPre(){
        printPreOrderRec(root);
    }

    public void imprimirArbolIn(){
        printInOrderRec(root);
    }

    private void printPreOrderRec(Node node){
        if(node != null){
            System.out.print(node.getValue()+", ");
            printPreOrderRec(node.getLeft());
            printPreOrderRec(node.getRight());
        }
       
    }

    private void printPosOrderRec(Node node){
        if(node != null){
            System.out.print(node.getValue()+", ");
            printPosOrderRec(node.getRight());
            printPosOrderRec(node.getLeft());
        }
    }

    private void printInOrderRec(Node node){
        if(node != null){

            printInOrderRec(node.getLeft());
            System.out.print(node.getValue()+", ");
            printInOrderRec(node.getRight());
        }
    }

    public boolean findeValue(int value){
        Node actual = root;
    while (actual != null) {
        if (value == actual.getValue()) {
            return true;
        } else if (value < actual.getValue()) {
            actual = actual.getLeft();
        } else {
            actual = actual.getRight();
        }
    }
    return false;
    }
    
}
