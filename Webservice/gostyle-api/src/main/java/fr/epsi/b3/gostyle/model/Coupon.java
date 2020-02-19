package fr.epsi.b3.gostyle.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {

	@Id
	private String code;
	private Date dateExpiration;
	private int taux;
	private BigDecimal remise;
	private Boolean status;
	
	public String getCode() {
		return code;
	}
	public void setCodePromotionnel(String code) {
		this.code = code;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public int getTaux() {
		return taux;
	}
	public void setTaux(int taux) {
		this.taux = taux;
	}
	public BigDecimal getRemise() {
		return remise;
	}
	public void setRemise(BigDecimal remise) {
		this.remise = remise;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
