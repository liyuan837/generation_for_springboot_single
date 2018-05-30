package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class JwtUserGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import lombok.Data;\r\n")
                .append("import java.io.Serializable;\r\n\n")

                .append("@Data\n" +
                        "public class JwtUser implements Serializable {\n" +
                        "\n" +
                        "    private static final long serialVersionUID = 4221700752972709820L;\n" +
                        "    private Integer id;\n" +
                        "    private String username;\n" +
                        "    private String usercode;\n" +
                        "    private String password;\n" +
                        "}");

        return data.toString();
    }
}
