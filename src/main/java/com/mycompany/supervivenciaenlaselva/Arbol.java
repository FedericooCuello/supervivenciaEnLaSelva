
package com.mycompany.supervivenciaenlaselva;

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
    public void jugar(List<String> camino){
        Scanner leer = new Scanner(System.in);
        Nodo puntero = raiz;
        camino.add(raiz.getOpcion());
        while(!puntero.esHoja()){
            System.out.println(puntero.getOpcion());
            if(puntero.getCaminoIzquierdo() != null){
                System.out.println("Camino Izquierdo: " + puntero.getCaminoIzquierdo().getOpcion());
            }
            if(puntero.getCaminoDerecho() != null) {
                System.out.println("Camino Derecho :" + puntero.getCaminoDerecho().getOpcion());
            }
            System.out.println("Elige una opcion ");
            int op = leer.nextInt();
            if (op == 1 && puntero.getCaminoIzquierdo() != null) {
                puntero = puntero.getCaminoIzquierdo();
                camino.add(puntero.getOpcion());
            } else if (op == 2 && puntero.getCaminoDerecho() != null) {
                puntero = puntero.getCaminoDerecho();
                camino.add(puntero.getOpcion());
            } else {
                System.out.println("Opción inválida, intenta nuevamente.");
            }
        }
        System.out.println("Fin del juego : " + puntero.getResultadoFinal());
        }
    public static Nodo construirArbol(){
        Nodo raiz = new Nodo("Supervicencia en la selva");
        Nodo conseguirRecursos = new Nodo(" (1) Buscar Recursos");
        Nodo conseguirRefugio = new Nodo(" (2) Buscar un Refugio");
        raiz.setCaminoIzquierdo(conseguirRecursos);
        raiz.setCaminoDerecho(conseguirRefugio);
        
       

        Nodo recolectar = new Nodo("(1) Recolectar recursos");
        Nodo cazar = new Nodo("(2) Cazar para conseguir alimento");
        conseguirRecursos.setCaminoIzquierdo(recolectar);
        conseguirRecursos.setCaminoDerecho(cazar);

        // Nodo conseguir refugio con sus hijos buscar y construir refugio
        Nodo buscarRefugioNatural = new Nodo("(1) Buscar refugio natural");
        Nodo construirRefugio = new Nodo("(2) Construir refugio");
        conseguirRefugio.setCaminoIzquierdo(buscarRefugioNatural);
        conseguirRefugio.setCaminoDerecho(construirRefugio);

        // Nodo buscar refugio natural con sus hijos
        Nodo explorarCueva = new Nodo("(1) Explorar cueva");
        Nodo adentrarseSelva = new Nodo("(2) Adentrarse más en la selva");
        buscarRefugioNatural.setCaminoIzquierdo(explorarCueva);
        buscarRefugioNatural.setCaminoDerecho(adentrarseSelva);

        // Hojas para explorar cueva
        Nodo dormirEntrada = new Nodo("(1) dormir en la entrada");
        dormirEntrada.setResultadoFinal("Sobreviviste! pasaste la noche a salvo");
        Nodo dormirFondo = new Nodo("(2)dormir en el fondo de la cueva ");
        dormirFondo.setResultadoFinal("Eliminado! en el final de la cueva, se encontraba un oso");
        explorarCueva.setCaminoIzquierdo(dormirEntrada);
        explorarCueva.setCaminoDerecho(dormirFondo);

        // Hojas para adentrarse más en la selva
        Nodo masAlNorte = new Nodo("(1) explorar mas al norte");
        masAlNorte.setResultadoFinal("Sobreviviste! lograste encontrar un antiguo refugio");
        Nodo masAlSur = new Nodo("(2) explorar mas el sur");
        masAlSur.setResultadoFinal("Eliminado, te perdiste en la profundidad de la selva");
        adentrarseSelva.setCaminoIzquierdo(masAlNorte);
        adentrarseSelva.setCaminoDerecho(masAlSur);

        // Hojas para construir refugio
        Nodo construirRamasHojas = new Nodo("(1) Construir refugio con ramas y hojas");
        construirRamasHojas.setResultadoFinal("Eliminado! tu refugio no logro resistir");
        Nodo construirPalosRocas = new Nodo("(2) Construir refigio con troncos y rocas");
        construirPalosRocas.setResultadoFinal("Sobreviviste! lograste pasar la noche a salvo");
        construirRefugio.setCaminoIzquierdo(construirRamasHojas);
        construirRefugio.setCaminoDerecho(construirPalosRocas);

        Nodo agua = new Nodo("(1) Recolectar Agua");
        Nodo fruta = new Nodo("(2) Recolectar frutas");
        recolectar.setCaminoIzquierdo(agua);
        recolectar.setCaminoDerecho(fruta);

        Nodo Lluvia = new Nodo("(2) Recolectar el agua de la lluvia");
        Lluvia.setResultadoFinal("Sobreviviste! lograste obtener valiosos recursos");
        Nodo pozo = new Nodo("(1) Recolecar el agua de los pozos ");
        pozo.setResultadoFinal("Eliminado! el agua estaba contaminada");
        agua.setCaminoIzquierdo(pozo);
        agua.setCaminoDerecho(Lluvia);

        Nodo frutasConocidas = new Nodo("(1) Recolectar frutas escasas pero conocidas");
        Nodo frutasDesconocida = new Nodo("(2) Recolectar frutas abundantes pero desconocidas");
        frutasConocidas.setResultadoFinal("Sobreviviste! lograste conseguir algunos recursos");
        frutasDesconocida.setResultadoFinal("Eliminado! las frutas desconocidas no eran comestibles");
        fruta.setCaminoIzquierdo(frutasConocidas);
        fruta.setCaminoDerecho(frutasDesconocida);

        // Nuevos nodos para cazar
        Nodo pescar = new Nodo("(1) Pescar");
        Nodo crearTrampa = new Nodo("(2) Crear una trampa");
        cazar.setCaminoIzquierdo(pescar);
        cazar.setCaminoDerecho(crearTrampa);

        // Nodos para pescar
        Nodo pescarConRed = new Nodo("Pescar con red");
        Nodo pescarConLanza = new Nodo("Pescar con lanza");
        
        pescar.setCaminoIzquierdo(pescarConRed);
        pescarConRed.setResultadoFinal("Sobreviviste! lograste pescar algunos pescados");
        pescar.setCaminoDerecho(pescarConLanza);
        pescarConLanza.setResultadoFinal("Eliminado! fallaste el tiro, los peces escaparon");

        // Nodos para crear trampa
        Nodo cavarPozo = new Nodo("Cavar un pozo en el suelo");
        cavarPozo.setResultadoFinal( "Sobreviviste! Atrapaste un animal.");
        Nodo crearJaula = new Nodo("Crear una jaula con maderas");
        crearJaula.setResultadoFinal("Eliminado! la jaula no fue lo suficiente fuerte para capturar al aniaml");
        crearTrampa.setCaminoIzquierdo(cavarPozo);
        crearTrampa.setCaminoDerecho(crearJaula);
        return raiz;
    }
    }

