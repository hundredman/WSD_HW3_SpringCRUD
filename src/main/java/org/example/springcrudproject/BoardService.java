package org.example.springcrudproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired
    private BoardDAO boardDAO;

    // 게시판 목록 가져오기
    public List<BoardVO> getBoardList() {
        List<BoardVO> originalList = boardDAO.getBoardList();

        // 날짜 포맷 적용
        return originalList.stream().map(board -> {
            if (board.getRegdate() != null) {
                String formattedDate = board.getRegdate()
                        .toLocalDateTime()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                board.setFormattedRegdate(formattedDate); // 포맷된 날짜 설정
            }
            return board;
        }).collect(Collectors.toList());
    }

    // 게시글 상세 조회
    public BoardVO getBoard(int id) {
        BoardVO board = boardDAO.getBoard(id);

        // 날짜 포맷 적용
        if (board.getRegdate() != null) {
            String formattedDate = board.getRegdate()
                    .toLocalDateTime()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            board.setFormattedRegdate(formattedDate);
        }

        return board;
    }

    // 게시글 추가
    public boolean addBoard(BoardVO vo) {
        int result = boardDAO.insertBoard(vo);
        return result > 0; // 성공 여부 반환
    }

    public int updateBoard(BoardVO vo) {
        int result = boardDAO.updateBoard(vo);
        return result;
    }

    public int deleteBoard(int id) {
        int result = boardDAO.deleteBoard(id);
        return result;
    }

    // 검색 기능 수정: 검색 기준(searchBy)에 따라 처리
    public List<BoardVO> searchBoardList(String search, String searchBy) {
        List<BoardVO> originalList = boardDAO.searchBoardList(search, searchBy);

        // 날짜 포맷 적용
        return originalList.stream().map(board -> {
            if (board.getRegdate() != null) {
                String formattedDate = board.getRegdate()
                        .toLocalDateTime()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                board.setFormattedRegdate(formattedDate); // 포맷된 날짜 설정
            }
            return board;
        }).collect(Collectors.toList());
    }
}
