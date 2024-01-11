package com.zanguetsuinc.soccerapi.api.controller;

import com.zanguetsuinc.soccerapi.api.assembler.TeamAssembler;
import com.zanguetsuinc.soccerapi.api.model.TeamModel;
import com.zanguetsuinc.soccerapi.api.model.input.TeamInput;
import com.zanguetsuinc.soccerapi.domain.model.Team;
import com.zanguetsuinc.soccerapi.domain.repository.TeamRepository;
import com.zanguetsuinc.soccerapi.domain.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@AllArgsConstructor
public class TeamController {

    private TeamRepository teamRepository;
    private TeamAssembler teamAssembler;
    private TeamService teamService;

    @GetMapping
    public List<TeamModel> getAll(){
        return teamAssembler.toCollectionModel(teamRepository.findAll());
    }
    @GetMapping("/{teamId}")
    public ResponseEntity<TeamModel> getTeam(@PathVariable Long teamId){
        return teamRepository.findById(teamId)
                .map(team -> ResponseEntity.ok(teamAssembler.toModel(team)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamModel addTeam(@RequestBody TeamInput teamInput){
        Team newTeam = teamAssembler.toEntity(teamInput);
        Team addedTeam = teamService.registerTeam(newTeam);
        return teamAssembler.toModel(addedTeam);
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<TeamModel> updateTeam(@PathVariable Long teamId, @RequestBody TeamInput teamInput){
        if(!teamRepository.existsById(teamId)) {
            return ResponseEntity.notFound().build();
        }

        Team teamUpdate = teamAssembler.toEntity(teamInput);
        teamUpdate.setId(teamId);
        Team teamUpdatetd = teamService.registerTeam(teamUpdate);
        return ResponseEntity.ok(teamAssembler.toModel(teamUpdatetd));
    }
    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId){
        if(!teamRepository.existsById(teamId)){
            ResponseEntity.notFound().build();
        }

        teamService.excluir(teamId);
        return ResponseEntity.noContent().build();
    }

}
