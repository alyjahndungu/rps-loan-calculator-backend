package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.request.LoanEstimateRequest;
import com.alyjah.rps_loan_calculator.domain.response.LoanDetails;
import com.alyjah.rps_loan_calculator.domain.response.LoanEstimateResponse;

import java.math.BigDecimal;

public interface LoanCalculatorService {
    LoanEstimateResponse calculateLoan(BigDecimal originatedAmount, BigDecimal interestRate, long loanTermDays, String paymentFrequency);
}
