package life.jielin.community.community.utils;

public class RedisForKeyUtils {

    public static final String SPLIT = ":";
    public static final String PREFIX_ENTITY_LIKE = "like:entity";

    public static String getKeyForRedis(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }
}
