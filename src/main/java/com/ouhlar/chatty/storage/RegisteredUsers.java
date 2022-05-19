package com.ouhlar.chatty.storage;

import com.ouhlar.chatty.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUsers extends JpaRepository<User, Long> {
}
