package com.gen.dao.config;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class Swagger2Generator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".config;\r\n\r\n")

                .append("import org.springframework.context.annotation.Bean;\r\n")
                .append("import org.springframework.context.annotation.Configuration;\r\n")
                .append("import springfox.documentation.builders.ApiInfoBuilder;\r\n")
                .append("import springfox.documentation.builders.PathSelectors;\r\n")
                .append("import springfox.documentation.builders.RequestHandlerSelectors;\r\n")
                .append("import springfox.documentation.service.ApiInfo;\r\n")
                .append("import springfox.documentation.spi.DocumentationType;\r\n")
                .append("import springfox.documentation.spring.web.plugins.Docket;\r\n")
                .append("import springfox.documentation.swagger2.annotations.EnableSwagger2;\r\n\n")

                .append("@Configuration\n" +
                        "@EnableSwagger2\n" +
                        "public class Swagger2 {\n" +
                        "\n" +
                        "    //通过createRestApi函数创建Docket的Bean\n" +
                        "    @Bean\n" +
                        "    public Docket createRestApi() {\n" +
                        "        return new Docket(DocumentationType.SWAGGER_2)\n" +
                        "                .apiInfo(apiInfo())\n" +
                        "                .select()\n" +
                        "                //默认会将该包下面所有的controller的每一个接口都生成API，除非被@ApiIgnore制定忽略的请求\n" +
                        "                .apis(RequestHandlerSelectors.basePackage(\""+Config.controllerPackage+"\"))\n" +
                        "                .paths(PathSelectors.any())\n" +
                        "                .build();\n" +
                        "    }\n" +
                        "\n" +
                        "    //apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）\n" +
                        "    private ApiInfo apiInfo() {\n" +
                        "        return new ApiInfoBuilder()\n" +
                        "                .title(\"Demo模板项目的Swagger2API接口生成\")\n" +
                        "                .description(\"更多相关内容请关注：https://github.com/liyuan837/\")\n" +
                        "                .termsOfServiceUrl(\"https://github.com/liyuan837/\")\n" +
                        "                .contact(\"演得太逼真\")\n" +
                        "                .version(\"1.0\")\n" +
                        "                .build();\n" +
                        "    }\n" +
                        "\n" +
                        "}");

        return data.toString();
    }
}
