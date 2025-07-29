package com.dfesh.co.thetartaros.service;

import com.dfesh.co.thetartaros.dto.CalculateRequestDTO;
import com.dfesh.co.thetartaros.dto.CalculateResponseDTO;

public interface CalculateService {
    CalculateResponseDTO calculate(CalculateRequestDTO requestDTO);
}
