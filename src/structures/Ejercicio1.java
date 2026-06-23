package structures;


import structures.node.Node;
import structures.trees.BinaryTree;

public class Ejercicio1 {

    public void insert(int[] numeros){
        // crear un arbol bts- instanciar BinaryTree
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Insertar los numeros en el arbol
        for(int numero : numeros){
            tree.insert(numero);
        }
        //imprimir el arbol
        printTree(tree.getRoot());
    }


        public void printTree(Node <Integer> root){
            System.out.println("Imprimiendo un arbol:");
            printTreeRecursivo(root,0);
        }

        private void printTreeRecursivo(Node<Integer> actual, int nivel){
            if(actual == null){
                return;
            }

            printTreeRecursivo(actual.getRight(), nivel + 1);

            
            for(int i = 0; i< nivel; i++){
                System.out.print("\t");
            }
            System.out.println(actual.getValue());    

            printTreeRecursivo(actual.getLeft(), nivel + 1);

        }
           
    }
        





