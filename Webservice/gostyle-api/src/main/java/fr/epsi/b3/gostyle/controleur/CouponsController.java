package fr.epsi.b3.gostyle.controleur;

import java.net.URI;

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

	@GetMapping(path = "/{idCoupon}", produces = "application/json")
	public Coupon getCoupon(@PathVariable int id) {
		return couponsService.getById(id);
	}
	
	@PostMapping(path = "/",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon, UriComponentsBuilder uriBuilder){
		couponsService.createOrUpdate(coupon);
		Coupon nCoupon = couponsService.getById(coupon.getCouponId());
		//URI uri = uriBuilder.path("api/coupons/" + Integer.toString(nCoupon.getCouponId()).build().toUri());
		return ResponseEntity.ok(nCoupon);
	}
	
	@PutMapping(path = "/",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Coupon> updateCoupon(@RequestBody Coupon coupon){
		couponsService.createOrUpdate(coupon);
		Coupon nCoupon = couponsService.getById(coupon.getCouponId());
		return ResponseEntity.ok(nCoupon);
	}
	
	@DeleteMapping(path = "/{idCoupon}")
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable int id,UriComponentsBuilder uriBuilder){
		couponsService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
