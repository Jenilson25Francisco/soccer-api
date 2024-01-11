package com.zanguetsuinc.soccerapi.domain.repository;

import com.zanguetsuinc.soccerapi.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
