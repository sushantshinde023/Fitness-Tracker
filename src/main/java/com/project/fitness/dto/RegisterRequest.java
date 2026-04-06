package com.project.fitness.dto;

public record RegisterRequest(
        String email,
        String password,
        String firstName,
        String lastName
) {
}
