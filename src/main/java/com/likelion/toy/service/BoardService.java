package com.likelion.toy.service;

import com.likelion.toy.entity.Board;
import com.likelion.toy.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void write(Board board) {
        boardRepository.save(board);
    }

    public List<Board> list() {
        return boardRepository.findAll();
    }

    // 특정 게시물 불러오기
    public Board view(Integer id) {

        return boardRepository.findById(id).get();
    }

    // 특정 게시물 삭제
    public void delete(Integer id) {
        boardRepository.deleteById(id);
    }

//    public void update()

}
