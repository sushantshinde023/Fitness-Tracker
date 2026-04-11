package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequestDto;
import com.project.fitness.dto.RecommendationResponseDto;

public interface RecommendationService {
    RecommendationResponseDto generateReccommendation(RecommendationRequestDto request);
}
