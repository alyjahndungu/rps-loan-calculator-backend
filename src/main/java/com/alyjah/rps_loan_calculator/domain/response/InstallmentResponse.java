package com.alyjah.rps_loan_calculator.domain.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InstallmentResponse( int installmentNumber, BigDecimal installmentAmount, BigDecimal totalInstallmentInterest, BigDecimal outstandingAmount,  LocalDate startDate , LocalDate dueDate ) {
}
