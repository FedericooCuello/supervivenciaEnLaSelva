
package com.mycompany.supervivenciaenlaselva;

public class Nodo {
    private String opcion;
    private Nodo caminoDerecho;
    private Nodo caminoIzquierdo;
    private String resultadoFinal;

    public Nodo(String respuesta) {
        this.opcion = respuesta;
        this.caminoDerecho = null;
        this.caminoIzquierdo = null;
        this.resultadoFinal = null;

    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public String getOpcion() {
        return opcion;
    }

    public Nodo getCaminoDerecho() {
        return caminoDerecho;
    }

    public Nodo getCaminoIzquierdo() {
        return caminoIzquierdo;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public void setCaminoDerecho(Nodo caminoDerecho) {
        this.caminoDerecho = caminoDerecho;
    }

    public void setCaminoIzquierdo(Nodo caminoIzquierdo) {
        this.caminoIzquierdo = caminoIzquierdo;
    }
public boolean esHoja() {
        return caminoIzquierdo == null && caminoDerecho == null;
    }
    
    
}
