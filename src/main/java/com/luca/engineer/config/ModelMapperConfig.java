package com.luca.engineer.config;

import javax.ejb.Stateless;

import org.modelmapper.ModelMapper;

@Stateless
public class ModelMapperConfig {

	private final ModelMapper mapper = new ModelMapper();

    public <D> D convert(Object source, Class<D> destinationType) {
        return mapper.map(source, destinationType);
    }
	
}
