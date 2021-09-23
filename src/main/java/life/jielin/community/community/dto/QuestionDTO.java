package life.jielin.community.community.dto;

import life.jielin.community.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreated;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
