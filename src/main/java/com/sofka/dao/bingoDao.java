package com.sofka.dao;

import com.sofka.domain.Bingo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface bingoDao extends CrudRepository<Bingo,Integer> {
    @Query("select b.estado from Bingo b  where b.estado=:estado ")
    public String getEstadoJuego(@Param("estado") String estado);

    @Modifying
    @Query("update Bingo b set b.estado=:newEstado where b.estado=:estado")
    public void updateStatus(@Param("newEstado") String newEstado,
                             @Param(value="estado") String estado);
}
