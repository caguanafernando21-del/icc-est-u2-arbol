package structures;

import structures.node.Node;
import structures.trees.BinaryTree;
public class Ejercicio2 {
        
    public void insert(int[] numeros){

        BinaryTree<Integer> tree = new BinaryTree<>();

        for(int numero : numeros){
            tree.insert(numero);
        }
        
        System.out.println("--- Arbol Original ---");
        printTree(tree.getRoot());

        // Invertimos el árbol UNA sola vez
        invertRecursively(tree.getRoot());

        System.out.println("\n--- Arbol Invertido ---");
        printInvertida(tree.getRoot());
    }

    public void printTree(Node<Integer> root){
        printTreeRecursivo(root, 0);
    }

    private void printTreeRecursivo(Node<Integer> actual, int nivel){
        if(actual == null){
            return;
        }

        printTreeRecursivo(actual.getRight(), nivel + 1);
        
        for(int i = 0; i < nivel; i++){
            System.out.print("\t");
        }
        
        System.out.println(actual.getValue());    
        
        // Luego recorre la izquierda
        printTreeRecursivo(actual.getLeft(), nivel + 1);
    }

    public void printInvertida(Node<Integer> root){
        printTreeRecursivo(root, 0);
    }

    private void invertRecursively(Node<Integer> root){
        if(root == null){
            return;
        }
        
        Node<Integer> temp = root.getLeft();
        root.setLeft(root.getRight()); 
        root.setRight(temp);
         
        invertRecursively(root.getLeft());
        invertRecursively(root.getRight());
    }
}