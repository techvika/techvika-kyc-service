package com.techvika.kyc.mapper;

import com.techvika.kyc.dto.KycRequest;
import com.techvika.kyc.dto.KycResponse;
import com.techvika.kyc.entity.KycDetails;
import com.techvika.kyc.entity.KycStatus;
import org.springframework.stereotype.Component;

@Component
public class KycMapper {

    public KycDetails toEntity(KycRequest kycRequest) {
        return KycDetails.builder()
                .userId(kycRequest.getUserId())
                .panNumber(kycRequest.getPanNumber())
                .status(KycStatus.PENDING)
                .build();
    }

    public KycResponse toResponse(KycDetails kycDetails) {
        return KycResponse.builder()
                .id(kycDetails.getId())
                .userId(kycDetails.getUserId())
                .panNumber(kycDetails.getPanNumber())
                .status(kycDetails.getStatus())
                .createdAt(kycDetails.getCreatedAt())
                .updatedAt(kycDetails.getUpdatedAt())
                .build();
    }
}
