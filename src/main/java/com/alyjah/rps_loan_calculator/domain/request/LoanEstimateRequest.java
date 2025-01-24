package com.alyjah.rps_loan_calculator.domain.request;

import java.math.BigDecimal;

public record LoanEstimateRequest(BigDecimal originatedAmount, double interestRate, long loanTerm) {
}
