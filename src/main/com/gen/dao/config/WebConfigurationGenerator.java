package com.gen.dao.config;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class WebConfigurationGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".config;\r\n\r\n")

                .append("import "+Config.basePackage+".filter.AccessFilter;\r\n")
                .append("import "+Config.basePackage+".interceptor.JwtInterceptor;\r\n")
                .append("import org.springframework.beans.factory.annotation.Autowired;\r\n")
                .append("import org.springframework.boot.web.servlet.FilterRegistrationBean;\r\n")
                .append("import org.springframework.context.annotation.Bean;\r\n")
                .append("import org.springframework.context.annotation.Configuration;\r\n")
                .append("import org.springframework.web.servlet.config.annotation.InterceptorRegistry;\r\n")
                .append("import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;\r\n")
                .append("import java.util.Arrays;\r\n\n")

                .append("@Configuration\n" +
                        "public class WebConfiguration extends WebMvcConfigurerAdapter {\n" +
                        "\n" +
                        "    @Autowired\n" +
                        "    private JwtInterceptor jwtInterceptor;\n" +
                        "\n" +
                        "    @Autowired\n" +
                        "    private AccessFilter accessFilter;\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 注册拦截器\n" +
                        "     * @param registry\n" +
                        "     */\n" +
                        "    @Override\n" +
                        "    public void addInterceptors(InterceptorRegistry registry) {\n" +
                        "        //设置拦截器白名单\n" +
                        "        String[] excludes = new String[]{\n" +
                        "                \"/favicon**\", \"/error\", \"/*.html\", \"/swagger*\", \"/v2/*\"\n" +
                        "        };\n" +
                        "        jwtInterceptor.setExcludes(Arrays.asList(excludes));\n" +
                        "        registry.addInterceptor(jwtInterceptor).addPathPatterns(\"/**\");\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 过滤处理跨域请求\n" +
                        "     */\n" +
                        "    @Bean\n" +
                        "    public FilterRegistrationBean filterCORSRegistrationBean() {\n" +
                        "        FilterRegistrationBean registrationBean = new FilterRegistrationBean();\n" +
                        "        registrationBean.setUrlPatterns(Arrays.asList(new String[]{\"/*\"}));\n" +
                        "        registrationBean.setFilter(accessFilter);\n" +
                        "        registrationBean.setOrder(3);\n" +
                        "        return registrationBean;\n" +
                        "    }\n" +
                        "    \n" +
                        "}");

        return data.toString();
    }
}
