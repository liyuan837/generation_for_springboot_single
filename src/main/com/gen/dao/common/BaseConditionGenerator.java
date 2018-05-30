package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class BaseConditionGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.domainPackage + ".condition;\r\n\r\n")

                .append("import org.springframework.data.domain.Sort;\r\n")
                .append("import java.util.List;\r\n\n")
                .append("public abstract class BaseCondition{\n" +
                        "\n" +
                        "    private int pageSize = 0;\n" +
                        "    private int pageNum;\n" +
                        "    private int skipResults = 0;\n" +
                        "\n" +
                        "    private String orderBy;\n" +
                        "    private List<Sort> sortList;\n" +
                        "\n" +
                        "    public int getPageSize() {\n" +
                        "        return pageSize;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setPageSize(int pageSize) {\n" +
                        "        this.pageSize = pageSize;\n" +
                        "        skipResults = pageSize * pageNum;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int getPageNum() {\n" +
                        "        return pageNum;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setPageNum(int pageNo) {\n" +
                        "        this.pageNum = pageNo;\n" +
                        "        skipResults = pageSize * pageNo;\n" +
                        "    }\n" +
                        "\n" +
                        "    public int getSkipResults() {\n" +
                        "        return skipResults;\n" +
                        "    }\n" +
                        "\n" +
                        "    public String getOrderBy() {\n" +
                        "        return orderBy;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setOrderBy(String orderBy) {\n" +
                        "        this.orderBy = orderBy;\n" +
                        "    }\n" +
                        "\n" +
                        "    public List<Sort> getSortList() {\n" +
                        "        return sortList;\n" +
                        "    }\n" +
                        "\n" +
                        "    public void setSortList(List<Sort> sortList) {\n" +
                        "        this.sortList = sortList;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public String toString() {\n" +
                        "        return this.pageNum + \"==\" + this.pageSize;\n" +
                        "    }\n" +
                        "\n" +
                        "}\n");

        return data.toString();
    }
}
