package fr.epsi.b3.gostyle.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CouponsModelTest {

	private Coupon couponsModel;
	
	@Before
	public void setUpTestRequirement() {
		couponsModel = new Coupon(); 
	}
	
	@Test
	public void CouponsModelBienInitialiseAuLancementDeLApi() {
		assertTrue(couponsModel instanceof Coupon);
	}
	
	@Test
	public void CouponsModelContientUnId() {
		assertEquals(0, couponsModel.getCouponId());
	}
	
	@Test
	public void CouponsModelContientUnCodePromotionnel() {
		assertNull(couponsModel.getCodePromotionnel());
	}
	
	@Test
	public void CouponsModelContientUneDateExpiration() {
		assertNull(couponsModel.getDateExpiration());
	}
	
	@Test
	public void CouponsModelContientUnTauxDeReduction() {
		assertEquals(0,couponsModel.getTauxReduction());
	}
	
	@Test
	public void SetCouponsModelLibelle() {
		couponsModel.setCodePromotionnel("TEST100");
		assertEquals("TEST100",couponsModel.getCodePromotionnel());
	}
	
	@Test
	public void SetCouponsModelDateExpiration() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		couponsModel.setDateExpiration(date);
		assertEquals(date, couponsModel.getDateExpiration());
	}
	
	@Test
	public void SetCouponsModelTauxReduction() {
		couponsModel.setTauxReduction(100);
		assertEquals(100,couponsModel.getTauxReduction());
	}
}
