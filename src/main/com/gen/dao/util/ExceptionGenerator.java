package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 17:27 2018/5/17
 * @Modified By:
 */
public class ExceptionGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.exceptionPackage + ";\r\n\r\n")
                .append("public class "+Config.exceptionName+" extends RuntimeException {\n" +
                        "\n" +
                        "    private static final long serialVersionUID = -6202759931628287239L;\n" +
                        "    private static final int DEFAULT_ERROR_CODE = 201;\n" +
                        "\n" +
                        "    /* 错误码,用于返回接口code */\n" +
                        "    private int errCode;\n" +
                        "\n" +
                        "    public "+Config.exceptionName+"() {\n" +
                        "        super();\n" +
                        "    }\n" +
                        "\n" +
                        "    public "+Config.exceptionName+"(String msg) {\n" +
                        "        super(msg);\n" +
                        "        this.errCode = DEFAULT_ERROR_CODE;\n" +
                        "    }\n" +
                        "\n" +
                        "    public "+Config.exceptionName+"(int errCode, String msg) {\n" +
                        "        super(msg);\n" +
                        "        this.errCode = errCode;\n" +
                        "    }\n" +
                        "\n" +
                        "    public "+Config.exceptionName+"(String msg, Throwable e) {\n" +
                        "        super(msg, e);\n" +
                        "        this.errCode = DEFAULT_ERROR_CODE;\n" +
                        "    }\n" +
                        "\n" +
                        "    public "+Config.exceptionName+"(int errCode, String msg, Throwable e) {\n" +
                        "        super(msg, e);\n" +
                        "        this.errCode = errCode;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int getErrCode() {\n" +
                        "        return errCode;\n" +
                        "    }\n" +
                        "}");

        return data.toString();
    }
}
