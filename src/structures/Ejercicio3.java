package structures;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import structures.node.Node;
import structures.trees.BinaryTree;


public class Ejercicio3 {

    public void insert(int[] numeros){

        BinaryTree<Integer> tree = new BinaryTree<>();

        for(int numero : numeros){
            tree.insert(numero);
        }

        System.out.println("--- Salida ---");
        printTree(tree.getRoot());
    }

    public void printTree(Node<Integer> root){

        List<List<Node>> niveles = listLevels(root);

        for(List<Node> nivel : niveles){

            for(int i = 0; i < nivel.size(); i++){

                System.out.print(nivel.get(i).getValue());

                if(i < nivel.size() - 1){
                System.out.print(" -> ");
                }
            }

        System.out.println();
    }
}

    public List<List<Node>> listLevels(Node root) {

        List<List<Node>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int levelSize = queue.size();
            List<Node> currentLevel = new LinkedList<>();

            for(int i = 0; i < levelSize; i++){

                Node currentNode = queue.poll();
                currentLevel.add(currentNode);

                if(currentNode.getLeft() != null){
                    queue.add(currentNode.getLeft());
                }

                if(currentNode.getRight() != null){
                    queue.add(currentNode.getRight());
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}