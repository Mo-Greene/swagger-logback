package com.springboot.hallow.controller;

import com.springboot.hallow.data.dto.BoardDto;
import com.springboot.hallow.data.dto.BoardNameDto;
import com.springboot.hallow.data.dto.BoardResponseDto;
import com.springboot.hallow.service.BoardService;
import com.springboot.hallow.service.impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SwaggerController {

    private final BoardServiceImpl boardService;

    @GetMapping()
    public ResponseEntity<BoardResponseDto> getBoard(Long id) {
        BoardResponseDto boardResponseDto = boardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PostMapping()
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardDto boardDto) {
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardResponseDto);
    }

    @PutMapping()
    public ResponseEntity<BoardResponseDto> changeBoardTitle(
            @RequestBody BoardNameDto boardNameDto) throws Exception {
        BoardResponseDto boardResponseDto = boardService.changeBoardTitle(boardNameDto.getId(), boardNameDto.getTitle());

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBoard(Long id) throws Exception {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body("삭제되었습니다.");
    }
}
