package fr.epsi.b3.gostyle.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.epsi.b3.gostyle.model.Coupon;

@Repository
public class CouponsDao {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}
	
	
	
	/**
	 * Ajoute un coupon dans la base de données. Si
	 * le coupon existe déjà il est mit a jour (si nécessaire)
	 * @param coupon
	 */
	public void createOrUpdate(Coupon coupon) {
		em.merge(coupon);
	}
	
	/**
	 * 
	 * @param id
	 * @return Retourne le coupon correspondant a l'id ou null si il n'existe pas
	 */
	public Coupon getById(int id) {
		return em.find(Coupon.class, id);
	}
	
	/**
	 * Supprime de la base de données le coupon correspondant 
	 * à l'Id fournit.
	 * Cette methode est sans effet si le coupon n'existe pas.
	 * @param id
	 */
	public void deleteByCode(int id) {
		em.createQuery("delete from Coupons c where c.id_coupon = :id").setParameter("id",id).executeUpdate();
	}
	
}








