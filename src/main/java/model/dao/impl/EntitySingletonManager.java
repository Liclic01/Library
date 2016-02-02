package model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Алексей on 18.12.2015.
 */
public class EntitySingletonManager
{
    private EntitySingletonManager(){}

    private static EntityManager em=null;

    public static EntityManager getEm()
    {
        if (em==null)
        {
            em= Persistence.createEntityManagerFactory("library").createEntityManager();
        }
        return em;
    }

}
