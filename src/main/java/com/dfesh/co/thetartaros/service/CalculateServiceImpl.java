package com.dfesh.co.thetartaros.service;

import com.dfesh.co.thetartaros.dto.CalculateRequestDTO;
import com.dfesh.co.thetartaros.dto.CalculateResponseDTO;
import com.dfesh.co.thetartaros.repository.CalculateRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    private final CalculateRepository calculateRepository;

    public CalculateServiceImpl(CalculateRepository calculateRepository){
        this.calculateRepository = calculateRepository;
    }

    public CalculateResponseDTO calculate(CalculateRequestDTO requestDTO) {
        Double result = calculateRepository.callProcedure(requestDTO.getParameter());
        return new CalculateResponseDTO(result);
    }
}
