package com.zanguetsuinc.soccerapi.domain.repository;

import com.zanguetsuinc.soccerapi.domain.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
