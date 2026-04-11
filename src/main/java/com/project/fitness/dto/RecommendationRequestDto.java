package com.project.fitness.dto;

import java.util.List;

public record RecommendationRequestDto(
        Long userId,
        Long activityId,
        String type,
        String recommendation,
        List<String> improvements,
        List<String> suggestions,
        List<String> safety
) {
}
