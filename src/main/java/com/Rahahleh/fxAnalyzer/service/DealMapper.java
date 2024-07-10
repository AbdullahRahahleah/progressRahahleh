package com.Rahahleh.fxAnalyzer.service;

import com.Rahahleh.fxAnalyzer.tools.CurrencyEnum;
import com.Rahahleh.fxAnalyzer.dto.DealDTO;
import com.Rahahleh.fxAnalyzer.entity.Deal;
import com.Rahahleh.fxAnalyzer.entity.DealDetail;


public class DealMapper {

    public static DealDTO mapToDealDTO(Deal deal){
        DealDTO dealDTO = new DealDTO();
        dealDTO.setFromCurrency(CurrencyEnum.getById(deal.getFromCurrency()).name());
        dealDTO.setToCurrency(CurrencyEnum.getById(deal.getToCurrency()).name());
        dealDTO.setDealTimestamp(deal.getTimestamp());
        dealDTO.setAmount(deal.getAmount());
        dealDTO.setDealId(deal.getDealDetail().getDealIdString());
        return dealDTO;
    }

    public static Deal mapToDeal(DealDTO dealDTO){
        Deal deal = new Deal();
        DealDetail dealDetail = new DealDetail();
        dealDetail.setDealIdString(dealDTO.getDealId());
        dealDetail.setFromCurrencyString(dealDTO.getFromCurrency());
        dealDetail.setToCurrencyString(dealDTO.getToCurrency());
        dealDetail.setDeal(deal);
        deal.setDealDetail(dealDetail);
        deal.setAmount(dealDTO.getAmount());
        deal.setFromCurrency(CurrencyEnum.valueOf(dealDTO.getFromCurrency()).getId());
        deal.setToCurrency(CurrencyEnum.valueOf(dealDTO.getToCurrency()).getId());
        deal.setTimestamp(dealDTO.getDealTimestamp());
        return deal;
    }
}
