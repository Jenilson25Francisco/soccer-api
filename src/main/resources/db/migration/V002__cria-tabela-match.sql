create table jogo (
    id bigint not null auto_increment,
    team_id bigint not null,
    data datetime not null,
    score_team_one INTEGER not null,
    score_team_two INTEGER not null,
    supported_team varchar(90) not null,
    primary key (id)
);

alter table jogo add constraint fk_match_team foreign key (team_id) references team (id);