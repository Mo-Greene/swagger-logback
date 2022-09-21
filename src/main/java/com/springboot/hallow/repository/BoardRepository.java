package com.springboot.hallow.repository;

import com.springboot.hallow.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
