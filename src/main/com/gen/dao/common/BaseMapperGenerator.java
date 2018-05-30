package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class BaseMapperGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.mapperJavaPackage + ";\r\n\r\n")

                .append("import org.springframework.stereotype.Repository;\r\n")
                .append("import "+Config.domainPackage+".condition.BaseCondition;\r\n")
                .append("import java.util.List;\r\n\n")
                .append("@Repository\n" +
                        "public interface BaseMapper<T, C extends BaseCondition> {\n" +
                        "    /**\n" +
                        "     * 获得bean\n" +
                        "     *\n" +
                        "     * @param id\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    T select(Object id);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得数量\n" +
                        "     *\n" +
                        "     * @param condition\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    int count(C condition);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得列表\n" +
                        "     *\n" +
                        "     * @param condition\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    List<T> selectList(C condition);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 新增记录\n" +
                        "     *\n" +
                        "     * @param po\n" +
                        "     */\n" +
                        "    void insert(T po);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修改记录\n" +
                        "     *\n" +
                        "     * @param po\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    int update(T po);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 删除记录\n" +
                        "     *\n" +
                        "     * @param id\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    int delete(Object id);\n" +
                        "}\n");

        return data.toString();
    }
}
