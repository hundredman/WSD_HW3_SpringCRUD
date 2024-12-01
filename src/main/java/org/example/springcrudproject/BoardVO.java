package org.example.springcrudproject;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class BoardVO {
    private int id;
    private String category;
    private String title;
    private String writer;
    private String content;
    private Timestamp regdate;
    private String formattedRegdate;

    public BoardVO(String category, String title, String writer, String content) {
        this.category = category;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
