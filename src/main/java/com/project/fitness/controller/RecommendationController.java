package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequestDto;
import com.project.fitness.dto.RecommendationResponseDto;
import com.project.fitness.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponseDto> generateRecommendation(@RequestBody RecommendationRequestDto request){
        RecommendationResponseDto recommendationResponseDto=recommendationService.generateReccommendation(request);
        return ResponseEntity.ok(recommendationResponseDto);
    }
}
