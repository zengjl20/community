package life.jielin.community.community.mapper;

import life.jielin.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Insert("insert into user (name, account_id, token, gmt_created, gmt_modified, avatar_url) values (#{name},#{accountId},#{token},#{gmtCreated},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(String token);
}
