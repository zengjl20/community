package life.jielin.community.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找的问题找不到了"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题"),
    NO_LOGIN(2003,"未登录"),
    SYS_ERROR(2004, "服务冒烟了，要不然你稍后再试试！！！"),
    TYPE_PARAM_WRONG(2005,"type参数为空"),
    COMMENT_NOT_FOUND(2006,"评论找不到了"),
    CONTENT_IS_EMPTY(2007, "输入不能为空");


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
