package com.jihed.accessoires.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name= "nomAccess" ,types = { Accessoire.class })
public interface AccessoireProjection {

	public String getNomAccess();
}
