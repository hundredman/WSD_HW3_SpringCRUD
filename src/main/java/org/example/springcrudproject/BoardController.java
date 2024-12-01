package org.example.springcrudproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 목록 조회 (검색 기능 추가)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(@RequestParam(value = "search", required = false) String search,
                            @RequestParam(value = "searchBy", required = false, defaultValue = "title") String searchBy,
                            Model model) {
        List<BoardVO> list;

        if (search == null || search.isEmpty()) {
            list = boardService.getBoardList(); // 검색어가 없으면 전체 게시판 목록 조회
        } else {
            list = boardService.searchBoardList(search, searchBy); // 검색어와 기준이 있을 경우 검색
        }

        model.addAttribute("boardList", list);
        model.addAttribute("search", search); // 검색어를 JSP에 전달
        model.addAttribute("searchBy", searchBy); // 검색 기준을 JSP에 전달

        return "list";
    }

    // 게시글 작성 폼
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost() {
        return "write";
    }

    // 게시글 추가 처리
    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOK(BoardVO vo) {
        boolean isSuccess = boardService.addBoard(vo);
        if (!isSuccess) {
            System.out.println("데이터 추가 실패");
        } else {
            System.out.println("데이터 추가 성공!");
        }
        return "redirect:list";
    }

    // 게시글 수정 폼
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        // Service에서 게시글 상세 정보를 가져와 모델에 추가
        BoardVO vo = boardService.getBoard(id);
        model.addAttribute("boardVO", vo);
        return "edit";
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOK(BoardVO vo) {
        int i = boardService.updateBoard(vo);
        if (i == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공!");
        return "redirect:list";
    }

    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id) {
        int i = boardService.deleteBoard(id);
        if (i == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공!");
        return "redirect:../list";
    }

    // 게시글 상세보기
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable("id") int id, Model model) {
        BoardVO vo = boardService.getBoard(id); // 게시글 상세 정보 가져오기
        model.addAttribute("boardVO", vo);
        return "view"; // 상세보기 페이지로 이동
    }
}
