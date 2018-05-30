package com.gen.dao.annotation;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class NotTokenGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".annotation;\r\n\r\n")

                .append("import java.lang.annotation.ElementType;\r\n")
                .append("import java.lang.annotation.Retention;\r\n")
                .append("import java.lang.annotation.RetentionPolicy;\r\n")
                .append("import java.lang.annotation.Target;\r\n\n")
                .append("/**\n" +
                        " * @Description:不需要校验token的注解\n" +
                        " */\n" +
                        "@Target(ElementType.METHOD)\n" +
                        "@Retention(RetentionPolicy.RUNTIME)\n" +
                        "public @interface NotToken {\n" +
                        "}");

        return data.toString();
    }
}
