package com.ssafy.blockchallen.service;

import com.ssafy.blockchallen.entity.Certification;

public interface ICertificationService {
	Certification register(long userId, long challengeId, String picture, String regDate);
	
	Certification report(long id);
}
