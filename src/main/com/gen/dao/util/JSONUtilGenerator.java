package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class JSONUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import net.sf.json.JSONObject;\r\n")
                .append("import java.util.HashMap;\r\n")
                .append("import java.util.Map;\r\n\n")

                .append("public class JSONUtil {\n" +
                        "    /**\n" +
                        "     * 描述：组装json格式返回结果\n" +
                        "     * @param isOk\n" +
                        "     * @param resCode\n" +
                        "     * @param errorMsg\n" +
                        "     * @param obj\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Map<String, Object> createJson(boolean isOk, int resCode, String errorMsg, Object obj) {\n" +
                        "        Map<String, Object> jsonMap = new HashMap<String, Object>();\n" +
                        "        jsonMap.put(\"result\", isOk ? \"ok\" : \"fail\");\n" +
                        "        jsonMap.put(\"rescode\", resCode);\n" +
                        "        jsonMap.put(\"msg\", errorMsg);\n" +
                        "        jsonMap.put(\"data\", obj);\n" +
                        "        return jsonMap;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 描述：组装json格式返回结果\n" +
                        "     * @param isOk\n" +
                        "     * @param resCode\n" +
                        "     * @param errorMsg\n" +
                        "     * @param obj\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String createJsonString(boolean isOk, int resCode, String errorMsg, Object obj) {\n" +
                        "        Map<String, Object> jsonMap = createJson(isOk, resCode, errorMsg, obj);\n" +
                        "        JSONObject jsonObject = JSONObject.fromObject(jsonMap);\n" +
                        "        return jsonObject.toString();\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
