package Materia.controllers;

import Materia.models.Node;

public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value){
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> " + value + " con balance " + getBalance(newNode));
            return newNode;
        }

        if (value <= node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node; // Valor duplicado no se inserta
        }

        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("Nodo actual -> " + node.getValue());
        System.out.println("\tAltura -> " + altura);
        

        int balance = getBalance(node);
        System.out.println("\tBalance -> "+ balance);
        // Rotación izquierda-izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotación simple -> Derecha");
            return rightRotation(node);
        }

        // Rotación derecha-derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotación simple -> Izquierda");
            return leftRotation(node);
        }

        // Rotación izquierda-derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Rotación doble -> Izquierda-Derecha");
            node.setLeft(leftRotation(node.getLeft()));
            return rightRotation(node);
        }

        // Rotación derecha-izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Rotación doble -> Derecha-Izquierda");
            node.setRight(rightRotation(node.getRight()));
            return leftRotation(node);
        }

        return node;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node leftRotation(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Rotación IZQ en nodo: " + x.getValue() + ", balance = " + getBalance(x));

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));

        System.out.println("Nueva raíz después de la rotación: " + y.getValue());

        return y;
    }

    private Node rightRotation(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotación DRC en nodo: " + y.getValue() + ", balance = " + getBalance(y));

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));

        System.out.println("Nueva raíz después de la rotación: " + x.getValue());

        return x;
    }

    public void inOrder() {
        System.out.print("Inorden: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRec(node.getRight());
        }
    }
}

