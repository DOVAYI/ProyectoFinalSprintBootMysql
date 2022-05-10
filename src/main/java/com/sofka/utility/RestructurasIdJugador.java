package com.sofka.utility;

public class RestructurasIdJugador {

    public static String restructurarId(String idjugador){
        String vector[];
        String aux1 = idjugador;
        String aux2;
        String aux3="";
        try {
            vector = aux1.split(":");
            aux2 = vector[1].replace("}", "");
            aux3 = aux2.replace("\"", "");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }

        return aux3;
    }
}
