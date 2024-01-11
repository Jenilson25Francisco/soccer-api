package com.zanguetsuinc.soccerapi.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamModel {

    private Long id;
    private String name;
    private String province;
    private String photo_url;

}
