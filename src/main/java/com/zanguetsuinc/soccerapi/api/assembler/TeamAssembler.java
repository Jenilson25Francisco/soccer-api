package com.zanguetsuinc.soccerapi.api.assembler;

import com.zanguetsuinc.soccerapi.api.model.TeamModel;
import com.zanguetsuinc.soccerapi.api.model.input.TeamInput;
import com.zanguetsuinc.soccerapi.domain.model.Team;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class TeamAssembler {

    private ModelMapper modelMapper;

    public List<TeamModel> toCollectionModel(List<Team> teams){
        return teams.stream().map(this::toModel)
                .collect(Collectors.toList());
    }

    public TeamModel toModel(Team team){
        return modelMapper.map(team, TeamModel.class);
    }

    public Team toEntity (TeamInput teamInput){
        return modelMapper.map(teamInput, Team.class);
    }

}
