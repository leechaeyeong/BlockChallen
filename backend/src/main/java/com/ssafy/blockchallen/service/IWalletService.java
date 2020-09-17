package com.ssafy.blockchallen.service;

import com.ssafy.blockchallen.dto.walletDTO;
import com.ssafy.blockchallen.entity.Wallet;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Transactional;

public interface IWalletService {
	Wallet findById(long id);
	
	Wallet findByWallet(Wallet address);
	
	@Transactional
	Wallet create(walletDTO wallet, long id);

	@Transactional
	Wallet syncBalance(String walletAddress, BigDecimal balance, int cash);

	@Transactional
	Wallet requestEth(String walletAddress);

}
