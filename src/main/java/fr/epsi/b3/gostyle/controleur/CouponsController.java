package fr.epsi.b3.gostyle.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import fr.epsi.b3.gostyle.model.Coupon;
import fr.epsi.b3.gostyle.service.CouponsService;

@RestController
@RequestMapping("/api/coupons")
public class CouponsController {
	
	
	@Autowired
	private CouponsService couponsService;

	/**
	 * API - GET | Permet de récuperer les informations d'un coupon dans la base de donnée.
	 * @param code
	 * @return Coupon 
	 */
	
	@GetMapping(path = "/{code}", produces = "application/json")
	public Coupon getCoupon(@PathVariable String code) {
		return couponsService.getByCode(code);
	}
	
	/**
	 * API - POST | Permet de créer un nouveau coupon dans la base de donnée créé a partir de données transmises en JSON.
	 * @param coupon, uriBuilder
	 * @return ResponseEntity 
	 */
	
	@PostMapping(path = "/",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon, UriComponentsBuilder uriBuilder){
		couponsService.createOrUpdate(coupon);
		Coupon nCoupon = couponsService.getByCode(coupon.getCode());
		//URI uri = uriBuilder.path("api/coupons/" + Integer.toString(nCoupon.getCouponId()).build().toUri());
		return ResponseEntity.ok(nCoupon);
	}
	
	/**
	 * API - PUT | Permet de mettre à jour un coupon de la bdd à partir de données transmises en JSON.
	 * @param coupon
	 * @return ResponseEntity 
	 */
	
	@PutMapping(path = "/",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Coupon> updateCoupon(@RequestBody Coupon coupon){
		couponsService.createOrUpdate(coupon);
		Coupon nCoupon = couponsService.getByCode(coupon.getCode());
		return ResponseEntity.ok(nCoupon);
	}
	
	/**
	 * API - DELETE | Permet de supprimer un coupon de la bdd.
	 * @param code, uriBuilder
	 * @return ResponseEntity 
	 */
	
	@DeleteMapping(path = "/{code}")
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable String code,UriComponentsBuilder uriBuilder){
		couponsService.deleteByCode(code);
		return ResponseEntity.noContent().build();
	}
}
