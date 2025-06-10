/*El tipo de arbol elegido es el binario el cual puede tener como maximo dos hijos*/
package com.mycompany.supervivenciaenlaselva;

import static com.mycompany.supervivenciaenlaselva.Arbol.construirArbol;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupervivenciaEnLaSelva {

    public static void main(String[] args) {
        List<String> camino = new ArrayList<>();
        

        Scanner leer = new Scanner(System.in);
        Arbol arbol = new Arbol(construirArbol());
        int op = 0;
        while (op!=3) {
            System.out.println("Menu");
            System.out.println("1. Jugar");
            System.out.println("2. Ver camino del último juego");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    camino.clear();
                    arbol.jugar(camino);
                    break;
                case 2:
                    System.out.println(" Camino elegido:");
                    if (camino.isEmpty()) {
                        System.out.println("No has jugado aún.");
                    } else {
                        for (String d : camino) {
                            System.out.println(" - " + d);
                        }
                    }
                    break;
                case 3:
                    System.out.println("¡Saliste del juego!");
                   System.exit(0);
               
                
               default:
                 
                    System.out.println(" Opción inválida.");
            }
        }
    }}
