package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 19:48 2018/5/17
 * @Modified By:
 */
public class BaseQueryFormGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.formPackage + ";\r\n\r\n")

                .append("import io.swagger.annotations.ApiModelProperty;\r\n\n")
                .append("public class BaseQueryForm {\n" +
                        "    @ApiModelProperty(\"分页每页条数\")\n" +
                        "    public Integer pageSize = Integer.valueOf(0);\n" +
                        "    @ApiModelProperty(\"分页页码\")\n" +
                        "    public Integer pageNum = Integer.valueOf(0);\n" +
                        "\n" +
                        "\n" +
                        "    public BaseQueryForm() {\n" +
                        "    }\n" +
                        "\n" +
                        "    public Integer getPageSize() {\n" +
                        "        return this.pageSize;\n" +
                        "    }\n" +
                        "\n" +
                        "    public Integer getPageNum() {\n" +
                        "        return this.pageNum;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setPageSize(Integer pageSize) {\n" +
                        "        this.pageSize = pageSize;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setPageNum(Integer pageNum) {\n" +
                        "        this.pageNum = pageNum;\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    public boolean equals(Object o) {\n" +
                        "        if (o == this) {\n" +
                        "            return true;\n" +
                        "        } else if (!(o instanceof BaseQueryForm)) {\n" +
                        "            return false;\n" +
                        "        } else {\n" +
                        "            BaseQueryForm other = (BaseQueryForm)o;\n" +
                        "            if (!other.canEqual(this)) {\n" +
                        "                return false;\n" +
                        "            } else {\n" +
                        "                label47: {\n" +
                        "                    Object this$pageSize = this.getPageSize();\n" +
                        "                    Object other$pageSize = other.getPageSize();\n" +
                        "                    if (this$pageSize == null) {\n" +
                        "                        if (other$pageSize == null) {\n" +
                        "                            break label47;\n" +
                        "                        }\n" +
                        "                    } else if (this$pageSize.equals(other$pageSize)) {\n" +
                        "                        break label47;\n" +
                        "                    }\n" +
                        "\n" +
                        "                    return false;\n" +
                        "                }\n" +
                        "\n" +
                        "                Object this$pageNum = this.getPageNum();\n" +
                        "                Object other$pageNum = other.getPageNum();\n" +
                        "                if (this$pageNum == null) {\n" +
                        "                    if (other$pageNum != null) {\n" +
                        "                        return false;\n" +
                        "                    }\n" +
                        "                } else if (!this$pageNum.equals(other$pageNum)) {\n" +
                        "                    return false;\n" +
                        "                }\n" +
                        "\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    protected boolean canEqual(Object other) {\n" +
                        "        return other instanceof BaseQueryForm;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int hashCode() {\n" +
                        "        Object $pageSize = this.getPageSize();\n" +
                        "        int result = 1 * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());\n" +
                        "        Object $pageNum = this.getPageNum();\n" +
                        "        result = result * 59 + ($pageNum == null ? 43 : $pageNum.hashCode());\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
