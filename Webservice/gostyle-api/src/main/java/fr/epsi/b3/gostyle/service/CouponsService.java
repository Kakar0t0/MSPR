package fr.epsi.b3.gostyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.epsi.b3.gostyle.dao.CouponsDao;
import fr.epsi.b3.gostyle.model.Coupon;

@Service
public class CouponsService {

	@Autowired
	private CouponsDao couponsDao;

	@Transactional(readOnly=true)
	public Coupon getById(int id) {
		return couponsDao.getById(id);
	}
	
	@Transactional
	public void createOrUpdate(Coupon coupon) {
		couponsDao.createOrUpdate(coupon);
	}
	
	@Transactional
	public void deleteById(int id) {
		couponsDao.deleteByCode(id);
	}
}
