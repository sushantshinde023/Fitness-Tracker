package com.project.fitness.service;

import com.project.fitness.dto.TrackActivityRequestDto;
import com.project.fitness.dto.TrackActivityResponseDto;

import java.util.List;

public interface ActivityService {

    TrackActivityResponseDto trackActivity(TrackActivityRequestDto request);

    List<TrackActivityResponseDto> getUserActivities(Long userId);
}
