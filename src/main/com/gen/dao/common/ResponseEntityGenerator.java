package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 19:48 2018/5/17
 * @Modified By:
 */
public class ResponseEntityGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.responsePackage + ";\r\n\r\n")

                .append("import io.swagger.annotations.ApiModelProperty;\r\n\n")
                .append("public class ResponseEntity<T> {\n" +
                        "\n" +
                        "    @ApiModelProperty(value = \"状态: ok 成功, fail 失败\")\n" +
                        "    private String result;\n" +
                        "\n" +
                        "    @ApiModelProperty(value = \"状态码: 200 成功, 201 失败\")\n" +
                        "    private Integer rescode;\n" +
                        "\n" +
                        "    @ApiModelProperty(value = \"备注原因\")\n" +
                        "    private String msg;\n" +
                        "\n" +
                        "    @ApiModelProperty(value = \"返回对象\")\n" +
                        "    private T data;\n" +
                        "\n" +
                        "    public ResponseEntity(String result, Integer rescode, String msg, T data) {\n" +
                        "        this.result = result;\n" +
                        "        this.rescode = rescode;\n" +
                        "        this.msg = msg;\n" +
                        "        this.data = data;\n" +
                        "    }\n" +
                        "\n" +
                        "    public String getResult() {\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setResult(String result) {\n" +
                        "        this.result = result;\n" +
                        "    }\n" +
                        "\n" +
                        "    public Integer getRescode() {\n" +
                        "        return rescode;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setRescode(Integer rescode) {\n" +
                        "        this.rescode = rescode;\n" +
                        "    }\n" +
                        "\n" +
                        "    public String getMsg() {\n" +
                        "        return msg;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setMsg(String msg) {\n" +
                        "        this.msg = msg;\n" +
                        "    }\n" +
                        "\n" +
                        "    public Object getData() {\n" +
                        "        return data;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setData(T data) {\n" +
                        "        this.data = data;\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
