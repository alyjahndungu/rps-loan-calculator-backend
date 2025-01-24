package com.alyjah.rps_loan_calculator.domain.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {
    private int installmentNumber;
    private BigDecimal principalAmount;
    private BigDecimal totalInstallmentInterest;
    private BigDecimal outstandingAmount;
    private LocalDate dueDate;

    public Installment(int installmentNumber, BigDecimal principalAmount, BigDecimal totalInstallmentInterest, BigDecimal outstandingAmount, LocalDate dueDate) {
        this.installmentNumber = installmentNumber;
        this.principalAmount = principalAmount;
        this.totalInstallmentInterest = totalInstallmentInterest;
        this.outstandingAmount = outstandingAmount;
        this.dueDate = dueDate;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        this.principalAmount = principalAmount;
    }

    public BigDecimal getTotalInstallmentInterest() {
        return totalInstallmentInterest;
    }

    public void setTotalInstallmentInterest(BigDecimal totalInstallmentInterest) {
        this.totalInstallmentInterest = totalInstallmentInterest;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "InstallmentResponse{" +
                "installmentNumber=" + installmentNumber +
                ", principalAmount=" + principalAmount +
                ", totalInstallmentInterest=" + totalInstallmentInterest +
                ", outstandingAmount=" + outstandingAmount +
                ", dueDate=" + dueDate +
                '}';
    }
}
