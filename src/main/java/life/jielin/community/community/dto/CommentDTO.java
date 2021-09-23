package life.jielin.community.community.dto;

import life.jielin.community.community.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreated;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
