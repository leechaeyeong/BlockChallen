package com.ssafy.blockchallen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Certification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = "인증 ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "challenge_id")
	@JsonManagedReference
	@ApiModelProperty(required = true, value = "챌린지 ID")
	private Challenge challenge;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	@JsonManagedReference
	@ApiModelProperty(required = true, value = "회원 계정 ID")
	private Account account;
	
	@ApiModelProperty(required = true, value = "인증 사진")
	@Column(name="picture", columnDefinition="MEDIUMBLOB")
	private byte[] picture;

	@Column(name = "reg_date")
	@ApiModelProperty(required = true, value = "등록시간")
	private String regDate;
	
	@Column(name = "is_reported")
	@ApiModelProperty(required = true, value = "신고여부")
	private Boolean isReported;
	
	@Column(name = "transaction_hash")
	@ApiModelProperty(required = true, value = "트랜잭션해쉬")
	private String transactionHash;
	
	@OneToOne
	@ApiModelProperty(value = "신고자")
	private Account reporter;
	
	public static class Builder {
		private Challenge challenge;
		private Account account;
		private byte[] picture;
		private String regDate;
		private Boolean isReported = false;
		private Account reporter;
		private String transactionHash;
		
		public Builder() {
			
		}
		public Builder challenge(Challenge challenge) {
			this.challenge = challenge;
			return this;
		}
		public Builder account(Account account) {
			this.account = account;
			return this;
		}
		public Builder picture(byte[] picture) {
			this.picture = picture;
			return this;
		}
		public Builder regDate(String regDate) {
			this.regDate = regDate;
			return this;
		}
		public Builder isReported(boolean isReported) {
			this.isReported = isReported;
			return this;
		}
		public Builder reporter(Account reporter) {
			this.reporter = reporter;
			return this;
		}
		public Builder transactionHash(String transactionHash) {
			this.transactionHash = transactionHash;
			return this;
		}
		public Certification build() {
			return new Certification(this);
		}
	}
	private Certification(Builder builder) {
		challenge = builder.challenge;
		account = builder.account;
		//picture = builder.picture;
		regDate = builder.regDate;
		isReported = builder.isReported;
		reporter = builder.reporter;
		transactionHash = builder.transactionHash;
	}
	
}
