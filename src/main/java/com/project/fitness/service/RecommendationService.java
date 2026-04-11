package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequestDto;
import com.project.fitness.dto.RecommendationResponseDto;

import java.util.List;

public interface RecommendationService {
    RecommendationResponseDto generateReccommendation(RecommendationRequestDto request);

    List<RecommendationResponseDto> getUserRecommendation(Long userId);

    List<RecommendationResponseDto> getActivityRecommendation(Long activityId);
}
