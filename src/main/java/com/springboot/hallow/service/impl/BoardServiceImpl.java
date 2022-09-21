package com.springboot.hallow.service.impl;

import com.springboot.hallow.data.dao.BoardDAO;
import com.springboot.hallow.data.dto.BoardDto;
import com.springboot.hallow.data.dto.BoardResponseDto;
import com.springboot.hallow.domain.Board;
import com.springboot.hallow.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;
    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardResponseDto getBoard(Long id) {
        Board board = boardDAO.selectBoard(id);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(board.getId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setId(board.getId());
        board.setTitle(board.getTitle());
        board.setContents(board.getContents());
        board.setCreateAt(board.getCreateAt());
        board.setUpdateAt(board.getUpdateAt());

        Board saveBoard = boardDAO.insertBoard(board);
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(saveBoard.getId());
        boardResponseDto.setTitle(saveBoard.getTitle());
        boardResponseDto.setContents(saveBoard.getContents());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto changeBoardTitle(Long id, String title) throws Exception {
        Board changeBoard = boardDAO.updateBoardTitle(id, title);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(changeBoard.getId());
        boardResponseDto.setTitle(changeBoard.getTitle());

        return boardResponseDto;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        boardDAO.deleteBoard(id);
    }
}
