package org.appfuse.tutorial.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Comida;

public interface ComidaDao extends GenericDao<Comida, Long>{
    public List<Comida> findByTipo(String tipo);
}
