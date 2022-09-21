package com.springboot.hallow.service;

import com.springboot.hallow.data.dto.BoardDto;
import com.springboot.hallow.data.dto.BoardResponseDto;

public interface BoardService {

    BoardResponseDto getBoard(Long id);

    BoardResponseDto saveBoard(BoardDto boardDto);

    BoardResponseDto changeBoardTitle(Long id, String title) throws Exception;

    void deleteBoard(Long id) throws Exception;
}
