package ex.vvs.et.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ex.vvs.et.model.Resources;

/**
 * DAO for Resources
 */
@Stateless
public class ResourcesDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(Resources entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Resources entity = em.find(Resources.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Resources findById(long id) {
		return em.find(Resources.class, id);
	}

	public Resources update(Resources entity) {
		return em.merge(entity);
	}

	public List<Resources> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Resources> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM Resources r LEFT JOIN FETCH r.resourceType LEFT JOIN FETCH r.holdingses LEFT JOIN FETCH r.purchases LEFT JOIN FETCH r.resourceRequests ORDER BY r.id",
						Resources.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
    public Integer count() {
        TypedQuery<Integer> findAllQuery = em
                .createQuery(
                        "SELECT COUNT(p) FROM Resources p ",
                        Integer.class);
        return findAllQuery.getSingleResult();
    }

	public List<Resources> getByResourceData(String query) {
		Query findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM Resources d where d.name =:name or d.status=:status or d.resourceType=:resourceType",
				Resources.class);
		findAllQuery.setParameter("name",query);
		findAllQuery.setParameter("status",query);
		findAllQuery.setParameter("resourceType",query);


		List<Resources> results = findAllQuery.getResultList();
		return results.isEmpty() ? null : results;
	}

}
