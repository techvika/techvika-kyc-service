package com.techvika.kyc.service;

import com.techvika.kyc.dto.KycRequest;
import com.techvika.kyc.dto.KycResponse;
import com.techvika.kyc.entity.Kyc;

import java.util.Optional;

public interface KycService {

    KycResponse submitKyc(KycRequest kycRequest);
    Optional<KycResponse> getKycById(Long id);
}
