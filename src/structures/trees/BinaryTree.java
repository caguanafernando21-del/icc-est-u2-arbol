package structures.trees;

import java.util.LinkedList;
import java.util.Queue;

import structures.node.Node;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private int peso;
    

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> node) {
        root = node;
    }

    public void setRoot(T value) {
        root = new Node<T>(value);
    }

    public void insert(T value) {
        Node<T> node = new Node<T>(value);
        root = insertRecursivo(root, node);
        peso++;
    }   
    
    public int getPeso() {  
        return peso;
    } 

    public void insert(Node<T> value) {
        root = insertRecursivo(root, value);
    }

    private Node<T> insertRecursivo(Node<T> actual,
                                          Node<T> nodeInsertar) {

        if (actual == null) {
            return nodeInsertar;
        }

        if (actual.getValue().compareTo(nodeInsertar.getValue()) > 0) {
            actual.setLeft(
                insertRecursivo(actual.getLeft(), nodeInsertar)
            );
        } else {
            actual.setRight(
                insertRecursivo(actual.getRight(), nodeInsertar)
            );
        }

        return actual;
    }

    public void preOrder() {
        preOrderRecursivo(root);
    }

    private void preOrderRecursivo(Node<T> actual) {

        if (actual == null) {
            return;
        }

        System.out.print(actual + " ");

        preOrderRecursivo(actual.getLeft());
        preOrderRecursivo(actual.getRight());
    }

    public void posOrder() {
        posOrderRecursivo(root);
    }

    private void posOrderRecursivo(Node<T> actual) {

        if (actual == null) {
            return;
        }

        posOrderRecursivo(actual.getLeft());
        posOrderRecursivo(actual.getRight());

        System.out.print(actual + " ");
    }

    public void inOrder() {
        inOrderRecursivo(root);
    }

    private void inOrderRecursivo(Node<T> actual) {

        if (actual == null) {
        return;
        }

        inOrderRecursivo(actual.getLeft());

        System.out.print(actual + " ");

        inOrderRecursivo(actual.getRight());
    }

    public void niveles() {

        if (root == null) {
            return;
        }

        Queue<Node<T>> cola = new LinkedList<>();

        cola.add(root);

        while (!cola.isEmpty()) {

            Node<T> actual = cola.poll();

            System.out.print(actual + " ");

            if (actual.getLeft() != null) {
                cola.add(actual.getLeft());
            }

            if (actual.getRight() != null) {
                cola.add(actual.getRight());
            }
        }
    } 
    public int altura() {
        return alturaRecursiva(root);
    }

    private int alturaRecursiva(Node<T> actual) {

        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = alturaRecursiva(actual.getLeft());
        int alturaDerecha = alturaRecursiva(actual.getRight());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }  

   public int peso() {
        return pesoRecursiva(root);
    }

    private int pesoRecursiva(Node<T> actual) {

        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = pesoRecursiva(actual.getLeft());
        int alturaDerecha = pesoRecursiva(actual.getRight());
        return (alturaDerecha + alturaIzquierda) + 1;
   
    }    

}
