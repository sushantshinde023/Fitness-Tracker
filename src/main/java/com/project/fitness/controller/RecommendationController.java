package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequestDto;
import com.project.fitness.dto.RecommendationResponseDto;
import com.project.fitness.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponseDto>> getUserRecommendation(@PathVariable Long userId){
        List<RecommendationResponseDto> recommendationResponseDto=recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationResponseDto);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationResponseDto>> getActivityRecommendation(@PathVariable Long activityId){
        List<RecommendationResponseDto> recommendationResponseDto=recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationResponseDto);
    }
}
