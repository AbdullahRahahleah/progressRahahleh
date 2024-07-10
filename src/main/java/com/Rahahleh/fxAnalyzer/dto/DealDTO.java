package com.Rahahleh.fxAnalyzer.dto;

import com.Rahahleh.fxAnalyzer.tools.Currency;
import com.Rahahleh.fxAnalyzer.tools.DecimalContraint;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

public class DealDTO {

    private String dealId;
    private Double amount;

    @NotBlank (message = "deal is null")
    @DateTimeFormat
    private String dealTimestamp;

    @NotBlank (message = "from currency shouldn't be null")
    @Currency(message = "invalid currency value")
    private String fromCurrency;

    @NotBlank (message = "toCurrenct shouldn't be null")
    @Currency(message = "invalid currency value")
    private String toCurrency;


    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public String getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(String dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }
}
