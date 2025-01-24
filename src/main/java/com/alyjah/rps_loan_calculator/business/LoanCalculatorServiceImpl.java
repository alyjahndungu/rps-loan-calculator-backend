package com.alyjah.rps_loan_calculator.business;

import com.alyjah.rps_loan_calculator.domain.response.Loan;
import com.alyjah.rps_loan_calculator.domain.response.LoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.alyjah.rps_loan_calculator.util.LoanAmortizationUtil.calculateLoanDetails;

@Service
@RequiredArgsConstructor
public class LoanCalculatorServiceImpl implements LoanCalculatorService {
    @Override
    public LoanResponse calculateLoan(BigDecimal originatedAmount, BigDecimal interestRate, long loanTermMonths) {
        Loan loanDetail =  calculateLoanDetails(
                originatedAmount,
                loanTermMonths,
                interestRate,
                "MONTHLY"
        );

        return new LoanResponse(loanDetail);
    }
}
