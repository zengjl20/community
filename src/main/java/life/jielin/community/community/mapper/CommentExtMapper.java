package life.jielin.community.community.mapper;

import life.jielin.community.community.model.Comment;
import life.jielin.community.community.model.CommentExample;
import life.jielin.community.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}