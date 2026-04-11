package com.project.fitness.service.impl;

import com.project.fitness.dto.RecommendationRequestDto;
import com.project.fitness.dto.RecommendationResponseDto;
import com.project.fitness.mapper.RecommendationMapper;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationMapper mapper;
    public RecommendationServiceImpl(RecommendationRepository recommendationRepository, UserRepository userRepository, ActivityRepository activityRepository,RecommendationMapper mapper) {
        this.recommendationRepository = recommendationRepository;
        this.userRepository=userRepository;
        this.activityRepository=activityRepository;
        this.mapper=mapper;
    }

    @Override
    public RecommendationResponseDto generateReccommendation(RecommendationRequestDto request) {
        User user=userRepository.findById(request.userId()).orElseThrow(()-> new RuntimeException("User not found "+request.userId()));
        Activity activity=activityRepository.findById(request.activityId()).orElseThrow(()-> new RuntimeException("Activity not found "+ request.activityId()));

        Recommendation recommendation=mapper.toEntity(request);
        recommendation.setUser(user);
        recommendation.setActivity(activity);

        Recommendation savedRecommendation=recommendationRepository.save(recommendation);
        return RecommendationMapper.toResponse(savedRecommendation);
    }

    @Override
    public List<RecommendationResponseDto> getUserRecommendation(Long userId) {
        List<Recommendation> recommendationList=recommendationRepository.findByUserId(userId);
        return recommendationList.stream().map(RecommendationMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<RecommendationResponseDto> getActivityRecommendation(Long activityId) {
        List<Recommendation> recommendationList=recommendationRepository.findByActivityId(activityId);
        return recommendationList.stream().map(RecommendationMapper::toResponse).collect(Collectors.toList());
    }
}
