package jp.ac.ohara.oharabank.model;

import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column
    private long id;
    
//	@Column( nullable=false)
//    private Integer balance;
	
	@Column(nullable=false)
	private Integer nyukin;
	
	@Column(nullable=false)
	private Integer syukin;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdat",nullable = false, updatable = false)
	private Date createdat;
	
	
	
//	public Integer getBalance() {
//		return balance;
//	}
//	public void setBalance(Integer balance) {
//		this.balance = balance;
//	}
}