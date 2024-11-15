package com.calendar.scheduledevelop.repository;

import com.calendar.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
