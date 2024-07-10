package com.Rahahleh.fxAnalyzer.controller;

import com.Rahahleh.fxAnalyzer.dto.DealDTO;
import com.Rahahleh.fxAnalyzer.service.DealMapper;
import com.Rahahleh.fxAnalyzer.service.FXDealsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/fxDeals/v1")
public class FXDealsController {

    @Autowired
    FXDealsService fxDealsService;

    @PostMapping("/saveDeal")
    public  ResponseEntity<DealDTO> saveNewDeal(@Valid @RequestBody  DealDTO dealDTO){
        DealDTO responseDTO = this.fxDealsService.saveNewDeal(DealMapper.mapToDeal(dealDTO));
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/getByDealId/{dealIDString}")
    public DealDTO getDealById(@PathVariable String dealIDString){
        return DealMapper.mapToDealDTO(this.fxDealsService.getDealByDealId(dealIDString));
    }

}
