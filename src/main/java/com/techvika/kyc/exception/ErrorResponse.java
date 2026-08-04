package com.techvika.kyc.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private int status;

    private String message;

    @JsonProperty("error_details")
    private String errorDetails;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;
}
