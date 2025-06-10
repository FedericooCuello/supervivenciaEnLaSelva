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
        while (op!=4) {
            System.out.println("Menu");
            System.out.println("1. Jugar");
            System.out.println("2. Ver camino del último juego");
            System.out.println("3. Crear juego personalizado");
            System.out.println("4. Salir");
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
                       camino.clear();
                       System.out.println("¡Vamos a crear tu propia historia!");
                       Nodo nuevaRaiz = Arbol.construirArbolPersonalizado(leer);
                       int profundidad = Arbol.calcularProfundidad(nuevaRaiz);
                       if (profundidad < 4) {
                          System.out.println("️ El árbol debe tener al menos 4 niveles de profundidad. Volvé a intentarlo.");
                         } else {
                                arbol.setRaiz(nuevaRaiz);
                                System.out.println(" Historia personalizada creada con éxito. ¡Ahora a jugar!");
                       }                      
                       break;
  
                   case 4:                                  
                    System.out.println("¡Saliste del juego!");                
                    System.exit(0);
                    break;
                             
                
               default:               
                 
                    System.out.println(" Opción inválida.");
            }
        }
    }}
