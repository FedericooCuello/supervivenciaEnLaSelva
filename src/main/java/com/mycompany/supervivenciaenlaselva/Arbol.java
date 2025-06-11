
package com.mycompany.supervivenciaenlaselva;

import java.util.List;
import java.util.Scanner;



import java.util.List;
import java.util.Scanner;

public class Arbol {
    private Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    // Método para jugar y registrar recorrido
    public Nodo jugarConArbolPersonalizado(List<String> camino) {
        Scanner leer = new Scanner(System.in);
        Nodo puntero = raiz;

        Nodo raizRecorrido = new Nodo(puntero.getOpcion());
        Nodo punteroRecorrido = raizRecorrido;

        camino.add(puntero.getOpcion());

        while (!puntero.esHoja()) {
            System.out.println(puntero.getOpcion());
            if (puntero.getCaminoIzquierdo() != null) {
                System.out.println("Camino Izquierdo: " + puntero.getCaminoIzquierdo().getOpcion());
            }
            if (puntero.getCaminoDerecho() != null) {
                System.out.println("Camino Derecho :" + puntero.getCaminoDerecho().getOpcion());
            }
            System.out.println("Elige una opcion ");
            int op = leer.nextInt();

            if (op == 1 && puntero.getCaminoIzquierdo() != null) {
                puntero = puntero.getCaminoIzquierdo();
                camino.add(puntero.getOpcion());
                Nodo nuevo = new Nodo(puntero.getOpcion());
                punteroRecorrido.setCaminoIzquierdo(nuevo);
                punteroRecorrido = nuevo;
            } else if (op == 2 && puntero.getCaminoDerecho() != null) {
                puntero = puntero.getCaminoDerecho();
                camino.add(puntero.getOpcion());
                Nodo nuevo = new Nodo(puntero.getOpcion());
                punteroRecorrido.setCaminoDerecho(nuevo);
                punteroRecorrido = nuevo;
            } else {
                System.out.println("Opción inválida, intenta nuevamente.");
            }
        }

        System.out.println("Fin del juego : " + puntero.getResultadoFinal());
        punteroRecorrido.setResultadoFinal(puntero.getResultadoFinal());
        return raizRecorrido;
    }

    // Construcción del árbol predefinido
    public static Nodo construirArbol() {
        Nodo raiz = new Nodo("Supervivencia en la selva");
        Nodo conseguirRecursos = new Nodo("(1) Buscar Recursos");
        Nodo conseguirRefugio = new Nodo("(2) Buscar un Refugio");
        raiz.setCaminoIzquierdo(conseguirRecursos);
        raiz.setCaminoDerecho(conseguirRefugio);

        Nodo recolectar = new Nodo("(1) Recolectar recursos");
        Nodo cazar = new Nodo("(2) Cazar para conseguir alimento");
        conseguirRecursos.setCaminoIzquierdo(recolectar);
        conseguirRecursos.setCaminoDerecho(cazar);

        Nodo buscarRefugioNatural = new Nodo("(1) Buscar refugio natural");
        Nodo construirRefugio = new Nodo("(2) Construir refugio");
        conseguirRefugio.setCaminoIzquierdo(buscarRefugioNatural);
        conseguirRefugio.setCaminoDerecho(construirRefugio);

        Nodo explorarCueva = new Nodo("(1) Explorar cueva");
        Nodo adentrarseSelva = new Nodo("(2) Adentrarse más en la selva");
        buscarRefugioNatural.setCaminoIzquierdo(explorarCueva);
        buscarRefugioNatural.setCaminoDerecho(adentrarseSelva);

        Nodo dormirEntrada = new Nodo("(1) Dormir en la entrada");
        dormirEntrada.setResultadoFinal("Sobreviviste! pasaste la noche a salvo");
        Nodo dormirFondo = new Nodo("(2) Dormir en el fondo de la cueva");
        dormirFondo.setResultadoFinal("Eliminado! había un oso");
        explorarCueva.setCaminoIzquierdo(dormirEntrada);
        explorarCueva.setCaminoDerecho(dormirFondo);

        Nodo masAlNorte = new Nodo("(1) Explorar más al norte");
        masAlNorte.setResultadoFinal("Sobreviviste! encontraste un refugio");
        Nodo masAlSur = new Nodo("(2) Explorar más al sur");
        masAlSur.setResultadoFinal("Eliminado! te perdiste");
        adentrarseSelva.setCaminoIzquierdo(masAlNorte);
        adentrarseSelva.setCaminoDerecho(masAlSur);

        Nodo construirRamasHojas = new Nodo("(1) Construir refugio con ramas y hojas");
        construirRamasHojas.setResultadoFinal("Eliminado! el refugio no resistió");
        Nodo construirPalosRocas = new Nodo("(2) Construir refugio con troncos y rocas");
        construirPalosRocas.setResultadoFinal("Sobreviviste! refugio seguro");
        construirRefugio.setCaminoIzquierdo(construirRamasHojas);
        construirRefugio.setCaminoDerecho(construirPalosRocas);

        Nodo agua = new Nodo("(1) Recolectar agua");
        Nodo fruta = new Nodo("(2) Recolectar frutas");
        recolectar.setCaminoIzquierdo(agua);
        recolectar.setCaminoDerecho(fruta);

        Nodo pozo = new Nodo("(1) Agua del pozo");
        pozo.setResultadoFinal("Eliminado! agua contaminada");
        Nodo lluvia = new Nodo("(2) Agua de lluvia");
        lluvia.setResultadoFinal("Sobreviviste! agua potable");
        agua.setCaminoIzquierdo(pozo);
        agua.setCaminoDerecho(lluvia);

        Nodo frutasConocidas = new Nodo("(1) Frutas conocidas");
        frutasConocidas.setResultadoFinal("Sobreviviste! comida segura");
        Nodo frutasDesconocidas = new Nodo("(2) Frutas desconocidas");
        frutasDesconocidas.setResultadoFinal("Eliminado! no eran comestibles");
        fruta.setCaminoIzquierdo(frutasConocidas);
        fruta.setCaminoDerecho(frutasDesconocidas);

        Nodo pescar = new Nodo("(1) Pescar");
        Nodo trampa = new Nodo("(2) Crear trampa");
        cazar.setCaminoIzquierdo(pescar);
        cazar.setCaminoDerecho(trampa);

        Nodo pescarRed = new Nodo("Pescar con red");
        pescarRed.setResultadoFinal("Sobreviviste! buena pesca");
        Nodo pescarLanza = new Nodo("Pescar con lanza");
        pescarLanza.setResultadoFinal("Eliminado! fallaste");
        pescar.setCaminoIzquierdo(pescarRed);
        pescar.setCaminoDerecho(pescarLanza);

        Nodo pozoTrampa = new Nodo("Cavar pozo");
        pozoTrampa.setResultadoFinal("Sobreviviste! atrapaste un animal");
        Nodo jaula = new Nodo("Crear jaula");
        jaula.setResultadoFinal("Eliminado! escapó el animal");
        trampa.setCaminoIzquierdo(pozoTrampa);
        trampa.setCaminoDerecho(jaula);

        return raiz;
    }

    // Construcción árbol personalizado
    public static Nodo construirArbolPersonalizado(Scanner leer) {
        leer.nextLine();
        System.out.print("Ingresa el texto inicial de la historia: ");
        String texto = leer.nextLine();
        Nodo raiz = new Nodo(texto);
        construirSubarbol(leer, raiz, 1);
        return raiz;
    }

    public static void construirSubarbol(Scanner leer, Nodo nodoActual, int nivelActual) {
        System.out.println("Estás en el nivel " + nivelActual + " del árbol.");
        System.out.print("¿Este nodo es un final? (s/n): ");
        String respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingresa el resultado final: ");
            nodoActual.setResultadoFinal(leer.nextLine());
        } else {
            System.out.print("Ingresa la opción para el camino izquierdo: ");
            String izq = leer.nextLine();
            Nodo izquierdo = new Nodo(izq);
            nodoActual.setCaminoIzquierdo(izquierdo);
            construirSubarbol(leer, izquierdo, nivelActual + 1);

            System.out.print("Ingresa la opción para el camino derecho: ");
            String der = leer.nextLine();
            Nodo derecho = new Nodo(der);
            nodoActual.setCaminoDerecho(derecho);
            construirSubarbol(leer, derecho, nivelActual + 1);
        }
    }

    public static int calcularProfundidad(Nodo nodo) {
        if (nodo == null) return 0;
        int izq = calcularProfundidad(nodo.getCaminoIzquierdo());
        int der = calcularProfundidad(nodo.getCaminoDerecho());
        return 1 + Math.max(izq, der);
    }

    public static void mostrarRecorrido(Nodo nodo, int nivel) {
        if (nodo == null) return;
        for (int i = 0; i < nivel; i++) System.out.print("  ");
        System.out.println("- " + nodo.getOpcion());
        mostrarRecorrido(nodo.getCaminoIzquierdo(), nivel + 1);
        mostrarRecorrido(nodo.getCaminoDerecho(), nivel + 1);
    }
}


