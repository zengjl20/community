package life.jielin.community.community.mapper;

import life.jielin.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_created,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreated},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
