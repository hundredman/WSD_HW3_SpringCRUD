package org.example.springcrudproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String POST_INSERT = "insert into post (category, title, writer, content) values (?, ?, ?, ?)";
    private final String POST_UPDATE = "update post set category = ?, title = ?, writer = ?, content = ? where id = ?";
    private final String POST_DELETE = "delete from post where id = ?";
    private final String POST_GET = "select * from post where id = ?";
    private final String POST_LIST = "select * from post order by id desc";

    public int insertBoard(BoardVO vo) {
        return jdbcTemplate.update(POST_INSERT,
                new Object[]{vo.getCategory(), vo.getTitle(), vo.getWriter(), vo.getContent()});
    }

    public int updateBoard(BoardVO vo) {
        return jdbcTemplate.update(POST_UPDATE,
                new Object[]{vo.getCategory(), vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getId()});
    }

    public int deleteBoard(int id) {
        return jdbcTemplate.update(POST_DELETE,
                new Object[]{id});
    }

    public BoardVO getBoard(int id) {
        return jdbcTemplate.queryForObject(POST_GET,
                new Object[]{id},
                new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public List<BoardVO> getBoardList() {
        return jdbcTemplate.query(POST_LIST,
                new BeanPropertyRowMapper<>(BoardVO.class));
    }

    public List<BoardVO> searchBoardList(String search, String searchBy) {
        List<BoardVO> list = new ArrayList<>();

        String query = "";
        switch (searchBy) {
            case "category":
                query = "SELECT * FROM post WHERE category LIKE ? ORDER BY id DESC";
                break;
            case "title":
                query = "SELECT * FROM post WHERE title LIKE ? ORDER BY id DESC";
                break;
            case "writer":
                query = "SELECT * FROM post WHERE writer LIKE ? ORDER BY id DESC";
                break;
            case "content":
                query = "SELECT * FROM post WHERE content LIKE ? ORDER BY id DESC";
                break;
            default:
                query = "SELECT * FROM post ORDER BY id DESC"; // 기본값: 전체 조회
                break;
        }

        list = jdbcTemplate.query(query, new Object[]{"%" + search + "%"},
                new BeanPropertyRowMapper<>(BoardVO.class));
        return list;
    }

}
