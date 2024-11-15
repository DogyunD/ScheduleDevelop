package com.calendar.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto{

    private final String username;

    private final String title;

    private final String description;


    public CreateScheduleRequestDto(String username, String title, String description) {
        this.username = username;
        this.title = title;
        this.description = description;
    }
}
