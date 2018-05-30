package com.gen.dao.properties;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class ApplicationPropertiesGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("server.port=8081\n" +
                "\n" +
                "#数据库配置\n" +
                "jdbc.driver=com.mysql.jdbc.Driver\n" +
                "jdbc.url=jdbc:mysql://localhost:3306/"+Config.dbName+"?useUnicode=true&characterEncoding=utf8&useSSL=false\n" +
                "jdbc.username=root\n" +
                "jdbc.password=123456\n" +
                "\n" +
                "#输出mysql语句\n" +
                "logging.level."+Config.mapperJavaPackage+"=DEBUG\n" +
                "\n" +
                "#redis\n" +
                "# Redis数据库索引（默认为0）\n" +
                "spring.redis.database=0\n" +
                "# Redis服务器地址\n" +
                "spring.redis.host=localhost\n" +
                "# Redis服务器连接端口\n" +
                "spring.redis.port=6379\n" +
                "# Redis服务器连接密码（默认为空）\n" +
                "spring.redis.password=\n" +
                "# 连接超时时间（毫秒）\n" +
                "spring.redis.timeout=2000\n" +
                "\n" +
                "spring.servlet.multipart.max-file-size=300Mb    \n" +
                "spring.servlet.multipart.max-request-size=1000Mb  ");

        return data.toString();
    }
}
