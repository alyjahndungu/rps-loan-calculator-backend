package com.alyjah.rps_loan_calculator.api;

import com.alyjah.rps_loan_calculator.business.LoanCalculatorService;
import com.alyjah.rps_loan_calculator.domain.request.LoanEstimateRequest;
import com.alyjah.rps_loan_calculator.domain.response.LoanEstimateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        value = "/api/v1/loan/calculator",
        produces = {"application/json; charset=utf-8"},
        consumes = {"application/json"})
public class LoanCalculatorController {

    private final LoanCalculatorService loanCalculatorService;

    @PostMapping
    public LoanEstimateResponse calculateLoan(@RequestBody LoanEstimateRequest request){
        loanCalculatorService.calculateLoan(request);
    }

}
