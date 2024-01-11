package com.zanguetsuinc.soccerapi.domain.service;

import com.zanguetsuinc.soccerapi.domain.model.Team;
import com.zanguetsuinc.soccerapi.domain.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TeamService {

    private TeamRepository teamRepository;
    @Transactional
    public Team registerTeam(Team team){
        return teamRepository.save(team);
    }
    @Transactional
    public void excluir(Long teamId){
        teamRepository.deleteById(teamId);
    }



}
