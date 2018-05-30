package com.gen.dao.interceptor;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class JwtInterceptorGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".interceptor;\r\n\r\n")

                .append("import "+Config.basePackage+".annotation.NotToken;\r\n")
                .append("import "+Config.basePackage+".util.JSONUtil;\r\n")
                .append("import org.springframework.stereotype.Component;\r\n")
                .append("import org.springframework.util.AntPathMatcher;\r\n")
                .append("import org.springframework.util.PathMatcher;\r\n")
                .append("import org.springframework.web.method.HandlerMethod;\r\n")
                .append("import org.springframework.web.servlet.HandlerInterceptor;\r\n")
                .append("import org.springframework.web.servlet.ModelAndView;\r\n")

                .append("import javax.servlet.ServletResponse;\r\n")
                .append("import javax.servlet.http.HttpServletRequest;\r\n")
                .append("import javax.servlet.http.HttpServletResponse;\r\n")
                .append("import java.io.IOException;\r\n")
                .append("import java.io.OutputStream;\r\n")
                .append("import java.util.Collections;\r\n")
                .append("import java.util.List;\r\n\n")

                .append("/**\n" +
                        " * @description:用户Authorthon验证拦截器\n" +
                        " */\n" +
                        "@Component\n" +
                        "public class JwtInterceptor implements HandlerInterceptor{\n" +
                        "\n" +
                        "    //拦截器白名单\n" +
                        "    private List<String> excludes;\n" +
                        "    public void setExcludes(List<String> excludes) {\n" +
                        "        this.excludes = excludes;\n" +
                        "    }\n" +
                        "    private PathMatcher pathMatcher = new AntPathMatcher();\n" +
                        "\n" +
                        "    private boolean lookupUrl(String urlPath) {\n" +
                        "        for (String registeredPattern : excludes) {\n" +
                        "            if (pathMatcher.match(registeredPattern, urlPath)) {\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return false;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {\n" +
                        "        String urlPath = httpServletRequest.getRequestURI();\n" +
                        "        //[1]请求地址处理\n" +
                        "        if (!urlPath.startsWith(\"/\")) {\n" +
                        "            urlPath = \"/\" + urlPath;\n" +
                        "        }\n" +
                        "\n" +
                        "        //[2]判断是否在白名单中\n" +
                        "        if (lookupUrl(urlPath)) {\n" +
                        "            return true;\n" +
                        "        }\n" +
                        "\n" +
                        "        //[3]对于使用了@NotToken的接口，不需要校验token\n" +
                        "        if (handler instanceof HandlerMethod) {\n" +
                        "            HandlerMethod method = (HandlerMethod) handler;\n" +
                        "            NotToken notToken = method.getMethodAnnotation(NotToken.class);\n" +
                        "            if (notToken != null){\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        //[4]模拟拦截所有JwtController下的请求\n" +
                        "        if(urlPath.indexOf(\"/jwt/\") >=0){\n" +
                        "            String authHeader = httpServletRequest.getHeader(\"Authorization\");\n" +
                        "            if (authHeader == null || authHeader.equals(\"\")) {\n" +
                        "                //拦截，并且返回错误信息\n" +
                        "                errorResponse(httpServletResponse,201,\"尚未携带有效的Token\");\n" +
                        "                return false;\n" +
                        "            }else{\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "        }\n" +
                        "//        //[4]其他接口都需要JWT token验证\n" +
                        "//        String authHeader = httpServletRequest.getHeader(\"Authorization\");\n" +
                        "//\n" +
                        "//        if (authHeader == null || authHeader.equals(\"\")) {\n" +
                        "//            //拦截，并且返回错误信息\n" +
                        "//            errorResponse(httpServletResponse,201,\"尚未携带有效的Token\");\n" +
                        "//            return false;\n" +
                        "//        }else{\n" +
                        "//            return true;\n" +
                        "//        }\n" +
                        "        return true;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    private void errorResponse(final ServletResponse res, int errCode, String errMsg) {\n" +
                        "        try {\n" +
                        "            OutputStream out = res.getOutputStream();\n" +
                        "            res.setCharacterEncoding(\"UTF-8\");\n" +
                        "            res.setContentType(\"application/json; charset=utf-8\");\n" +
                        "            String retJson = JSONUtil.createJsonString(false, errCode, errMsg, Collections.EMPTY_MAP);\n" +
                        "\n" +
                        "            out.write(retJson.getBytes(\"UTF-8\"));\n" +
                        "            out.flush();\n" +
                        "        } catch (IOException e) {\n" +
                        "\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
