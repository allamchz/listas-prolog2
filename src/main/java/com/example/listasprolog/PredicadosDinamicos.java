package com.example.listasprolog;

import org.jpl7.Query;

public class PredicadosDinamicos {
    public static void main(String[] args) {

        Query assertQuery1 = new Query("assertz(hombre(pedro))");
        Query assertQuery2 = new Query("assertz(mujer(maria))");


        if (assertQuery1.hasSolution() && assertQuery2.hasSolution()) {
            System.out.println("Predicados 'hombre(pedro)' y 'mujer(maria)' cargados dinámicamente en memoria.");
        } else {
            System.out.println("Error al cargar los predicados.");
            return;
        }


        Query consultaHombre = new Query("hombre(X)");
        System.out.println("Resultados para 'hombre(X)':");
        while (consultaHombre.hasMoreSolutions()) {
            System.out.println("Hombre: " + consultaHombre.nextSolution().get("X"));
        }

        Query consultaMujer = new Query("mujer(X)");
        System.out.println("Resultados para 'mujer(X)':");
        while (consultaMujer.hasMoreSolutions()) {
            System.out.println("Mujer: " + consultaMujer.nextSolution().get("X"));
        }
    }
}
