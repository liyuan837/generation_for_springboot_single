package com.gen.dao.filter;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class AccessFilterGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".filter;\r\n\r\n")

                .append("import org.springframework.context.annotation.Configuration;\r\n")
                .append("import org.springframework.web.filter.OncePerRequestFilter;\r\n")
                .append("import javax.servlet.FilterChain;\r\n")
                .append("import javax.servlet.ServletException;\r\n")
                .append("import javax.servlet.http.HttpServletRequest;\r\n")
                .append("import javax.servlet.http.HttpServletResponse;\r\n")
                .append("import java.io.IOException;\r\n\n")

                .append("/**\n" +
                        " * 跨域过滤器\n" +
                        " */\n" +
                        "@Configuration\n" +
                        "public class AccessFilter extends OncePerRequestFilter {\n" +
                        "\n" +
                        "    @Override\n" +
                        "    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {\n" +
                        "        String origin = request.getHeader(\"Origin\");\n" +
                        "//        if(StringUtils.isNotBlank(origin) && origin.matches(regex)){\n" +
                        "        response.setHeader(\"Access-Control-Allow-Origin\", request.getHeader(\"Origin\") == null ? \"*\" : request.getHeader(\"Origin\"));\n" +
                        "        response.setHeader(\"Access-Control-Allow-Methods\", \"POST, GET, OPTIONS, DELETE\");\n" +
                        "        response.setHeader(\"Access-Control-Max-Age\", \"3600\");\n" +
                        "        response.setHeader(\"Access-Control-Allow-Headers\", \"x-requested-with,Content-Type, Authorization\");\n" +
                        "        response.setHeader(\"Access-Control-Allow-Credentials\", \"true\");\n" +
                        "        response.setHeader(\"Access-Control-Expose-Headers\", \"server-replace\");\n" +
                        "//        }\n" +
                        "        filterChain.doFilter(request, response);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void destroy() {}\n" +
                        "\n" +
                        "} ");

        return data.toString();
    }
}
