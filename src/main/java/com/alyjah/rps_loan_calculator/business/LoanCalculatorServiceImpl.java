package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.request.LoanEstimateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanCalculatorServiceImpl implements LoanCalculatorService {
    @Override
    public void calculateLoan(LoanEstimateRequest request) {

    }
}
