package com.springboot.hallow.data.dao.impl;

import com.springboot.hallow.data.dao.BoardDAO;
import com.springboot.hallow.domain.Board;
import com.springboot.hallow.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public Board insertBoard(Board board) {
        Board insertBoard = boardRepository.save(board);
        return insertBoard;
    }

    @Override
    public Board selectBoard(Long id) {
        Board selectBoard = boardRepository.getById(id);
        return selectBoard;
    }

    @Override
    public Board updateBoardTitle(Long id, String title) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        Board updatedBoard;
        if (selectedBoard.isPresent()) {
            Board board = selectedBoard.get();

            board.setTitle(title);
            board.setUpdateAt(LocalDateTime.now());

            updatedBoard = boardRepository.save(board);
        } else {
            throw new Exception("조회되는 게시글이 없습니다.");
        }
        return updatedBoard;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        if (selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            boardRepository.delete(board);
        } else {
            throw new Exception("찾는 게시글이 없습니다.");
        }
    }
}
