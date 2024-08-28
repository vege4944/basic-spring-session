package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entity.Board;
import com.sparta.basicspringsession.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveResponseDto saveBoard (@RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        Board newBoard = new Board(
                boardSaveRequestDto.getTitle(),
                boardSaveRequestDto.getContents()
        );

        Board saveBoard = boardRepository.save(newBoard);

        return new BoardSaveResponseDto(
                saveBoard.getId(),
                saveBoard.getTitle(),
                saveBoard.getContents()
        );
    }

    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(board.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public BoardDetailResponseDto getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("보드노노"));

        return new BoardDetailResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContents()
        );
    }

    @Transactional
    public BoardUpdateTitleResponseDto updateTitle(
            Long boardId,
            BoardUpdateTitleRequestDto boardUpdateTitleRequestDto
    ) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("보드노노"));

        board.updateTitle(boardUpdateTitleRequestDto.getTitle());

        return new BoardUpdateTitleResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContents()
        );
    }

    @Transactional
    public BoardUpdateContentsResponseDto updateContents(
            Long boardId,
            BoardUpdateContentsRequestDto boardUpdateContentsRequestDto
    ) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("보드노노"));

        board.updateContents(board.getContents());

        return new BoardUpdateContentsResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContents()
        );
    }

    @Transactional
    public void deleteBoard(Long boardId) {

        boardRepository.deleteById(boardId);
    }

}
