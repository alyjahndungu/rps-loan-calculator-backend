package com.alyjah.rps_loan_calculator.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class LoanDetails {
    private BigDecimal totalInterest;
    private BigDecimal totalCharges;
    private BigDecimal outstandingLoanAmount;
    private LocalDate endDate;
}
