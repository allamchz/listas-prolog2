package com.example.listasprolog;

import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListasPrologApplication {

    public static void main(String[] args) {
        String prologFile = "consult('operaciones.pl')";
        Query cargarArchivo = new Query(prologFile);

        // Comprobar si el archivo Prolog se carga correctamente
        if (cargarArchivo.hasSolution()) {
            System.out.println("Archivo Prolog cargado correctamente.");
        } else {
            System.out.println("Error al cargar el archivo Prolog.");
            return;
        }

        // Crear la lista desordenada en Java
        Term listaDesordenada = Term.textToTerm("[5, 1, 4, 2, 3]");

        // Crear una variable para la lista ordenada
        Variable listaOrdenada = new Variable("ListaOrdenada");

        // Crear la consulta Prolog que utiliza el predicado "ordenada"
        String consulta = "ordenada(" + listaDesordenada + ", " + listaOrdenada + ")";
        Query query = new Query(consulta);

        // Ejecutar la consulta y obtener la lista ordenada
        if (query.hasSolution()) {
            Term resultado = query.oneSolution().get("ListaOrdenada");

            System.out.println("Lista desordenada: " + listaDesordenada);
            System.out.println("Lista ordenada: " + resultado);

            // Convertir el resultado a un arreglo de términos (cada uno representando un elemento de la lista)
            Term[] elementosListaOrdenada = resultado.listToTermArray();

            // Imprimir cada elemento de la lista ordenada
            System.out.println("Elementos de la lista ordenada:");
            for (Term elemento : elementosListaOrdenada) {
                System.out.println(elemento);
            }
        } else {
            System.out.println("No se pudo ordenar la lista.");
        }
    }

}
