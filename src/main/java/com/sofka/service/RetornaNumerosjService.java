package com.sofka.service;

import com.sofka.dao.numerosjDao;
import com.sofka.domain.Numerosj;
import com.sofka.utility.RestructurasIdJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class RetornaNumerosjService {
    @Autowired
    private numerosjDao numerosjdao;

    @Transactional(readOnly = true)
    public List<Numerosj> getListNumerosJugador(String idjugador) {
        String newIdjugador= RestructurasIdJugador.restructurarId(idjugador);
        return numerosjdao.numerosRandomJugador(newIdjugador);
    }
}
