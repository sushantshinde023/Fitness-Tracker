package com.project.fitness.controller;

import com.project.fitness.dto.TrackActivityRequestDto;
import com.project.fitness.dto.TrackActivityResponseDto;
import com.project.fitness.service.ActivityService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping
    public ResponseEntity<TrackActivityResponseDto> trackActivity(@RequestBody TrackActivityRequestDto request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }
    @GetMapping
    public ResponseEntity<List<TrackActivityResponseDto>> getUserActivities(@RequestHeader(value = "X-User-ID") Long userId){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
