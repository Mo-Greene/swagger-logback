package com.springboot.hallow.data.dao;

import com.springboot.hallow.domain.Board;

public interface BoardDAO {

    Board insertBoard(Board board);

    Board selectBoard(Long id);

    Board updateBoardTitle(Long id, String title) throws Exception;

    void deleteBoard(Long id) throws Exception;
}
