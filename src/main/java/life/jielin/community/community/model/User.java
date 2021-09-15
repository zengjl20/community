package life.jielin.community.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String accountId;
    private String token;
    private String name;
    private String avatarUrl;
    private Long gmtCreated;
    private Long gmtModified;
}
