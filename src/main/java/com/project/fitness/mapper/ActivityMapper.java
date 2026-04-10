package com.project.fitness.mapper;

import com.project.fitness.dto.TrackActivityRequestDto;
import com.project.fitness.dto.TrackActivityResponseDto;
import com.project.fitness.model.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    public Activity toEntity(TrackActivityRequestDto request){

        Activity activity =new Activity();
        activity.setType(request.type());
        activity.setDuration(request.duration());
        activity.setCaloriesBurned(request.caloriesBurned());
        activity.setStartTime(request.startTime());
        activity.setAdditionalMetrics(request.additionalMetrics());

        return activity;

    }

    public TrackActivityResponseDto toResponse(Activity activity){
        return new TrackActivityResponseDto(activity.getId(),activity.getUser().getId(),activity.getType(),activity.getAdditionalMetrics(),activity.getDuration(),activity.getCaloriesBurned(),activity.getStartTime(),activity.getCreatedAt(),activity.getUpdatedAt());
    }
}
