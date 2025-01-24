package com.alyjah.rps_loan_calculator.util;

import com.alyjah.rps_loan_calculator.domain.response.InstallmentResponse;
import com.alyjah.rps_loan_calculator.domain.response.LoanDetails;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanAmortizationUtil {
    public static final Integer AVG_DAYS_PER_MONTH = 30;

    public static LoanDetails calculateLoanDetails(
            BigDecimal loanAmount,
            long loanTermDays,
            BigDecimal interestRate,
            String paymentFrequency
    ) {

        BigDecimal totalInterest = calculateTotalInterest(loanAmount, loanTermDays, interestRate);
        BigDecimal totalCharges = calculateTotalCharges(loanAmount, loanCharges);
        BigDecimal outstandingLoanAmount = calculateOutstandingLoanAmount(loanAmount, totalInterest, totalCharges, chargePaymentOption);
        LocalDate endDate = estimateEndDate(loanTermDays);
        BigDecimal totalDepositAmount = calculateTotalDepositAmount(outstandingLoanAmount, loanTermDays, paymentFrequency, chargePaymentOption, totalCharges);
        List<InstallmentT> installments = calculateInstallments(outstandingLoanAmount, loanAmount, loanTermDays, interestRate, penaltyRate, paymentFrequency, gracePeriodDays);

        return new LoanDetails(totalInterest, totalCharges, outstandingLoanAmount, endDate, totalDepositAmount, installments);
    }


    public static BigDecimal calculateTotalInterest(BigDecimal originatedLoanAmount, long loanTermDays, BigDecimal interestRate) {
        BigDecimal percentageInterest = interestRate.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
        BigDecimal loanTerm = BigDecimal.valueOf(loanTermDays).divide(BigDecimal.valueOf(365.0), 2, RoundingMode.HALF_EVEN);
        return percentageInterest.multiply(originatedLoanAmount).multiply(loanTerm).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal calculateOutstandingLoanAmount(
            BigDecimal loanAmount,
            BigDecimal totalInterest
    ) {
        BigDecimal outStandingLoanAmount = loanAmount.add(totalInterest);

        return outStandingLoanAmount.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static LocalDate estimateEndDate(long loanTermDays) {
        return LocalDate.now().plusDays(loanTermDays);
    }


    public static List<InstallmentResponse> calculateInstallments(
            BigDecimal outstandingLoanAmount,
            BigDecimal loanAmount,
            long loanTermDays,
            BigDecimal interestRate,
            BigDecimal penaltyRate,
            String paymentFrequency,
            int gracePeriodDays
    ) {
        List<InstallmentResponse> installments = new ArrayList<>();
        int numInstallments = determineNumberOfInstallments(loanTermDays, paymentFrequency);
        LocalDate startDate = LocalDate.now();

        for (int i = 1; i <= numInstallments; i++) {
            BigDecimal installmentAmount = outstandingLoanAmount.divide(BigDecimal.valueOf(numInstallments), 2, RoundingMode.HALF_EVEN);

            BigDecimal percentageInterest = interestRate.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
            BigDecimal totalInstallmentInterest = percentageInterest.multiply(installmentAmount).setScale(2, RoundingMode.HALF_EVEN);

            BigDecimal principalPerInstallment = loanAmount.divide(BigDecimal.valueOf(numInstallments), 2, RoundingMode.HALF_EVEN);
            LocalDate dueDate = startDate.plusMonths(i);
            LocalDate gracePeriodDueDate = dueDate.plusDays(gracePeriodDays);
            installments.add(new InstallmentResponse(i, installmentAmount, totalInstallmentInterest, BigDecimal.valueOf(0.00), principalPerInstallment, startDate, dueDate, gracePeriodDueDate));
        }
        return installments;
    }


    public static int determineNumberOfInstallments(long loanTermDays, String paymentFrequency) {
        if (paymentFrequency.equals("MONTHLY")) {
            return (int) Math.ceil(loanTermDays / AVG_DAYS_PER_MONTH.doubleValue());
        }
        return 1;
    }
}
