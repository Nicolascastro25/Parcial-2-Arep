/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package co.edu.escuelaing.mathservice1;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author jaime.cacuna
 */
public class MathService1 {

    public static void main(String... args) {
        port(getPort());
        get("/espalindromo", (req, res) -> isPalindromo(req, res));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String isPalindromo(Request req, Response res) {
        String JsonRespuesta;
        String palabraInicial = req.queryParams().toString();
        String cadena = req.queryParams().toString();
        System.out.println(cadena);
        String respuesta = "";
        for (int i = cadena.length() - 2; i > 0; i--) {
            char b = cadena.charAt(i);
            respuesta += b;
        }
        System.out.println("Respuesta: " + respuesta);
        if (palabraInicial.equals("["+respuesta+"]")) {
            JsonRespuesta = "{"
                    + "\"operation\": \"palíndromo\","
                    + " \"input\":  \"" + cadena + "\","
                    + " \"output\":  \"Si es palíndromo\""
                    + "}";
        } else {
            JsonRespuesta = "{"
                    + "\"operation\": \"palíndromo\","
                    + " \"input\":  \"" + cadena + "\","
                    + " \"output\":  \"No es palíndromo\""
                    + "}";
        }
        System.out.println("Json Respuesta: " + JsonRespuesta);
        return JsonRespuesta;
    }
}
