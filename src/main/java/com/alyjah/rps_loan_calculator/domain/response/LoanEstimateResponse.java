package com.alyjah.rps_loan_calculator.domain.response;

import java.math.BigDecimal;
import java.util.List;

public record LoanEstimateResponse(BigDecimal originatedAmount, BigDecimal totalInterest, List<InstallmentResponse> installments) {
}
