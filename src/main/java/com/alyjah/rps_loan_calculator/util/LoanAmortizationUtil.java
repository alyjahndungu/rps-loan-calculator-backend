package com.alyjah.rps_loan_calculator.util;

import com.alyjah.rps_loan_calculator.domain.response.Installment;
import com.alyjah.rps_loan_calculator.domain.response.Loan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanAmortizationUtil {
    public static final Integer AVG_DAYS_PER_MONTH = 30;

    public static Loan calculateLoanDetails(
            BigDecimal loanAmount,
            long loanTermMonths,
            BigDecimal interestRate,
            String paymentFrequency
    ) {

        long loanTermDays = loanTermMonths * AVG_DAYS_PER_MONTH;
        BigDecimal totalInterest = calculateTotalInterest(loanAmount, loanTermDays, interestRate);
        BigDecimal outstandingLoanAmount = calculateOutstandingLoanAmount(loanAmount, totalInterest);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = estimateEndDate(loanTermDays);
        List<Installment> installments = calculateInstallments(outstandingLoanAmount, loanAmount, loanTermDays, interestRate, paymentFrequency);
        return new Loan(loanAmount, interestRate, loanTermMonths, totalInterest, outstandingLoanAmount, startDate, endDate, installments);
    }


    public static BigDecimal calculateTotalInterest(BigDecimal originatedLoanAmount, long loanTermDays, BigDecimal interestRate) {
        BigDecimal percentageInterest = interestRate.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
        BigDecimal loanTerm = BigDecimal.valueOf(loanTermDays).divide(BigDecimal.valueOf(365.0), 2, RoundingMode.HALF_EVEN);
        return percentageInterest.multiply(originatedLoanAmount).multiply(loanTerm).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal calculateOutstandingLoanAmount(BigDecimal loanAmount, BigDecimal totalInterest) {
        BigDecimal outStandingLoanAmount = loanAmount.add(totalInterest);
        return outStandingLoanAmount.setScale(2, RoundingMode.HALF_EVEN);
    }


    public static LocalDate estimateEndDate(long loanTermDays) {
        return LocalDate.now().plusDays(loanTermDays);
    }


    public static List<Installment> calculateInstallments(
            BigDecimal outstandingLoanAmount,
            BigDecimal loanAmount,
            long loanTermDays,
            BigDecimal interestRate,
            String paymentFrequency
    ) {
        List<Installment> installments = new ArrayList<>();
        int numInstallments = calculateNumberOfInstallments(loanTermDays, paymentFrequency);
        LocalDate startDate = LocalDate.now();

        for (int i = 1; i <= numInstallments; i++) {
            BigDecimal installmentAmount = outstandingLoanAmount.divide(BigDecimal.valueOf(numInstallments), 2, RoundingMode.HALF_EVEN);
            BigDecimal percentageInterest = interestRate.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
            BigDecimal totalInstallmentInterest = percentageInterest.multiply(installmentAmount).setScale(2, RoundingMode.HALF_EVEN);

            BigDecimal principalPerInstallment = loanAmount.divide(BigDecimal.valueOf(numInstallments), 2, RoundingMode.HALF_EVEN);
            LocalDate dueDate = startDate.plusMonths(i);
            installments.add(new Installment(i, principalPerInstallment, totalInstallmentInterest, installmentAmount, dueDate));
        }
        return installments;
    }


    public static int calculateNumberOfInstallments(long loanTermDays, String paymentFrequency) {
        if (paymentFrequency.equals("MONTHLY")) {
            return (int) Math.ceil(loanTermDays / AVG_DAYS_PER_MONTH.doubleValue());
        }
        return 1;
    }

}
