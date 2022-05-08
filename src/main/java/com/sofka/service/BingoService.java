package com.sofka.service;


import com.sofka.dao.bingoDao;
import com.sofka.dao.jugadorDao;
import com.sofka.dao.numerosjDao;
import com.sofka.domain.Bingo;
import com.sofka.domain.Jugador;
import com.sofka.domain.Numerosj;
import com.sofka.utility.GenerarNumerosAleatorios;
import com.sofka.utility.RestructurasIdJugador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class BingoService {

    @Autowired
    private bingoDao bingodao;
    @Autowired
    private jugadorDao jugadordao;

    @Autowired
    private numerosjDao numerosjdao;
    private Bingo bingo2;
    private Bingo bingo = new Bingo();
    private Jugador jugador = new Jugador();
    private Jugador jugador2;

    private GenerarNumerosAleatorios numerosAleatorios =
            new GenerarNumerosAleatorios();

    private Integer matrizNumerosJugador[][] = new Integer[5][5];

    @Transactional
    public Bingo crearBingo(String idJugador) {

        bingo.setEstado("pendiente");
        bingo.setGanador("nn");
        bingo2 = bingodao.save(bingo);


        if (bingo2.getIdb() > 0 && bingo2.getIdb() != null) {
            crearJugador(idJugador, bingo2);
        }

        return bingo2;

    }

    @Transactional
    public Jugador crearJugador(String idJugador, Bingo bingo) {

        jugador.setIdj(idJugador);
        jugador.setBingo(bingo);

        jugador2 = jugadordao.save(jugador);
        if (!(jugador2.getIdj().equals(" ")) && jugador2.getIdj() != null) {
            matrizNumerosJugador = numerosAleatorios.cargarO();
            crearNUmerosJugador(jugador2, matrizNumerosJugador);
        }

        return jugador2;
    }

    @Transactional
    public void crearNUmerosJugador(Jugador jugador,
                                        Integer matrizNumeros[][]) {


        for (int i = 0; i < 5; i++) {
            Numerosj numerosj = new Numerosj();
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    numerosj.setB(matrizNumeros[i][j]);
                }else if(j==1){
                    numerosj.setI(matrizNumeros[i][j]);
                }else if(j==2){
                    numerosj.setN(matrizNumeros[i][j]);
                }else if(j==3){
                    numerosj.setG(matrizNumeros[i][j]);
                }else if(j==4){
                    numerosj.setO(matrizNumeros[i][j]);
                }
            }
            numerosj.setJugador(jugador);
            numerosjdao.save(numerosj);


        }

    }

}
