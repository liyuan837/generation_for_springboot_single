package com.gen.dao.attach;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class RedisServiceGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.servicePackage + ";\r\n\r\n")








                .append("import org.springframework.beans.factory.annotation.Autowired;\r\n")
                .append("import org.springframework.data.redis.core.*;\r\n")
                .append("import org.springframework.stereotype.Service;\r\n")
                .append("import java.io.Serializable;\r\n")
                .append("import java.util.List;\r\n")
                .append("import java.util.Set;\r\n")
                .append("import java.util.concurrent.TimeUnit;\r\n\n")

                .append("/**\n" +
                        " * @Description:\n" +
                        " */\n" +
                        "@Service\n" +
                        "public class RedisService {\n" +
                        "\n" +
                        "    @Autowired\n" +
                        "    private RedisTemplate redisTemplate;\n" +
                        "    /**\n" +
                        "     * 写入缓存\n" +
                        "     * @param key\n" +
                        "     * @param value\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public boolean set(final String key, Object value) {\n" +
                        "        boolean result = false;\n" +
                        "        try {\n" +
                        "            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();\n" +
                        "            operations.set(key, value);\n" +
                        "            result = true;\n" +
                        "        } catch (Exception e) {\n" +
                        "            e.printStackTrace();\n" +
                        "        }\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 写入缓存设置时效时间\n" +
                        "     * @param key\n" +
                        "     * @param value\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public boolean set(final String key, Object value, Long expireTime) {\n" +
                        "        boolean result = false;\n" +
                        "        try {\n" +
                        "            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();\n" +
                        "            operations.set(key, value);\n" +
                        "            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);\n" +
                        "            result = true;\n" +
                        "        } catch (Exception e) {\n" +
                        "            e.printStackTrace();\n" +
                        "        }\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 批量删除对应的value\n" +
                        "     * @param keys\n" +
                        "     */\n" +
                        "    public void remove(final String... keys) {\n" +
                        "        for (String key : keys) {\n" +
                        "            remove(key);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 批量删除key\n" +
                        "     * @param pattern\n" +
                        "     */\n" +
                        "    public void removePattern(final String pattern) {\n" +
                        "        Set<Serializable> keys = redisTemplate.keys(pattern);\n" +
                        "        if (keys.size() > 0)\n" +
                        "            redisTemplate.delete(keys);\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 删除对应的value\n" +
                        "     * @param key\n" +
                        "     */\n" +
                        "    public void remove(final String key) {\n" +
                        "        if (exists(key)) {\n" +
                        "            redisTemplate.delete(key);\n" +
                        "        }\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 判断缓存中是否有对应的value\n" +
                        "     * @param key\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public boolean exists(final String key) {\n" +
                        "        return redisTemplate.hasKey(key);\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 读取缓存\n" +
                        "     * @param key\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public Object get(final String key) {\n" +
                        "        Object result = null;\n" +
                        "        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();\n" +
                        "        result = operations.get(key);\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 哈希 添加\n" +
                        "     * @param key\n" +
                        "     * @param hashKey\n" +
                        "     * @param value\n" +
                        "     */\n" +
                        "    public void hmSet(String key, Object hashKey, Object value){\n" +
                        "        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();\n" +
                        "        hash.put(key,hashKey,value);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 哈希获取数据\n" +
                        "     * @param key\n" +
                        "     * @param hashKey\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public Object hmGet(String key, Object hashKey){\n" +
                        "        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();\n" +
                        "        return hash.get(key,hashKey);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 列表添加\n" +
                        "     * @param k\n" +
                        "     * @param v\n" +
                        "     */\n" +
                        "    public void lPush(String k,Object v){\n" +
                        "        ListOperations<String, Object> list = redisTemplate.opsForList();\n" +
                        "        list.rightPush(k,v);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 列表获取\n" +
                        "     * @param k\n" +
                        "     * @param l\n" +
                        "     * @param l1\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public List<Object> lRange(String k, long l, long l1){\n" +
                        "        ListOperations<String, Object> list = redisTemplate.opsForList();\n" +
                        "        return list.range(k,l,l1);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 集合添加\n" +
                        "     * @param key\n" +
                        "     * @param value\n" +
                        "     */\n" +
                        "    public void add(String key,Object value){\n" +
                        "        SetOperations<String, Object> set = redisTemplate.opsForSet();\n" +
                        "        set.add(key,value);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 集合获取\n" +
                        "     * @param key\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public Set<Object> setMembers(String key){\n" +
                        "        SetOperations<String, Object> set = redisTemplate.opsForSet();\n" +
                        "        return set.members(key);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 有序集合添加\n" +
                        "     * @param key\n" +
                        "     * @param value\n" +
                        "     * @param scoure\n" +
                        "     */\n" +
                        "    public void zAdd(String key,Object value,double scoure){\n" +
                        "        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();\n" +
                        "        zset.add(key,value,scoure);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 有序集合获取\n" +
                        "     * @param key\n" +
                        "     * @param scoure\n" +
                        "     * @param scoure1\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public Set<Object> rangeByScore(String key,double scoure,double scoure1){\n" +
                        "        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();\n" +
                        "        return zset.rangeByScore(key, scoure, scoure1);\n" +
                        "    }\n" +
                        "}");

        return data.toString();
    }
}
