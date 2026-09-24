package com.techvika.kyc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kyc {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kycSeqGenerator")
    @SequenceGenerator(name = "kycSeqGenerator", sequenceName = "kycSeq", allocationSize = 1)
    @JsonIgnore
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "pan_number", nullable = false, unique = true)
    private String panNumber;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private KycStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
