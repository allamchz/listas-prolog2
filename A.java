String filePath = "consult('operaciones.pl')";
        System.out.println("Entra");
        Query consultQuery = new Query(filePath);
        System.out.println(filePath + " " + (consultQuery.hasSolution() ? "éxito" : "fallo"));

        // Crear variables para los argumentos del predicado
        Term x = new org.jpl7.Integer(5);
        Term y = new org.jpl7.Integer(3);
        Variable z = new Variable("Z");  // Variable de salida

        // Construir la consulta: suma(5, 3, Z)
        Query query = new Query("suma", new Term[]{x, y, z});

        // Ejecutar la consulta y obtener el resultado
        if (query.hasSolution()) {
            Term result = query.oneSolution().get("Z");
            System.out.println("Resultado de la suma: " + result);
        } else {
            System.out.println("No se encontró solución.");
        }