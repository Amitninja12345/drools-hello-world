package com.ofbizian.drools.domain;

public class Order {
  private String id;
  private Country country;
  private double amount;
  private long processId;
  
  // rule setters
  private boolean riskCheck;
  private String riskStatus;
  private String riskReason;

    public Order() {
    }

    public Order(double amount, Country country) {
        this.amount = amount;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getProcessId() {
        return processId;
    }

    public void setProcessId(long processId) {
        this.processId = processId;
    }

    public boolean isRiskCheck() {
        return riskCheck;
    }

    public void setRiskCheck(boolean riskCheck) {
        this.riskCheck = riskCheck;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public String getRiskReason() {
        return riskReason;
    }

    public void setRiskReason(String riskReason) {
        this.riskReason = riskReason;
    }
}
