package com.techvika.kyc.service;

import com.techvika.kyc.dto.KycRequest;
import com.techvika.kyc.dto.KycResponse;

public interface KycService {

    KycResponse submitKyc(KycRequest kycRequest);
}
