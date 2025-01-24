package com.alyjah.rps_loan_calculator.domain.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LoanDetails {
    private BigDecimal totalInterest;
    private BigDecimal outstandingLoanAmount;
    private LocalDate endDate;
    private List<InstallmentResponse> installments;

    public LoanDetails(BigDecimal totalInterest, BigDecimal outstandingLoanAmount, LocalDate endDate, List<InstallmentResponse> installments) {
        this.totalInterest = totalInterest;
        this.outstandingLoanAmount = outstandingLoanAmount;
        this.endDate = endDate;
        this.installments = installments;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getOutstandingLoanAmount() {
        return outstandingLoanAmount;
    }

    public void setOutstandingLoanAmount(BigDecimal outstandingLoanAmount) {
        this.outstandingLoanAmount = outstandingLoanAmount;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<InstallmentResponse> getInstallments() {
        return installments;
    }

    public void setInstallments(List<InstallmentResponse> installments) {
        this.installments = installments;
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "totalInterest=" + totalInterest +
                ", outstandingLoanAmount=" + outstandingLoanAmount +
                ", endDate=" + endDate +
                ", installments=" + installments +
                '}';
    }
}
