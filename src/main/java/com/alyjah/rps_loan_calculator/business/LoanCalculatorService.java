package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.request.LoanEstimateRequest;

public interface LoanCalculatorService {
    void calculateLoan(LoanEstimateRequest request);
}
