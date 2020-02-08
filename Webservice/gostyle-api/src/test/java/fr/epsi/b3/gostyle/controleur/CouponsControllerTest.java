package fr.epsi.b3.gostyle.controleur;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.epsi.b3.gostyle.service.CouponsService;

public class CouponsControllerTest {

	private CouponsController couponsController;
	
	@Before
	public void setUpTestRequirement() {
		couponsController = new CouponsController(); 
	}
	
	@Test
	public void CouponsControllerBienInitialiseAuLancementDeLApi() {
		assertTrue(couponsController instanceof CouponsController);
	}
	
	@Test
	public void CouponsControllerPossedeUnCouponsService() {
		assertTrue(couponsController.getCouponsService() instanceof CouponsService);
	}
	
	
	
}
