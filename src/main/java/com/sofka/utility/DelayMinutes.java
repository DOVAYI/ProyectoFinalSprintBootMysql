package com.sofka.utility;

import com.sofka.dao.bingoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Timer;
import java.util.TimerTask;


@Slf4j
public class DelayMinutes {

    @Autowired
    private bingoDao bingodao;
    private Timer timer;
    private Integer contador = 0;

    public DelayMinutes() {
        timer = new Timer();
        timer.schedule(tarea, 0, 60000);

    }


    TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            contador++;
            log.info("pasaron  minutos" + contador);
            if (contador == 5) {
                timer.cancel();
                //actualizarEstado();
            }
        }
    };

    @Transactional
    public void actualizarEstado() {
        bingodao.updateStatus("iniciado", "pendiente");
    }

}
