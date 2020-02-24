package fr.epsi.b3.gostyle.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.epsi.b3.gostyle.model.Coupon;

@Repository
public class CouponsDao {

	@PersistenceContext
	private EntityManager em;	
	
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
	 * @return Retourne le coupon correspondant au code (libelle) ou null si il n'existe pas
	 */
	
	public Coupon getByCode(String code) {
		return em.find(Coupon.class, code);
	}
	
	/**
	 * Supprime de la base de données le coupon correspondant 
	 * au code (libelle) fournit.
	 * Cette methode est sans effet si le coupon n'existe pas.
	 * @param id
	 */
	
	public void deleteByCode(String code) {
		em.createQuery("delete from Coupon c where c.code = :code").setParameter("code",code).executeUpdate();
	}
	
}








