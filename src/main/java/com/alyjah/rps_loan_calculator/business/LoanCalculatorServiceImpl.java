package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.request.LoanEstimateRequest;
import com.alyjah.rps_loan_calculator.domain.response.LoanDetails;
import com.alyjah.rps_loan_calculator.domain.response.LoanEstimateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.alyjah.rps_loan_calculator.util.LoanAmortizationUtil.calculateLoanDetails;

@Service
@RequiredArgsConstructor
public class LoanCalculatorServiceImpl implements LoanCalculatorService {
    @Override
    public LoanEstimateResponse calculateLoan(BigDecimal originatedAmount, BigDecimal interestRate, long loanTermDays, String paymentFrequency) {
        LoanDetails loanDetail =  calculateLoanDetails(
                originatedAmount,
                loanTermDays,
                interestRate,
                paymentFrequency
        );

        return new LoanEstimateResponse(loanDetail);
    }
}
