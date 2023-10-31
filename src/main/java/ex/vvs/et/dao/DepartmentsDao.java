package ex.vvs.et.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ex.vvs.et.model.Departments;

/**
 * DAO for Departments
 */
@Stateless
public class DepartmentsDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;
	private String name;
	public void create(Departments entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Departments entity = em.find(Departments.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Departments findById(long id) {
		return em.find(Departments.class, id);
	}

	public Departments update(Departments entity) {
		return em.merge(entity);
	}

	public List<Departments> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Departments> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT d FROM Departments d LEFT JOIN FETCH d.employees ORDER BY d.id",
						Departments.class);

		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}


	public Long count(Integer startPosition, Integer maxResult) {
		return em.createQuery(
						"SELECT DISTINCT count(d) FROM Departments d LEFT JOIN FETCH d.employees ORDER BY d.id",
						Long.class).getSingleResult();
	}



public List<Departments> getByDepartmentName(String query) {
		Query findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM Departments d where d.name =:name or d.status=:status",
				Departments.class);
		findAllQuery.setParameter("name",query);
	    findAllQuery.setParameter("status",query);

	List<Departments> results = findAllQuery.getResultList();
		return results.isEmpty() ? null : results;
	}


}
