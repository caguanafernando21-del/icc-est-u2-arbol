
# Práctica 4: Ejercicios de lógica con estructuras no lineales: árboles

## Datos del Estudiante
* **Universidad:** Universidad Politécnica Salesiana
* **Carrera:** Computación
* **Asignatura:** Estructura de Datos – Segundo Interciclo
* **Estudiante:** Luis Fernando Caguana Suquinagua

---

## Descripción general del proyecto
En programación un **Árbol** es como un organigrama o un árbol genealógico, pero hecho con datos. Este proyecto nos ayuda a entender mejor los algoritmos y a construir estos árboles de forma ordenada, darles la vuelta, separarlos por "pisos" y medir qué tan altos son.

---

## Ejercicio 01: Insertar en BST

### Explicación sencilla
* **¿Qué hace?** Organiza una lista de numeros sueltos dentro de un árbol siguiendo una regla fija: si el numero que llega es **menor** que el de arriba, se va a la **izquierda**; si es **mayor**, se va a la **derecha**. 


### Evidencia de Código (Ejercicio 01)



```java
public void insert(int[] numeros) {
    // Crear un árbol BST - instanciar BinaryTree
    BinaryTrees<Integer> tree = new BinaryTrees<>();

    // Insertar los números en el árbol
    for (int numero : numeros) {
        tree.insert(numero);
    }

    // Imprimir el árbol
    printTree(tree.getRoot());
}

public void printTree(Node<Integer> root) {
    System.out.println("Imprimiendo el árbol: ");
    printTreeRecursivo(root, 0);
}

private void printTreeRecursivo(Node<Integer> actual, int nivel) {
    // 1. Por si actual es null
    if (actual == null) {
        return;
    }

    // 2. Procesar primero el hijo DERECHO
    printTreeRecursivo(actual.getRight(), nivel + 1);

    // 3. Imprimir el nodo actual con tabulaciones según su nivel
    if (nivel != 0) {
        for (int i = 0; i < nivel - 1; i++) {
            System.out.print("\\t");
        }
        System.out.println("\\t" + actual.getValue());
    } else {
        // Es la raíz principal
        System.out.println(actual.getValue());
    }

    // 4. Procesar el hijo IZQUIERDO
    printTreeRecursivo(actual.getLeft(), nivel + 1);
}

```

## Salida de consola
![alt text](<img13.png>)

---

## Ejercicio 02: Invertir árbol binario

### Explicación 

* **¿Qué hace?** Le da la vuelta al árbol por completo, como si lo miras en un **espejo**. Lo que antes estaba en el lado izquierdo de una rama, ahora pasa al lado derecho, y viceversa.


### Evidencia de Código (Ejercicio 02)

```java
public Node<Integer> invert(Node<Integer> root) {
    // 1. Imprimir el árbol original 
    System.out.println("--- Arbol Original ---");
    printTree(root);

    // 2. Invertir el arbol
    invertRecursively(root);

    // 3. Imprimir el arbol invertido
    System.out.println("\\n--- Arbol Invertido ---");
    printTree(root);

    return root;
}

public void invertRecursively(Node<Integer> root) {
    
    if (root == null) {
        return;
    }

    
    Node<Integer> temporal = root.getLeft();
    root.setLeft(root.getRight());
    root.setRight(temporal);

   
    invertRecursively(root.getLeft());
    invertRecursively(root.getRight());
}

```

## Salida de consola
![alt text](<img14.png>)

---

## Ejercicio 03: Listar Niveles en Listas Enlazadas

### Explicación

* **¿Que hace?** Separa los numeros del árbol por **"pisos"**. En lugar de ver el árbol ramificado, guarda en listas diferentes a los numeros que están en el piso 1, a los del piso 2, a los del piso 3, etc.
* **El metodo `listLevels`:** Funciona como una fila de supermercado (una cola). Mete al primer numero, mira cuantos hay en ese nivel, los anota en una lista y aprovecha para poner en la fila a sus "hijos". El proceso se repite piso por piso hasta que no queda nadie.

### Evidencia de Código (Ejercicio 03)

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ejercicio3 {

    public void insert(int[] numeros){

        BinaryTree<Integer> tree = new BinaryTree<>();
        
        for(int numero : numeros){
            tree.insert(numero);
        }
        
        System.out.println("--- Arbol Original ---");
        printTree(tree.getRoot());

        listLevels(tree.getRoot());
    }

    public void printTree(Node<Integer> root){
        listLevels(root);
    }

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            List<Node> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode);

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
            
            result.add(currentLevel);
        }

        return result;
    }
}

```
## Salida de consola
![alt text](<img16.png>)

---

## Ejercicio 04: Calcular la Profundidad Maxima

### Explicación 
* **¿Qué hace?** Mide la **altura** del árbol. Averigua cual es el camino mas largo desde el numero de la raiz que es el que esta primero hasta el numero que quedó al fondo de todas las ramas.
* **El método `maxDepth`:** Nuestro algoritmo empieza a bajar por el árbol. Cuenta cuantos pasos hay por el lado izquierdo y cuantos por el derecho. Al final, elige automáticamente el camino mas largo con una regla matemática (`Math.max`) y le suma mas uno para contarse a si mismo.

### Evidencia de Código (Ejercicio 04)
```java
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
```
## Salida de consola
![alt text](<img15.png>)
