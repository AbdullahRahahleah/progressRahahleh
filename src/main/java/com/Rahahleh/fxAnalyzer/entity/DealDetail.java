package com.Rahahleh.fxAnalyzer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dealDetail")
public class DealDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String dealIdString;

    String fromCurrencyString;

    String toCurrencyString;

    @OneToOne(mappedBy = "dealDetail")
    private Deal deal;

    public Deal getDeal() {
        return deal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public int getId() {
        return id;
    }
    public String getDealIdString() {
        return dealIdString;
    }

    public void setDealIdString(String dealIdString) {
        this.dealIdString = dealIdString;
    }

    public String getFromCurrencyString() {
        return fromCurrencyString;
    }

    public void setFromCurrencyString(String fromCurrencyString) {
        this.fromCurrencyString = fromCurrencyString;
    }

    public String getToCurrencyString() {
        return toCurrencyString;
    }

    public void setToCurrencyString(String toCurrencyString) {
        this.toCurrencyString = toCurrencyString;
    }
}
