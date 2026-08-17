package com.techvika.kyc.restcontroller;

import com.techvika.kyc.dto.KycRequest;
import com.techvika.kyc.dto.KycResponse;
import com.techvika.kyc.service.KycService;
import com.techvika.kyc.service.impl.KycServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/kyc")
@RequiredArgsConstructor
@Tag(name = "KYC Management", description = "APIs for KYC (Know Your Customer) operations")
public class KycRestController {

    private final KycService kycService;

    @PostMapping
    @Operation(summary = "Submit KYC details", description = "Submit KYC details for a user with PAN number validation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "KYC submitted successfully",
                    content = @Content(schema = @Schema(implementation = KycResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid KYC request - validation failed"),
            @ApiResponse(responseCode = "409", description = "Duplicate PAN number"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<KycResponse> submitKyc(@Valid @RequestBody KycRequest kycRequest) {
        KycResponse response = kycService.submitKyc(kycRequest);
        log.info("KycResponse submitted successfully {}", response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
