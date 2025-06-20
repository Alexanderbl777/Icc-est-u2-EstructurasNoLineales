package Materia.controllers;

import Materia.models.Node;

public class BinaryTree {
    
    private Node root;
    private int size ;

    public BinaryTree() {
        this.root = null;
        this.size =0;
    }

    public void insert(int value){
        //null, 50
        root = insertRec(root, value);
        size++;
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

    public void imprimirArbolInH(){
        printInOrderRecH(root);
    }

    public void imprimirArbolInE(){
        printInOrderRecE(root);
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

    private void printInOrderRecH(Node node){
        if(node != null){

            printInOrderRecH(node.getLeft());
            System.out.print(node.getValue()+" (h= "+ getHeightTreeRec(node)+"),");
            printInOrderRecH(node.getRight());
        }
    }

    private void printInOrderRecE(Node node){
        if(node != null){

            printInOrderRecE(node.getLeft());
            System.out.print(node.getValue()+" (bf= "+ factorEquilibrioRec(node)+"),");
            printInOrderRecE(node.getRight());
        }
    }

    public void factorEquilibrio(){
        factorEquilibrioRec(root);
    }

    private int factorEquilibrioRec(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight = getHeightTreeRec(node.getLeft());
        int rightHeight = getHeightTreeRec(node.getRight());

        return leftHeight-rightHeight;
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

    public int getHeightTree(){
        return getHeightTreeRec(root);
    }

    private int getHeightTreeRec(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight = getHeightTreeRec(node.getLeft());
        int rightHeight = getHeightTreeRec(node.getRight());

        return Math.max(leftHeight+1, rightHeight+1);

        
    }

    public int imprimirPeso(){
        return size;
    }

    public boolean arbolEquilibrado() {
    return estaBalanceado(root);
    }

    private boolean estaBalanceado(Node node) {
        if (node == null) {
            return true;
        }

        int num = factorEquilibrioRec(node);
        if (num < -1 || num> 1) {
            return false;
        }

        return estaBalanceado(node.getLeft()) && estaBalanceado(node.getRight());
    }

    
    public void nodosDesequilibrados() {
        System.out.println("Nodos desequilibrados:");
        listarDesequilibrados(root);
    }

    private void listarDesequilibrados(Node node) {
        if (node != null) {
            listarDesequilibrados(node.getLeft());

            int bf = factorEquilibrioRec(node);
            if (bf < -1 || bf > 1) {
                System.out.println("Valor: " + node.getValue() + " (bf = " + bf + ")");
            }

            listarDesequilibrados(node.getRight());
        }
    }


    
}
