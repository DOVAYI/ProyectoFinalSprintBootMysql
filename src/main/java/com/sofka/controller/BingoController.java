package com.sofka.controller;

import com.sofka.domain.Numerosj;
import com.sofka.service.BingoService;
import com.sofka.service.RetornaNumerosjService;
import com.sofka.utility.RestructurasIdJugador;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.sofka.domain.Bingo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BingoController {
    @Autowired
    private BingoService bingoService;

    @Autowired
    private RetornaNumerosjService retornanumeroService;


    //@GetMapping(path="/numerosjugador")
    @Transactional(readOnly = true)
    public List<Numerosj> cargarNUmerosJugador( String idjugador) {
        return retornanumeroService.getListNumerosJugador(idjugador);
    }

    //idJugador=ltsprueba
    //@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/crearbingo")
    public List<Numerosj> create(@RequestBody String idJugador) {
        List<Numerosj> numerosj = null;
        log.info("prueba"+idJugador);
        String newIdjugador = RestructurasIdJugador.restructurarId(idJugador);
        log.info("prueba2"+newIdjugador);
        Bingo bingo = bingoService.crearBingo(newIdjugador);
        if (bingo.getIdb() > 0 && bingo.getIdb() != null) {
            numerosj = cargarNUmerosJugador(newIdjugador);
        }
        return numerosj;
    }
}
