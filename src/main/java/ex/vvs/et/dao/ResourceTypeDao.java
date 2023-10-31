package ex.vvs.et.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ex.vvs.et.model.ResourceType;

/**
 * DAO for ResourceType
 */
@Stateless
public class ResourceTypeDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(ResourceType entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		ResourceType entity = em.find(ResourceType.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ResourceType findById(int id) {
		return em.find(ResourceType.class, id);
	}

	public ResourceType update(ResourceType entity) {
		return em.merge(entity);
	}

	public List<ResourceType> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ResourceType> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM ResourceType r ORDER BY r.id",

						ResourceType.class);
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
                        "SELECT COUNT(p) FROM ResourceType p ",
                        Integer.class);
        return findAllQuery.getSingleResult();
    }


	public List<ResourceType> getByResourceTypeData(String query) {
		Query findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM ResourceType d where d.name =:name",
				ResourceType.class);
		findAllQuery.setParameter("name",query);


		List<ResourceType> results = findAllQuery.getResultList();
		return results.isEmpty() ? null : results;
	}

}
