package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class JwtUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import io.jsonwebtoken.Claims;\r\n")
                .append("import io.jsonwebtoken.JwtBuilder;\r\n")
                .append("import io.jsonwebtoken.Jwts;\r\n")
                .append("import io.jsonwebtoken.SignatureAlgorithm;\r\n")
                .append("import org.apache.tomcat.util.codec.binary.Base64;\r\n")
                .append("import javax.crypto.SecretKey;\r\n")
                .append("import javax.crypto.spec.SecretKeySpec;\r\n")
                .append("import java.util.Date;\r\n\n")

                .append("public class JwtUtil {\n" +
                        "\n" +
                        "    public static String stringKey =\"LIYUAN\";\n" +
                        "    public static byte[] encodedKey = Base64.decodeBase64(stringKey);\n" +
                        "    public static SecretKey key= new SecretKeySpec(encodedKey, 0, encodedKey.length, \"AES\");\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 生成token\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String generateToken(JwtUser jwtUser){\n" +
                        "        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;\n" +
                        "        Date startTime = new Date(System.currentTimeMillis());\n" +
                        "        Date expireTime = new Date(startTime.getTime()+ 60 * 1000 * 60 * 24);//设置token失效时间:24小时\n" +
                        "        Date outDate = new Date(startTime.getTime() + 60*1000*60);//自定义会话超时时间：1小时\n" +
                        "        JwtBuilder builder = Jwts.builder()\n" +
                        "                .setHeaderParam(\"typ\", \"JWT\")    //设置header\n" +
                        "                .setHeaderParam(\"alg\", \"HS256\")\n" +
                        "                .setIssuedAt(startTime)\n" +
                        "                //设置失效时间\n" +
                        "                .setExpiration(expireTime)\n" +
                        "                //设置会话超时时间\n" +
                        "                .claim(\"expiration\",outDate.getTime())\n" +
                        "                .claim(\"username\", jwtUser.getUsername())   //设置payload的键值对\n" +
                        "                .claim(\"usercode\", jwtUser.getUsercode())\n" +
                        "                .signWith(signatureAlgorithm, key);    //签名，需要算法和key\n" +
                        "        String token = builder.compact();\n" +
                        "        return token;\n" +
                        "    }\n" +
                        "    /**\n" +
                        "     * 获取验证Claims\n" +
                        "     */\n" +
                        "    public static Claims getClaims(String token){\n" +
                        "        //获取claims\n" +
                        "        Claims claims = null;\n" +
                        "        try {\n" +
                        "            claims = Jwts.parser()\n" +
                        "                    .setSigningKey(key)     //此处的key要与之前创建的key一致\n" +
                        "                    .parseClaimsJws(token)\n" +
                        "                    .getBody();\n" +
                        "        }catch (Exception e){\n" +
                        "\n" +
                        "        }\n" +
                        "        return claims;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 验证登录\n" +
                        "     * @param authorization\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static JwtUser checkLogin(String authorization) throws "+Config.exceptionName+" {\n" +
                        "        JwtUser jwtUser;\n" +
                        "\n" +
                        "        Claims claims = getClaims(authorization);\n" +
                        "        if (claims == null) {\n" +
                        "            throw new "+Config.exceptionName+"(\"无效token\");\n" +
                        "        }\n" +
                        "\n" +
                        "        String usercode = (String) claims.get(\"usercode\");\n" +
                        "        if(usercode == null || usercode.equals(\"\")){\n" +
                        "            throw new "+Config.exceptionName+"(\"会话中的用户编号为空\");\n" +
                        "        }\n" +
                        "\n" +
                        "        Long expiration = (Long) claims.get(\"expiration\");\n" +
                        "        if(expiration < (new Date().getTime())){\n" +
                        "            throw new "+Config.exceptionName+"(\"会话超时，请重新登陆\");\n" +
                        "        }\n" +
                        "\n" +
                        "        jwtUser = new JwtUser();\n" +
                        "        jwtUser.setUsercode(usercode);\n" +
                        "        jwtUser.setUsername((String) claims.get(\"username\"));\n" +
                        "\n" +
                        "        return jwtUser;\n" +
                        "    }\n" +
                        "\n" +
                        "}\n");

        return data.toString();
    }
}
