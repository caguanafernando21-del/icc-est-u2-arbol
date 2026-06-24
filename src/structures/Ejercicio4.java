package structures;

import structures.node.Node;
import structures.trees.BinaryTree;

public class Ejercicio4 {
   

    public void insert(int[] numeros) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        for (int numero : numeros) {
            tree.insert(numero);
        }

        System.out.println("Profundidad maxima: " + maxDepth(tree.getRoot()));
    }

    public int maxDepth(Node<Integer> root) {

        if (root == null) {
            return 0;
        }

        int izquierda = maxDepth(root.getLeft());
        int derecha = maxDepth(root.getRight());

        return Math.max(izquierda, derecha) + 1;
    }

}




