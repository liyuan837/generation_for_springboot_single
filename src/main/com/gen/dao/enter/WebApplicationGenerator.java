package com.gen.dao.enter;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class WebApplicationGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ";\r\n\r\n")

                .append("import org.springframework.boot.SpringApplication;\r\n")
                .append("import org.springframework.boot.autoconfigure.SpringBootApplication;\r\n")
                .append("import org.springframework.cache.annotation.EnableCaching;\r\n\n")

                .append("@SpringBootApplication\n" +
                        "@EnableCaching\n" +
                        "public class "+Config.webApplicationName+" {\n" +
                        "\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tSpringApplication.run("+Config.webApplicationName+".class, args);\n" +
                        "\t}\n" +
                        "}");

        return data.toString();
    }
}
