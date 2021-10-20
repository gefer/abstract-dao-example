package br.com.abstractdata.util;

import br.com.abstractdata.exceptions.PersistenceUnitNotConfiguredException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gefer
 */
public class JPAUtil {

    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT = "PERSISTENCE_UNIT";

    private static void createFactory() throws Exception {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    private static void closeFactory() {
        emf.close();
    }

    public static EntityManager getEntityManager() {
        if (emf == null) {
            try {
                createFactory();
            } catch (Exception e) {
                throw new PersistenceUnitNotConfiguredException();
            }
        }
        return emf.createEntityManager();
    }
}
