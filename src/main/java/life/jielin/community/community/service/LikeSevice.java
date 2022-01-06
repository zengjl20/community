package life.jielin.community.community.service;

import life.jielin.community.community.utils.RedisForKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeSevice {

    @Autowired
    private RedisTemplate redisTemplate;

    public void like(int userId, int entityType, int entityId) {
        String entityLikeKey = RedisForKeyUtils.getKeyForRedis(entityType, entityId);
        boolean isMember = redisTemplate.opsForSet().isMember(entityLikeKey, userId);
        if(isMember) {
            redisTemplate.opsForSet().remove(entityLikeKey, userId);
        } else {
            redisTemplate.opsForSet().add(entityLikeKey, userId);
        }
    }

    public long getEntityLikeCount(int entityType, int entityId) {
        String entityLikeKey = RedisForKeyUtils.getKeyForRedis(entityType, entityId);
        return redisTemplate.opsForSet().size(entityLikeKey);
    }

    public int getEntityLikeStatus(int userId, int entityType, int entityId) {
        String entityLikeKey = RedisForKeyUtils.getKeyForRedis(entityType, entityId);
        return redisTemplate.opsForSet().isMember(entityLikeKey, userId)? 1: 0;
    }
}
