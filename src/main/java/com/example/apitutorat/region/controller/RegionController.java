package com.example.apitutorat.region.controller;

import com.example.apitutorat.region.Region;
import com.example.apitutorat.region.services.RegionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/region/")
public class RegionController {
    @Autowired
    RegionServiceImp regionServiceImp;

    @PostMapping("add")
    public Region addRegion(@RequestBody Region region){
        return  regionServiceImp.addRegion(region);
    }

    @GetMapping("liste")
    public List<Region> list(){
        return regionServiceImp.liste();
    }
}
