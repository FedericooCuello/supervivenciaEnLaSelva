/*El tipo de arbol elegido es el binario el cual puede tener como maximo dos hijos*/
package com.mycompany.supervivenciaenlaselva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupervivenciaEnLaSelva {
    public static void main(String[] args) {
        List<String> camino = new ArrayList<>();
        Nodo recorridoPredefinido = null;
        Nodo recorridoPersonalizado = null;

        Scanner leer = new Scanner(System.in);
        Arbol arbolPredefinido = new Arbol(Arbol.construirArbol());
        Arbol arbolPersonalizado = null;

        int op = 0;
        while (op != 6) {
            System.out.println("\nMenu");
            System.out.println("1. Jugar árbol predefinido");
            System.out.println("2. Ver camino del último juego");
            System.out.println("3. Crear juego personalizado");
            System.out.println("4. Jugar árbol personalizado");
            System.out.println("5. Mostrar árbol personalizado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    camino.clear();
                    recorridoPredefinido = arbolPredefinido.jugarConArbolPersonalizado(camino);
                    break;
                case 2:
                    System.out.println("Camino elegido:");
                    if (camino.isEmpty()) {
                        System.out.println("No has jugado aún.");
                    } else {
                        for (String d : camino) {
                            System.out.println(" - " + d);
                        }
                    }
                    break;
                case 3:
                    camino.clear();
                    System.out.println("¡Vamos a crear tu propia historia!");
                    Nodo nuevaRaiz = Arbol.construirArbolPersonalizado(leer);
                    int profundidad = Arbol.calcularProfundidad(nuevaRaiz);
                    if (profundidad < 4) {
                        System.out.println("️El árbol debe tener al menos 4 niveles de profundidad. Volvé a intentarlo.");
                    } else {
                        arbolPersonalizado = new Arbol(nuevaRaiz);
                        System.out.println("Historia personalizada creada con éxito.");
                    }
                    break;
                case 4:
                    if (arbolPersonalizado == null) {
                        System.out.println("Primero debes crear el árbol personalizado.");
                    } else {
                        camino.clear();
                        recorridoPersonalizado = arbolPersonalizado.jugarConArbolPersonalizado(camino);
                    }
                    break;
                case 5:
                    if (recorridoPersonalizado == null) {
                        System.out.println("Aún no jugaste el árbol personalizado.");
                    } else {
                        System.out.println("Árbol del recorrido personalizado:");
                        Arbol.mostrarRecorrido(recorridoPersonalizado, 0);
                    }
                    break;
                case 6:
                    System.out.println("¡Saliste del juego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

