package ex.vvs.et.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ex.vvs.et.model.Employee;

/**
 * DAO for Employee
 */
@Stateless
public class EmployeeDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(Employee entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Employee entity = em.find(Employee.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Employee findById(long id) {
		return em.find(Employee.class, id);
	}

	public Employee update(Employee entity) {
		return em.merge(entity);
	}

	public List<Employee> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Employee> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.departments LEFT JOIN FETCH e.resourceRequests LEFT JOIN FETCH e.purchaseRequests LEFT JOIN FETCH e.holdingses ORDER BY e.id",
						Employee.class);
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
						"SELECT COUNT(p) FROM Employee p ",
						Integer.class);
		return findAllQuery.getSingleResult();
	}
public List<Employee> getByEmployeeData(String query) {
		Query findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM Employee d where d.name =:name or d.status=:status or d.email=:email",
				Employee.class);
		findAllQuery.setParameter("name",query);
		findAllQuery.setParameter("status",query);
		findAllQuery.setParameter("email",query);
		List<Employee> results = findAllQuery.getResultList();

		return results.isEmpty() ? null : results;
	}
//
//	public List<Employee>getEmployeeByDate(Date query){
//	Query findAllQuery =em.createQuery(
//			"SELECT DISTINCT d from Employee d where d.createdOn <=: a and d.createdOn >= :b" ,
//			Employee.class);
//	findAllQuery.setParameter("createdOn",query);
//
//	List<Employee>results = findAllQuery.getResultList();
//	return results.isEmpty() ? null : results;
//	}
	public List<Employee> getEmployeeByDate(Date startDate, Date endDate){
		TypedQuery<Employee> findAllQuery = em.createQuery("select p from Employee p " +
				" where date(p.createdOn) between :startDate and :endDate ",Employee.class);
		findAllQuery.setParameter("startDate", startDate);
		findAllQuery.setParameter("endDate", endDate);
		return findAllQuery.getResultList();

	}

}
