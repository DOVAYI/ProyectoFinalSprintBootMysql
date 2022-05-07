package com.sofka.dao;

import com.sofka.domain.Bingo;
import org.springframework.data.repository.CrudRepository;

public interface bingoDao extends CrudRepository<Bingo,Integer> {
}
