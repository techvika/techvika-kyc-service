package com.techvika.kyc.repository;

import com.techvika.kyc.entity.KycDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KycRepository extends JpaRepository<KycDetails, Long> {
    Optional<KycDetails> findByPanNumber(String panNumber);

    Optional<KycDetails> findByUserId(Long userId);
}
