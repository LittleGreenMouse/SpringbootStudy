package cn.littlegreenmouse.hello.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

// Article()
@NoArgsConstructor
// Article(id, name)
@AllArgsConstructor
// getters and setters, equals(), canEquals(), hashCode(), toString()
@Data
// Article.builder().id(id).author(name).build();
@Builder
@JsonPropertyOrder(value = {"id", "writer", "title", "readers", "content"})
public class ArticleVO {
    // @JsonIgnore
    private long id;

    // @JsonProperty("writer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String author;

    private String title;

    private String content;

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Reader> readers;
}
