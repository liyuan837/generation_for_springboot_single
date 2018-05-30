package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class CopyUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import org.springframework.beans.BeanUtils;\r\n")
                .append("import org.springframework.util.CollectionUtils;\r\n")
                .append("import java.lang.reflect.InvocationTargetException;\r\n")
                .append("import java.util.ArrayList;\r\n")
                .append("import java.util.List;\r\n")
                .append("import java.util.Map;\r\n")
                .append("import java.util.stream.Collectors;\r\n\n")
                .append("public class CopyUtil {\n" +
                        "    public CopyUtil() {\n" +
                        "    }\n" +
                        "\n" +
                        "    public static <T> T transfer(Object source, Class<T> targetClass) {\n" +
                        "        if (source == null) {\n" +
                        "            return null;\n" +
                        "        } else {\n" +
                        "            try {\n" +
                        "                T t = targetClass.newInstance();\n" +
                        "                BeanUtils.copyProperties(source, t);\n" +
                        "                return t;\n" +
                        "            } catch (InstantiationException var3) {\n" +
                        "                var3.printStackTrace();\n" +
                        "                return null;\n" +
                        "            } catch (IllegalAccessException var4) {\n" +
                        "                var4.printStackTrace();\n" +
                        "                return null;\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    public static <T> List<T> transfer(List<?> sourceList, Class<T> targetClass) {\n" +
                        "        return (List)(CollectionUtils.isEmpty(sourceList) ? new ArrayList() : (List)sourceList.stream().map((source) -> {\n" +
                        "            return transfer(source, targetClass);\n" +
                        "        }).collect(Collectors.toList()));\n" +
                        "    }\n" +
                        "\n" +
                        "    public static <T> T mapTransferBean(Map map, Class<T> targetClass) {\n" +
                        "        if (map == null) {\n" +
                        "            return null;\n" +
                        "        } else {\n" +
                        "            try {\n" +
                        "                T t = targetClass.newInstance();\n" +
                        "                org.apache.commons.beanutils.BeanUtils.populate(t, map);\n" +
                        "                return t;\n" +
                        "            } catch (InstantiationException var3) {\n" +
                        "                var3.printStackTrace();\n" +
                        "                return null;\n" +
                        "            } catch (IllegalAccessException var4) {\n" +
                        "                var4.printStackTrace();\n" +
                        "                return null;\n" +
                        "            } catch (InvocationTargetException var5) {\n" +
                        "                var5.printStackTrace();\n" +
                        "                return null;\n" +
                        "            }\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
