package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;

import java.time.LocalDateTime;
import java.util.Map;

public record TrackActivityResponseDto(
        Long id,
        Long userId,
        ActivityType type,
        Map<String, Object> additionalMetrics,
        Integer duration,
        Integer caloriesBurned,
        LocalDateTime startTime,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
