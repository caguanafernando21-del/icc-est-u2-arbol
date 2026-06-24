import models.Person;
import structures.*;
import structures.trees.BinaryTree;
import structures.trees.IntTree;
public class App {

    public static void main(String[] args) {

        runIntTree();
        runPersonTree();
        runEjercicios();
        runEjercicio2();
        runEjercicio3();
        runEjercicio4();
    }

    private static void runIntTree() {

        IntTree arbolNumeros = new IntTree();

        arbolNumeros.insert(10);
        arbolNumeros.insert(5);
        arbolNumeros.insert(3);
        arbolNumeros.insert(8);
        arbolNumeros.insert(20);
        arbolNumeros.insert(15);

        System.out.println("Pre Order");
        arbolNumeros.preOrder();

        System.out.println();
        System.out.println("Pos Order");
        arbolNumeros.posOrder();
        System.out.println("In Order");
        arbolNumeros.inOrder();

        System.out.println("\nNiveles");
        arbolNumeros.niveles();

        System.out.println("\nAltura");
        System.out.println(arbolNumeros.altura());

        System.out.println("\nPeso");
        System.out.println(arbolNumeros.peso());

        System.out.println("Nuevo");
        System.out.println((arbolNumeros.getPeso()));

    }
    private static void runPersonTree(){
        BinaryTree<Person> personTree = new BinaryTree<>();

        System.out.println("======= Parte de la persona======");

        personTree.insert(new Person("Alice", 30));
        personTree.insert(new Person("Bob", 25));
        personTree.insert(new Person("Diego", 35));
        personTree.insert(new Person("Rafael", 35));
        personTree.insert(new Person("Ana", 30));
        
        System.out.println("Pre Order");

        personTree.preOrder();

        System.out.println();

        System.out.println("Pos Order");
        personTree.posOrder();

        System.out.println("In Order");
        personTree.inOrder();

        System.out.println("\nNiveles");
        personTree.niveles();

        System.out.println("\nAltura");
        System.out.println(personTree.altura());

        System.out.println("\nPeso");
        System.out.println(personTree.peso());

        System.out.println("Nuevo");
        System.out.println((personTree.getPeso()));

    }
    private static void runEjercicios() {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        int[] numeros = new int[] { 5, 3, 7, 2, 4, 6, 8};
        ejercicio1.insert(numeros);

    }
    private static void runEjercicio2() {
        Ejercicio2 ejercicio2 = new Ejercicio2();
        int[] numeros = new int[] { 5, 3, 7, 2, 4, 6, 8};
        ejercicio2.insert(numeros);

    }

    private static void runEjercicio3() {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        int[] numeros = new int[] { 4, 2, 7, 1, 3, 6, 9 }; 
        ejercicio3.insert(numeros);
    }

    private static void runEjercicio4(){
        Ejercicio4 ejercicio4 = new Ejercicio4();
        int[] numeros = {4, 2, 7, 1, 3, 8};
        ejercicio4.insert(numeros);
    
    }


}