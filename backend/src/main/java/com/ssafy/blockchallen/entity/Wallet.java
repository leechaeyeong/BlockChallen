package com.ssafy.blockchallen.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value="지갑 번호")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "account_id")
	@ApiModelProperty(required = true, value="회원 번호")
	private Account account;
	
	@ApiModelProperty(required = true, value="지갑 주소")
	private String address;

	@ApiModelProperty(required = true, value="지갑 잔고")
	private BigDecimal balance = BigDecimal.valueOf(0);
}
