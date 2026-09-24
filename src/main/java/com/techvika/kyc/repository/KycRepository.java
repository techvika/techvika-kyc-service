package com.techvika.kyc.repository;

import com.techvika.kyc.entity.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KycRepository extends JpaRepository<Kyc, Long> {
    Optional<Kyc> findByPanNumber(String panNumber);

    Optional<Kyc> findByUserId(Long userId);
}
