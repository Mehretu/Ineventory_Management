package ex.vvs.et.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ex.vvs.et.model.ResourceRequest;

/**
 * DAO for ResourceRequestDto
 */
@Stateless
public class ResourceRequestDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(ResourceRequest entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		ResourceRequest entity = em.find(ResourceRequest.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ResourceRequest findById(long id) {
		return em.find(ResourceRequest.class, id);
	}

	public ResourceRequest update(ResourceRequest entity) {
		return em.merge(entity);
	}

	public List<ResourceRequest> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<ResourceRequest> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM ResourceRequest r LEFT JOIN FETCH r.employee LEFT JOIN FETCH r.resources LEFT JOIN FETCH r.purchases ORDER BY r.employeeId",
						ResourceRequest.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
