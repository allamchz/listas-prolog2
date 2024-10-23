package com.example.listasprolog;

import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Map;

public class Compatibilidad {

    public static void main(String[] args) {
        // Cargar el archivo Prolog
        String consultaCargar = "consult('operaciones.pl')";
        Query cargarArchivo = new Query(consultaCargar);

        if (cargarArchivo.hasSolution()) {
            System.out.println("Base de datos Prolog cargada correctamente.");
        } else {
            System.out.println("Error al cargar la base de datos Prolog.");
            return;
        }

        // Consulta de compatibilidad
        String consultaCompatibilidad = "compatible(X, Y)";
        Query consulta = new Query(consultaCompatibilidad);

        while (consulta.hasMoreSolutions()) {
            // Obtener la siguiente solución de la consulta
            Map<String, Term> solucion = consulta.nextSolution();

            // Obtener los valores de X e Y
            Term x = solucion.get("X");
            Term y = solucion.get("Y");


            System.out.println(x + " es compatible con " + y);

        }

    }
}
