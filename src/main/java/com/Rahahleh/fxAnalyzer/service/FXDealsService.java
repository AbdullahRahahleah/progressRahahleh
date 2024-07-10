package com.Rahahleh.fxAnalyzer.service;

import com.Rahahleh.fxAnalyzer.dto.DealDTO;
import com.Rahahleh.fxAnalyzer.entity.Deal;
import com.Rahahleh.fxAnalyzer.entity.DealDetail;
import com.Rahahleh.fxAnalyzer.repository.FXDealDetailsRepository;
import com.Rahahleh.fxAnalyzer.repository.FXDealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FXDealsService {

    @Autowired
    FXDealsRepository fxDealsRepository;
    @Autowired
    FXDealDetailsRepository fxDealDetailsRepository;

    HashSet<String> inMemorySet = new HashSet<>();

    private static final int MAXIMUM_MEMORY_SIZE = 1000;

    public DealDTO saveNewDeal(Deal deal) {
        String dealIdString =  deal.getDealDetail().getDealIdString();
        if(isNewDeal(dealIdString)){
               addToMemory(dealIdString);
            return DealMapper.mapToDealDTO(fxDealsRepository.save(deal));
        }
        return null;
    }

    private boolean isNewDeal(String dealIdString) {
        if(inMemorySet.contains(dealIdString)){
            return false;
        }else{
            inMemorySet.add(dealIdString);
        }
        return getDealByDealId(dealIdString) ==  null;
    }

    private void addToMemory(String dealIdString) {
        //if the set is full, we will remove 0.2 of the size
        //We can enchance this part by applying Least recently used algorithm
        if(inMemorySet.size() >= MAXIMUM_MEMORY_SIZE){
            inMemorySet.stream()
                    .limit((long) (MAXIMUM_MEMORY_SIZE*0.8))
                    .collect(Collectors.toSet());
        }
        inMemorySet.add(dealIdString);
    }

    public Deal getDealByDealId(String dealIdString) {
        List<Optional<Deal>> deals =fxDealsRepository.findDealByDealStringID(dealIdString);
        if(deals.isEmpty())
            return null;
        return deals.get(0).orElseGet(null); // or throw an exception if not found
    }
}
