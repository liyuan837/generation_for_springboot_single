package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class BaseControllerGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.controllerPackage + ";\r\n\r\n")

                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import "+Config.responsePackage+".PageListResponse;\r\n")
                .append("import "+Config.responsePackage+".ResponseEntity;\r\n")
                .append("import org.springframework.web.bind.annotation.ExceptionHandler;\r\n")
                .append("import org.springframework.web.bind.annotation.ResponseBody;\r\n")
                .append("import org.slf4j.Logger;\r\n")
                .append("import org.slf4j.LoggerFactory;\r\n")
                .append("import java.util.Collections;\r\n")
                .append("import java.util.List;\r\n")

                .append("public class BaseController {\n" +
                        "    /**\n" +
                        "     * 系统日志配置.\n" +
                        "     */\n" +
                        "    protected Logger logger = LoggerFactory.getLogger(this.getClass());\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 未知异常，提示请求失败.\n" +
                        "     */\n" +
                        "    public static final String UNKNOWNEXCEPTION = \"请求失败\";\n" +
                        "    /**\n" +
                        "     * 未知异常，提示请求失败.\n" +
                        "     */\n" +
                        "    public static final String PARAMSVALIDFAIL = \"参数错误！\";\n" +
                        "    /**\n" +
                        "     * 默认成功的Status Code.\n" +
                        "     */\n" +
                        "    private static final int RESCODE_OK = 200;\n" +
                        "    /**\n" +
                        "     * 默认失败的Status Code.\n" +
                        "     */\n" +
                        "    private static final int RESCODE_FAIL = 201;\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 默认成功返回数据封装：有返回数据对象 + 成功信息\n" +
                        "     */\n" +
                        "    protected ResponseEntity getSuccessResult(Object obj) {\n" +
                        "        return getSuccessResult(RESCODE_OK, \"操作成功\", obj);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 默认成功返回数据封装：没有返回数据对象\n" +
                        "     *\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    protected ResponseEntity getSuccessResult() {\n" +
                        "        return getSuccessResult(null);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 自定义成功返回数据封装：返回数据对象 + 成功信息 + 成功码\n" +
                        "     *\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    protected ResponseEntity getSuccessResult(int successCode, String msg, Object obj) {\n" +
                        "        return new ResponseEntity(\"ok\", successCode, msg, obj);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 默认失败返回数据封装：只需提供错误信息\n" +
                        "     *\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    protected ResponseEntity getFailResult(String msg) {\n" +
                        "\n" +
                        "        return this.getFailResult(RESCODE_FAIL, msg);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 自定义失败返回数据封装:可自定义错误码+错误信息\n" +
                        "     *\n" +
                        "     * @param errCode\n" +
                        "     * @param msg\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    protected ResponseEntity getFailResult(int errCode, String msg) {\n" +
                        "        return new ResponseEntity(\"fail\", errCode, msg, Collections.EMPTY_MAP);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 业务异常控制\n" +
                        "     *\n" +
                        "     * @param e\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    @ExceptionHandler("+Config.exceptionName+".class)\n" +
                        "    @ResponseBody\n" +
                        "    public ResponseEntity ExceptionHandler("+Config.exceptionName+" e) {\n" +
                        "        logger.warn(e.getLocalizedMessage());\n" +
                        "        return this.getFailResult(e.getErrCode(), e.getMessage());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 运行期异常控制\n" +
                        "     *\n" +
                        "     * @param e\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    @ExceptionHandler(RuntimeException.class)\n" +
                        "    public\n" +
                        "    @ResponseBody\n" +
                        "    ResponseEntity runtimeExceptionHandler(RuntimeException e) {\n" +
                        "        logger.error(\"发生系统异常\", e);\n" +
                        "        return this.getFailResult(\"系统异常，请和管理员联系！\");\n" +
                        "    }\n" +
                        "\n" +
                        "    public <T> PageListResponse<T> getPageListResponse(Integer pageNum, Integer pageSize, Integer totalCount, List<T> dataList){\n" +
                        "        PageListResponse<T> pageListResponse = new PageListResponse<T>(pageNum,pageSize,totalCount,dataList);\n" +
                        "        return pageListResponse;\n" +
                        "    }\n" +
                        "\n" +
                        "}\n");

        return data.toString();
    }
}
