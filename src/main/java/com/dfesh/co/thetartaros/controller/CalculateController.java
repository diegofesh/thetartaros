package com.dfesh.co.thetartaros.controller;

import com.dfesh.co.thetartaros.dto.CalculateRequestDTO;
import com.dfesh.co.thetartaros.dto.CalculateResponseDTO;
import com.dfesh.co.thetartaros.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculate")
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateService calculateService;

//    public CalculateController(CalculateService calculateService) {
//        this.calculateService = calculateService;
//    }

    @PostMapping("/value")
    public CalculateResponseDTO calculateValue(@RequestBody CalculateRequestDTO requestDTO){
        return calculateService.calculate(requestDTO);
    }
}
