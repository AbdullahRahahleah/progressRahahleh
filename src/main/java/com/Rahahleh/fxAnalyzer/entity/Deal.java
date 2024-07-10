package com.Rahahleh.fxAnalyzer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     public DealDetail getDealDetail() {
        return dealDetail;
    }

    public void setDealDetail(DealDetail dealDetail) {
        this.dealDetail = dealDetail;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dealDetail_id", referencedColumnName = "id")
    private DealDetail dealDetail;

    private int fromCurrency;

    private int toCurrency;

    private String timestamp;

    private double amount;


    public int getFromCurrency() {
        return fromCurrency;
    }

    public int getToCurrency() {
        return toCurrency;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setFromCurrency(int fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(int toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
