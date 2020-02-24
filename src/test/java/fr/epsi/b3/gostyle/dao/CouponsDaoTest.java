package fr.epsi.b3.gostyle.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import fr.epsi.b3.gostyle.model.Coupon;

public class CouponsDaoTest {

	private CouponsDao couponsDao;
	
	@Before
	public void setUpTestRequirement() {
		couponsDao = new CouponsDao(); 
	}
	
	@Test
	public void CouponsServiceBienInitialiseAuLancementDeLApi() {
		assertTrue(couponsDao instanceof CouponsDao);
	}
	
	@Test
	public void CouponsDaoEntityManagerInitialise() {
		assertNull(couponsDao.getEm());
	}
	
	@Test
	public void GetByIdRetourneBienLeCouponPortantLIdFournit() {
		assertEquals(1, couponsDao.getById(1).getCouponId());		
	}
	
	/*@Test
	public void CouponDaoCreateOrUpdateCreerOuMetAJourUnCoupon() {
		Coupon coupon = new Coupon();
		
		assertEquals(coupon, couponsDao.createOrUpdate(coupon));
	}*/
}
