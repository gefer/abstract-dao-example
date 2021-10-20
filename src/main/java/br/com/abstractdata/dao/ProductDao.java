package br.com.abstractdata.dao;

import br.com.abstractdata.entities.Product;
import br.com.abstractdata.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author gefer
 */
public class ProductDao extends AbstractDao<Product> {

    private EntityManager entityManager = JPAUtil.getEntityManager();

    public ProductDao() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public List<Product> findByBrand(String brand) {
        Query query = entityManager.createNamedQuery(Product.QUERY_FIND_BY_BRAND);
        query.setParameter(Product.PARAMETER_BRAND, brand);

        return (List<Product>) query.getResultList();
    }

    @Override
    protected String getTable() {
        return Product.TABLE_NAME;
    }

    @Override
    public List<Product> findAll() {
        CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder()
                .createQuery();

        cq.select(cq.from(Product.class));

        return getEntityManager()
                .createQuery(cq)
                .setMaxResults(100)
                .getResultList();
    }
}
