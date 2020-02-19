package fr.epsi.b3.gostyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epsi.b3.gostyle.dao.CouponsDao;
import fr.epsi.b3.gostyle.model.Coupon;

@Service
public class CouponsService {
	/**
	 * Le CouponsService fais office de passerelle entre le DAO et le controller
	 */

	@Autowired
	private CouponsDao couponsDao;

	/**
	 * Appelle la methode getById de l'objet CouponsDao
	 * @param id
	 * @return Retourne le resultat de l'appel de la method getById de la classe CouponsDao
	 */
	
	@Transactional(readOnly=true)
	public Coupon getByCode(String code) {
		return couponsDao.getByCode(code);
	}
	
	/**
	 * Appelle la methode createOrUpdate de la classe CouponsDao
	 * @param coupon
	 */
	
	@Transactional
	public void createOrUpdate(Coupon coupon) {
		couponsDao.createOrUpdate(coupon);
	}
	
	/**
	 * Appelle la methode deleteById de la classe CouponsDao
	 * @param id
	 */
	
	@Transactional
	public void deleteByCode(String code) {
		couponsDao.deleteByCode(code);
	}
}
