package fr.epsi.b3.gostyle.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {

	@Id
	private int couponId;
	private String codePromotionnel;
	private Date dateExpiration;
	private int tauxReduction;
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCodePromotionnel() {
		return codePromotionnel;
	}
	public void setCodePromotionnel(String codePromotionnel) {
		this.codePromotionnel = codePromotionnel;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public int getTauxReduction() {
		return tauxReduction;
	}
	public void setTauxReduction(int tauxReduction) {
		this.tauxReduction = tauxReduction;
	}

	
	
	
	
	
	
	
	
	
}
