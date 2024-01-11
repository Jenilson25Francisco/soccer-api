package com.zanguetsuinc.soccerapi.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperCionfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
