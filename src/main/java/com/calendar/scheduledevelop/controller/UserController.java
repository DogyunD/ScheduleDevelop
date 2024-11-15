package com.calendar.scheduledevelop.controller;

import com.calendar.scheduledevelop.dto.SignUpRequestDto;
import com.calendar.scheduledevelop.dto.SignUpResponseDto;
import com.calendar.scheduledevelop.dto.UserResponseDto;
import com.calendar.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.SignUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable long id) {
        UserResponseDto userResponseDto = userService.findbyId(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
