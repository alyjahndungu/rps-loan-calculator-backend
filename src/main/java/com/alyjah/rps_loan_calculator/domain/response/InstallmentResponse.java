package com.alyjah.rps_loan_calculator.domain.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InstallmentResponse {
    private int installmentNumber;
    private BigDecimal installmentAmount;
    private BigDecimal totalInstallmentInterest;
    private BigDecimal outstandingAmount;
    private LocalDate startDate;
    private LocalDate dueDate;

    public InstallmentResponse(int installmentNumber, BigDecimal installmentAmount, BigDecimal totalInstallmentInterest, BigDecimal outstandingAmount, LocalDate startDate, LocalDate dueDate) {
        this.installmentNumber = installmentNumber;
        this.installmentAmount = installmentAmount;
        this.totalInstallmentInterest = totalInstallmentInterest;
        this.outstandingAmount = outstandingAmount;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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
                ", installmentAmount=" + installmentAmount +
                ", totalInstallmentInterest=" + totalInstallmentInterest +
                ", outstandingAmount=" + outstandingAmount +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
