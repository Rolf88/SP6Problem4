/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Cars;
import infrastructure.ICarFacade;
import java.io.Closeable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author RolfMoikjær
 */
public class CarFacade implements Closeable, ICarFacade {

    private final EntityManager entityManager;

    public CarFacade(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public List<Cars> getCars() {
        Query createQuery = this.entityManager.createQuery("SELECT c FROM Cars c");

        return createQuery.getResultList();
    }

    @Override
    public void close() {
        this.entityManager.close();
    }
}
