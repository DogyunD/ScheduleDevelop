package com.calendar.scheduledevelop.controller;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.calendar.scheduledevelop.ScheduleService.ScheduleService;
import com.calendar.scheduledevelop.dto.CreateScheduleRequestDto;
import com.calendar.scheduledevelop.dto.ScheduleResponseDto;
import com.calendar.scheduledevelop.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getUsername(),
                        requestDto.getTitle(),
                        requestDto.getDescription()
                );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
