package life.jielin.community.community.mapper;

import life.jielin.community.community.model.Question;
import life.jielin.community.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    int incViewTest(Question record);

    List<Question> selectRelated(Question question);
}