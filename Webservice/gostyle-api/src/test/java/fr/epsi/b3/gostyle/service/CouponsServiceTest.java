package fr.epsi.b3.gostyle.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.epsi.b3.gostyle.dao.CouponsDao;

public class CouponsServiceTest {

	private CouponsService couponsService;
	
	@Before
	public void setUpTestRequirement() {
		couponsService = new CouponsService(); 
	}
	
	@Test
	public void CouponsServiceBienInitialiseAuLancementDeLApi() {
		assertTrue(couponsService instanceof CouponsService);
	}
	
	@Test
	public void CouponsServicePossedeUnCouponsDao() {
		assertTrue(couponsService.getCouponsDao() instanceof CouponsDao);
	}
	
	
}
