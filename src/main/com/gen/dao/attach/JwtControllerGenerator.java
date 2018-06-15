package com.gen.dao.attach;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class JwtControllerGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.controllerPackage + ";\r\n\r\n")

                .append("import "+Config.basePackage+".util.JwtUtil;\r\n")
                .append("import "+Config.basePackage+".util.JwtUser;\r\n")
                .append("import "+Config.basePackage+".annotation.NotToken;\r\n")
                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import "+Config.responsePackage+".ResponseEntity;\r\n")

                .append("import io.swagger.annotations.Api;\r\n")
                .append("import io.swagger.annotations.ApiOperation;\r\n")

                .append("import org.springframework.web.bind.annotation.RequestHeader;\r\n")
                .append("import org.springframework.web.bind.annotation.RequestMapping;\r\n")
                .append("import org.springframework.web.bind.annotation.RequestMethod;\r\n")
                .append("import org.springframework.web.bind.annotation.RestController;\r\n")

                .append("@RestController\n" +
                        "@RequestMapping(\"/jwt\")\n" +
                        "@Api(value = \"/jwt\", description = \"jwt登录验证测试：此Controller下的所有接口\" +\n" +
                        "        \"（除添加@NotToken注解）都是被JwtInterceptor拦截的，用来进行登录验证测试\")\n" +
                        "public class JwtController extends BaseController{\n" +
                        "\n" +
                       "//模拟登陆成功，返回token\n" +
                        "    @ApiOperation(value = \"登录\",notes = \"登录\",httpMethod = \"POST\")\n" +
                        "    @NotToken\n" +
                        "    @RequestMapping(value = \"/login\",method = RequestMethod.POST)\n" +
                        "    public ResponseEntity login(){\n" +
                        "        JwtUser jwtUser = new JwtUser();\n" +
                        "        jwtUser.setUsername(\"李袁\");\n" +
                        "        jwtUser.setUsercode(\"A0001\");\n" +
                        "\n" +
                        "        String token = JwtUtil.generateToken(jwtUser);\n" +
                        "        return getSuccessResult(token);\n" +
                        "    }"+
                        "\n" +
                        "    //模拟携带token的请求解析\n" +
                        "    @ApiOperation(value = \"解析登录用户数据\",notes = \"解析登录用户数据\",httpMethod = \"POST\")\n" +
                        "    @RequestMapping(value = \"/get\",method = RequestMethod.POST)\n" +
                        "    public ResponseEntity get(@RequestHeader(\"Authorization\") String token) throws "+Config.exceptionName+" {\n" +
                        "        return getSuccessResult(JwtUtil.checkLogin(token));\n" +
                        "    }\n" +
                        "}");

        return data.toString();
    }
}
