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

	@GetMapping(path = "/{code}", produces = "application/json")
	public Coupon getCoupon(@PathVariable String code) {
		return couponsService.getByCode(code);
	}
	
	@PostMapping(path = "/",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon, UriComponentsBuilder uriBuilder){
		couponsService.createOrUpdate(coupon);
		Coupon nCoupon = couponsService.getByCode(coupon.getCode());
		//URI uri = uriBuilder.path("api/coupons/" + Integer.toString(nCoupon.getCouponId()).build().toUri());
		return ResponseEntity.ok(nCoupon);
	}
	
	@PutMapping(path = "/",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Coupon> updateCoupon(@RequestBody Coupon coupon){
		couponsService.createOrUpdate(coupon);
		Coupon nCoupon = couponsService.getByCode(coupon.getCode());
		return ResponseEntity.ok(nCoupon);
	}
	
	@DeleteMapping(path = "/{code}")
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable String code,UriComponentsBuilder uriBuilder){
		couponsService.deleteByCode(code);
		return ResponseEntity.noContent().build();
	}
}
