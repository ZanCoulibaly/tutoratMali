package com.example.apitutorat.region.services;

import com.example.apitutorat.region.Region;
import com.example.apitutorat.region.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImp implements RegionService{
    @Autowired
    RegionRepository regionRepository;
    @Override
    public Region addRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> liste() {
        return regionRepository.findAll();
    }
}
