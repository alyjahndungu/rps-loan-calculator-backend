package com.alyjah.rps_loan_calculator.api;

import com.alyjah.rps_loan_calculator.business.LoanCalculatorService;
import com.alyjah.rps_loan_calculator.domain.request.LoanEstimateRequest;
import com.alyjah.rps_loan_calculator.domain.response.LoanResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/loan/calculator")
public class LoanCalculatorController {

     final LoanCalculatorService loanCalculatorService;

    public LoanCalculatorController(LoanCalculatorService loanCalculatorService) {
        this.loanCalculatorService = loanCalculatorService;
    }

    @PostMapping
    public LoanResponse calculateLoan(@RequestBody LoanEstimateRequest request) {
        return loanCalculatorService.calculateLoan(request.originatedAmount(), request.interestRate(), request.loanTermMonths());
    }

}
