package com.example.listasprolog;

import org.jpl7.Query;
import org.jpl7.Term;

public class PreguntaDirecta {
    public static void main(String[] args) {
        // Cargar el archivo Prolog donde está definido el predicado "validar_listas"
        String prologFile = "consult('operaciones.pl')";
        Query cargarArchivo = new Query(prologFile);

        // Comprobar si el archivo Prolog se carga correctamente
        if (cargarArchivo.hasSolution()) {
            System.out.println("Archivo Prolog cargado correctamente.");
        } else {
            System.out.println("Error al cargar el archivo Prolog.");
            return;
        }

        // Crear la lista desordenada y la lista que creemos ordenada en Java
        Term listaDesordenada = Term.textToTerm("[5, 1, 4, 2, 3]");
        Term listaOrdenada = Term.textToTerm("[10, 2, 3, 4, 5]");

        // Validar ambas listas en Prolog usando el predicado "validar_listas"
        String consultaValidar = "ordenada(" + listaDesordenada + ", " + listaOrdenada + ")";
        Query queryValidar = new Query(consultaValidar);

        // Comprobar si la lista ordenada es correcta
        if (queryValidar.hasSolution()) {
            System.out.println("La lista ordenada es correcta en relación con la lista desordenada.");
        } else {
            System.out.println("La lista ordenada no es correcta.");
        }
    }
}
