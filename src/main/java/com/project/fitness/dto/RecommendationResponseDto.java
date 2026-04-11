package com.project.fitness.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record RecommendationResponseDto(
        Long id,
        Long userId,
        Long activityId,
        String type,
        String recommendation,
        List<String> improvements,
        List<String> suggestions,
        List<String> safety,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {

}
