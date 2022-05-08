package com.sofka.utility;

public class RestructurasIdJugador {

    public static String restructurarId(String idjugador){
        String id=idjugador;
        String vector[]=id.split("=");

        return vector[1];
    }
}
