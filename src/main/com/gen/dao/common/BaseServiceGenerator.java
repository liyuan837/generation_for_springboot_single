package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class BaseServiceGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.servicePackage + ";\r\n\r\n")

                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import java.util.List;\r\n\n")

                .append("public interface BaseService<T, C> {\n" +
                        "    /**\n" +
                        "     * 查询详情\n" +
                        "     *\n" +
                        "     * @param id\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    T query(Object id);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 查询验证的详情,查不到则抛异常\n" +
                        "     *\n" +
                        "     * @param id\n" +
                        "     * @return\n" +
                        "     * @throws "+Config.exceptionName+"\n" +
                        "     */\n" +
                        "    T queryWithValid(Object id) throws "+Config.exceptionName+";\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 查询列表\n" +
                        "     *\n" +
                        "     * @param condition\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    List<T> queryList(C condition);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 查询数量\n" +
                        "     *\n" +
                        "     * @param condition\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    int queryCount(C condition);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修改\n" +
                        "     *\n" +
                        "     * @param po\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    int update(T po);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修改,失败则抛异常\n" +
                        "     *\n" +
                        "     * @param po\n" +
                        "     * @throws "+Config.exceptionName+"\n" +
                        "     */\n" +
                        "    void updateWithValid(T po) throws "+Config.exceptionName+";\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 新增\n" +
                        "     *\n" +
                        "     * @param po\n" +
                        "     */\n" +
                        "    void insert(T po);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 删除\n" +
                        "     *\n" +
                        "     * @param id\n" +
                        "     * @throws "+Config.exceptionName+"\n" +
                        "     */\n" +
                        "    void delete(Object id);\n" +
                        "}\n");

        return data.toString();
    }
}
