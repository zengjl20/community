package life.jielin.community.community.enums;

public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;

    public static boolean isExist(Integer type) {
        for(CommentTypeEnum commentTypeEnum: CommentTypeEnum.values()){
            if(type == commentTypeEnum.getType()){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
