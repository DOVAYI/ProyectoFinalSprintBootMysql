package com.sofka.controller;

import com.sofka.domain.Numerosj;
import com.sofka.service.BingoService;
import com.sofka.service.RetornaNumerosjService;
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


@RestController
public class BingoController {
    @Autowired
    private BingoService bingoService;

    @Autowired
    private RetornaNumerosjService retornanumeroService;


    @GetMapping(path="/numerosjugador")
    @Transactional(readOnly = true)
    public List<Numerosj> cargarNUmerosJugador(@RequestBody String idjugador){
        return retornanumeroService.getListNumerosJugador(idjugador);
    }
    //idJugador=ltsprueba
    //@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/crearbingo")
    public ResponseEntity<Bingo> create(@RequestBody String idJugador) {

        Bingo bingo=bingoService.crearBingo(idJugador);

        return new ResponseEntity<>(bingo, HttpStatus.CREATED);
    }
}
