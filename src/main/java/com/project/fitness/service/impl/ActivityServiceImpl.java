package com.project.fitness.service.impl;

import com.project.fitness.dto.TrackActivityRequestDto;
import com.project.fitness.dto.TrackActivityResponseDto;
import com.project.fitness.mapper.ActivityMapper;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.ActivityService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private  final ActivityMapper mapper;

    public ActivityServiceImpl(ActivityRepository activityRepository, UserRepository userRepository,ActivityMapper mapper) {
        this.activityRepository = activityRepository;
        this.userRepository=userRepository;
        this.mapper=mapper;
    }

    @Override
    public TrackActivityResponseDto trackActivity(TrackActivityRequestDto request) {

        User user= userRepository.findById(request.userId()).orElseThrow(()-> new RuntimeException("Invalid user : "+request.userId()));
        Activity activityToSave=mapper.toEntity(request);
        activityToSave.setUser(user);
        //activityToSave.setCreatedAt(LocalDateTime);
        Activity savedActivity=activityRepository.save(activityToSave);

        return mapper.toResponse(savedActivity);
    }

    @Override
    public List<TrackActivityResponseDto> getUserActivities(Long userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Invalid user : "+userId));
        List<Activity> activityList=new ArrayList<>();
        if(user.getId()!=null){
            activityList=activityRepository.findByUserId(userId);
        }
        return activityList.stream().map(activity->mapper.toResponse(activity)).toList();
    }
//
//    @Override
//    public List<TrackActivityResponseDto> trackActivity(TrackActivityRequestDto request) {
//
//        User user= userRepository.findById(request.userId()).orElseThrow(()-> new RuntimeException("Invalid user : "+request.userId()));
//        Activity activityToSave=mapper.toEntity(request);
//        activityToSave.setUser(user);
//        //activityToSave.setCreatedAt(LocalDateTime);
//        Activity savedActivity=activityRepository.save(activityToSave);
//
//        return mapper.toResponse(savedActivity);
//    }


}
