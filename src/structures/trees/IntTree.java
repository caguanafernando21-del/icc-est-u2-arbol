package structures.trees;

import java.util.LinkedList;
import java.util.Queue;
import structures.node.Node;

public class IntTree {
    private int peso;
    private Node<Integer> root;

    public IntTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> node) {
        root = node;
    }

    public void setRoot(Integer value) {
        root = new Node<Integer>(value);
    }

    public void insert(Integer value) {
        Node<Integer> node = new Node<Integer>(value);
        root = insertRecursivo(root, node);
        peso++;
    }   
    
    public int getPeso() {  
        return peso;
    } 

    public void insert(Node<Integer> value) {
        root = insertRecursivo(root, value);
    }

    private Node<Integer> insertRecursivo(Node<Integer> actual,
                                          Node<Integer> nodeInsertar) {

        if (actual == null) {
            return nodeInsertar;
        }

        if (actual.getValue() > nodeInsertar.getValue()) {
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

    private void preOrderRecursivo(Node<Integer> actual) {

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

    private void posOrderRecursivo(Node<Integer> actual) {

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

    private void inOrderRecursivo(Node<Integer> actual) {

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

        Queue<Node<Integer>> cola = new LinkedList<>();

        cola.add(root);

        while (!cola.isEmpty()) {

            Node<Integer> actual = cola.poll();

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

    private int alturaRecursiva(Node<Integer> actual) {

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

    private int pesoRecursiva(Node<Integer> actual) {

        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = pesoRecursiva(actual.getLeft());
        int alturaDerecha = pesoRecursiva(actual.getRight());
        return (alturaDerecha + alturaIzquierda) + 1;
   
    }

 

}