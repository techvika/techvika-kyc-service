package com.techvika.kyc.service.impl;

import com.techvika.kyc.dto.KycRequest;
import com.techvika.kyc.dto.KycResponse;
import com.techvika.kyc.entity.Kyc;
import com.techvika.kyc.exception.DuplicatePanException;
import com.techvika.kyc.mapper.KycMapper;
import com.techvika.kyc.repository.KycRepository;
import com.techvika.kyc.service.KycService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KycServiceImpl implements KycService {

    private final KycRepository kycRepository;
    private final KycMapper kycMapper;

    @Override
    public KycResponse submitKyc(KycRequest kycRequest) {
        // Check if PAN already exists
        if (kycRepository.findByPanNumber(kycRequest.getPanNumber()).isPresent()) {
            throw new DuplicatePanException("PAN number already exists in the system");
        }

        // Convert request to entity
        Kyc kyc = kycMapper.toKycEntity(kycRequest);

        // Save KYC details
        Kyc savedKycDetails = kycRepository.save(kyc);
        log.info("KycDetails saved successfully {}", savedKycDetails);

        // Convert to response
        return kycMapper.toKycResponse(savedKycDetails);
    }

    @Override
    public Optional<KycResponse> getKycById(Long id) {
        return kycRepository.findByUserId(id)
                .map(kycMapper::toKycResponse);
    }
}
