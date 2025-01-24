package com.alyjah.rps_loan_calculator.domain.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Loan {
    private BigDecimal originatedAmount;
    private BigDecimal interestRate;
    private long loanTermMonths;
    private BigDecimal totalInterest;
    private BigDecimal outstandingLoanAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Installment> installments;

    public Loan(BigDecimal originatedAmount, BigDecimal interestRate, long loanTermMonths, BigDecimal totalInterest, BigDecimal outstandingLoanAmount, LocalDate startDate, LocalDate endDate, List<Installment> installments) {
        this.originatedAmount = originatedAmount;
        this.interestRate = interestRate;
        this.loanTermMonths = loanTermMonths;
        this.totalInterest = totalInterest;
        this.outstandingLoanAmount = outstandingLoanAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.installments = installments;
    }

    public BigDecimal getOriginatedAmount() {
        return originatedAmount;
    }

    public void setOriginatedAmount(BigDecimal originatedAmount) {
        this.originatedAmount = originatedAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public long getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(long loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "originatedAmount=" + originatedAmount +
                ", interestRate=" + interestRate +
                ", loanTermMonths=" + loanTermMonths +
                ", totalInterest=" + totalInterest +
                ", outstandingLoanAmount=" + outstandingLoanAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", installments=" + installments +
                '}';
    }
}
