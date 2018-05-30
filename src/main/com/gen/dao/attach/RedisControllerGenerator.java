package com.gen.dao.attach;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class RedisControllerGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.controllerPackage + ";\r\n\r\n")





                .append("import "+Config.responsePackage+".ResponseEntity;\r\n")
                .append("import "+Config.servicePackage+".RedisService;\r\n")
                .append("import "+Config.basePackage+".util.JwtUser;\r\n")

                .append("import io.swagger.annotations.Api;\r\n")
                .append("import io.swagger.annotations.ApiOperation;\r\n")

                .append("import org.springframework.beans.factory.annotation.Autowired;\r\n")
                .append("import org.springframework.web.bind.annotation.*;\r\n")

        .append("@RestController\n" +
                "@RequestMapping(\"/redis\")\n" +
                "@Api(value = \"/redis\", description = \"jwt登录验证测试：此Controller下的所有接口\" +\n" +
                "        \"（除添加@NotToken注解）都是被JwtInterceptor拦截的，用来进行登录验证测试\")\n" +
                "public class RedisController extends BaseController{\n" +
                "    @Autowired\n" +
                "    private RedisService redisService ;\n" +
                "\n" +
                "    @ApiOperation(value = \"存储redis\",notes = \"存储redis\",httpMethod = \"POST\")\n" +
                "    @RequestMapping(value = \"/add\",method = RequestMethod.POST)\n" +
                "    public ResponseEntity add(@RequestBody JwtUser jwtUser){\n" +
                "        redisService.set(jwtUser.getId().toString(),jwtUser);\n" +
                "        return getSuccessResult(\"保存成功\");\n" +
                "    }\n" +
                "\n" +
                "    @ApiOperation(value = \"获取redis\",notes = \"获取redis\",httpMethod = \"POST\")\n" +
                "    @RequestMapping(value = \"/get\",method = RequestMethod.POST)\n" +
                "    public ResponseEntity get(@RequestParam(\"id\")Integer id){\n" +
                "        if(redisService.get(id.toString())!=null){\n" +
                "            JwtUser jwtUser = (JwtUser)redisService.get(id.toString());\n" +
                "            return getSuccessResult(jwtUser);\n" +
                "        }\n" +
                "        return getFailResult(\"redis中没有该用户信息\");\n" +
                "    }\n" +
                "}");

        return data.toString();
    }
}
