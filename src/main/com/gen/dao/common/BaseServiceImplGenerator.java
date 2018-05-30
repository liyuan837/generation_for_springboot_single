package com.gen.dao.common;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class BaseServiceImplGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.serviceImplPackage + ";\r\n\r\n")
                .append("import "+Config.basePackage+".util.PageHelperUtil;\r\n")
                .append("import "+Config.domainPackage+".condition.BaseCondition;\r\n")
                .append("import "+Config.mapperJavaPackage+".BaseMapper;\r\n")
                .append("import "+Config.servicePackage+".BaseService;\r\n")
                .append("import org.springframework.beans.factory.annotation.Autowired;\r\n")   
                .append("import org.springframework.transaction.annotation.Transactional;\r\n")
                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import java.util.List;\r\n\n")

                .append("public abstract class BaseServiceImpl<T, C extends BaseCondition, M extends BaseMapper<T, C>> implements BaseService<T, C> {\n" +
                        "    @Autowired\n" +
                        "    private M mapper;\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public T query(Object id) {\n" +
                        "        T o = mapper.select(id);\n" +
                        "        return o;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public T queryWithValid(Object id) throws "+Config.exceptionName+" {\n" +
                        "        T o = mapper.select(id);\n" +
                        "        if (o == null) {\n" +
                        "            throw new "+Config.exceptionName+"(id + \"对应的记录为空\");\n" +
                        "        }\n" +
                        "        return o;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public List<T> queryList(C condition) {\n" +
                        "        PageHelperUtil.startPage(condition.getPageNum(), condition.getPageSize(),condition.getOrderBy());\n" +
                        "        List<T> list = mapper.selectList(condition);\n" +
                        "        return list;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public int queryCount(C condition) {\n" +
                        "        PageHelperUtil.startPage(0, 0,null);\n" +
                        "        return mapper.count(condition);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    @Override\n" +
                        "    @Transactional(rollbackFor = {Exception.class})\n" +
                        "    public int update(T po) {\n" +
                        "        int row = mapper.update(po);\n" +
                        "        return row;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    @Transactional(rollbackFor = {Exception.class})\n" +
                        "    public void updateWithValid(T po) throws "+Config.exceptionName+" {\n" +
                        "        int row = mapper.update(po);\n" +
                        "        if (row == 0) {\n" +
                        "            throw new "+Config.exceptionName+"(\"修改失败\");\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    @Transactional(rollbackFor = {Exception.class})\n" +
                        "    public void insert(T po) {\n" +
                        "        mapper.insert(po);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    @Transactional(rollbackFor = {Exception.class})\n" +
                        "    public void delete(Object id) {\n" +
                        "        mapper.delete(id);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 返回对应的Mapper\n" +
                        "     *\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    protected M getMapper() {\n" +
                        "        return mapper;\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
