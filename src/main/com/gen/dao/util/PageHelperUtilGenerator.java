package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class PageHelperUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import com.github.pagehelper.Page;\r\n")
                .append("import com.github.pagehelper.PageHelper;\r\n")
                .append("\n" +
                        "public class PageHelperUtil {\n" +
                        "\n" +
                        "    public static <E> Page<E> startPage(int pageNum, int pageSize,String orderBy) {\n" +
                        "        if(orderBy != null){\n" +
                        "            return PageHelper.startPage(pageNum,pageSize,orderBy);\n" +
                        "        }\n" +
                        "        return PageHelper.startPage(pageNum,pageSize,false);\n" +
                        "    }\n" +
                        "}");

        return data.toString();
    }
}
