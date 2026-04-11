package com.project.fitness.mapper;

import com.project.fitness.dto.RecommendationRequestDto;
import com.project.fitness.dto.RecommendationResponseDto;
import com.project.fitness.model.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class RecommendationMapper {

    public Recommendation toEntity(RecommendationRequestDto request){
        Recommendation recommendation=new Recommendation();
        recommendation.setType(request.type());
        recommendation.setRecommendation(request.recommendation());
        recommendation.setSafety(request.safety());
        recommendation.setImprovements(request.improvements());
        recommendation.setSuggestions(request.suggestions());

        return recommendation;
    }

    public static RecommendationResponseDto toResponse(Recommendation recommendation){
        return new RecommendationResponseDto(
                recommendation.getId(),recommendation.getUser().getId(),recommendation.getActivity().getId(),recommendation.getType(),
                recommendation.getRecommendation(),recommendation.getImprovements(),recommendation.getSuggestions(),
                recommendation.getSafety(),recommendation.getCreatedAt(),recommendation.getUpdatedAt());

    }
}
