package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.response.LoanResponse;

import java.math.BigDecimal;

public interface LoanCalculatorService {
    LoanResponse calculateLoan(BigDecimal originatedAmount, BigDecimal interestRate, long loanTermMonths);
}
