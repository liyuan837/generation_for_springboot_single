package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 19:48 2018/5/17
 * @Modified By:
 */
public class PageListResponseGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.responsePackage + ";\r\n\r\n")

                .append("import io.swagger.annotations.ApiModelProperty;\r\n")
                .append("import java.util.List;\r\n\n")
                .append("public class PageListResponse<T> {\n" +
                        "\n" +
                        "    @ApiModelProperty(\"数据列表\")\n" +
                        "    private List<T> dataList;\n" +
                        "\n" +
                        "    public List<T> getDataList() {\n" +
                        "        return this.dataList;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setDataList(List<T> dataList) {\n" +
                        "        this.dataList = dataList;\n" +
                        "    }\n" +
                        "\n" +
                        "    @ApiModelProperty(\"当前页码，第一页为0\")\n" +
                        "    private int pageNum;\n" +
                        "    @ApiModelProperty(\"每页条数\")\n" +
                        "    private int pageSize;\n" +
                        "    @ApiModelProperty(\"总条数\")\n" +
                        "    private long totalCount;\n" +
                        "\n" +
                        "    public PageListResponse(int pageNum, int pageSize, long totalCount, List<T> dataList) {\n" +
                        "        this.dataList = dataList;\n" +
                        "        this.pageNum = pageNum;\n" +
                        "        this.pageSize = pageSize;\n" +
                        "        this.totalCount = totalCount;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int getPageNum() {\n" +
                        "        return this.pageNum;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int getPageSize() {\n" +
                        "        return this.pageSize;\n" +
                        "    }\n" +
                        "\n" +
                        "    public long getTotalCount() {\n" +
                        "        return this.totalCount;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setPageNum(int pageNum) {\n" +
                        "        this.pageNum = pageNum;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setPageSize(int pageSize) {\n" +
                        "        this.pageSize = pageSize;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setTotalCount(long totalCount) {\n" +
                        "        this.totalCount = totalCount;\n" +
                        "    }\n" +
                        "\n" +
                        "}");

        return data.toString();
    }
}
