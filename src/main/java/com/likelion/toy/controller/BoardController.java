package com.likelion.toy.controller;

import com.likelion.toy.entity.Board;
import com.likelion.toy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String write() {
        return "board_write";
    }

    @PostMapping("/board/write")
    public String write(Board board) {

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String list(Model model) {

        model.addAttribute("list", boardService.list());

        return "board_list";
    }

    @GetMapping("/board/view")
    public String view(Model model, Integer id) {
        model.addAttribute("board", boardService.view(id));
        return "board_view";
    }

    @GetMapping("/board/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.view(id));
        return "board_update";
    }

    @PostMapping("/board/update/{id}")
    public String update(@PathVariable("id") Integer id, Board board) {

        Board boardTemp = boardService.view(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }

    @GetMapping("/board/delete")
    public String delete(Integer id) {
        boardService.delete(id);
        return "redirect:/board/list";
    }

}
