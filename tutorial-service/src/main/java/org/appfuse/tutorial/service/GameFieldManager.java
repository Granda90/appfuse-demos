package org.appfuse.tutorial.service;

import javax.ws.rs.PathParam;

import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.model.GameField;

public interface GameFieldManager extends GenericManager<GameField, Long> {

	Double priceWithTax(@PathParam("id") Long id);
	
}
