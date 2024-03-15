package jp.ac.ohara.oharabank.model.form;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="login")
class Loginform{
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
}