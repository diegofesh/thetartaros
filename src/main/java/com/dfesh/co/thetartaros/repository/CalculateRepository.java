package com.dfesh.co.thetartaros.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepository {

    @PersistenceContext
    private EntityManager em;

    public Double callProcedure(String parameter){
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("NAME_PROCEDURE");
        query.registerStoredProcedureParameter("param_in", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("resultado", Double.class, ParameterMode.OUT);

        query.setParameter("param_in", parameter);
        query.execute();

        return (Double) query.getOutputParameterValue("resultado");
    }
}
