package com.gen.dao.annotation;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class EqualLengthValidatorGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package "+Config.basePackage+".annotation.equallength;\n" +
                "\n" +
                "import org.apache.commons.lang.StringUtils;\n" +
                "\n" +
                "import javax.validation.ConstraintValidator;\n" +
                "import javax.validation.ConstraintValidatorContext;\n" +
                "\n" +
                "/**\n" +
                " * 验证值是否为指定长度。length(-1或0表示不限制)只指定长度。\n" +
                " * isBlank指是否可以为空。regexp（为空则不校验）表示同时匹配正则表达式\n" +
                " * To change this template use File | Settings | File Templates.\n" +
                " */\n" +
                "public class EqualLengthValidator implements ConstraintValidator<EqualLength, String> {\n" +
                "\n" +
                "    private int[] length;\n" +
                "\n" +
                "    private boolean isBlank;\n" +
                "\n" +
                "    private String regexp;\n" +
                "\n" +
                "    @Override\n" +
                "    public void initialize(EqualLength equalTo) {\n" +
                "        this.length = equalTo.length();\n" +
                "        this.isBlank = equalTo.isBlank();\n" +
                "        this.regexp = equalTo.regexp();\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {\n" +
                "        if (isBlank && StringUtils.isBlank(s)) {\n" +
                "            return true;\n" +
                "        }\n" +
                "        if (length != null && length.length > 0) {\n" +
                "            boolean sign = true;\n" +
                "            for (int val : length) {\n" +
                "                if (s.length() == val) {\n" +
                "                    sign = false;\n" +
                "                }\n" +
                "            }\n" +
                "            if (sign) {\n" +
                "                return false;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        if (StringUtils.isNotBlank(regexp) && !s.matches(regexp)) {\n" +
                "            return false;\n" +
                "        }\n" +
                "        return true;\n" +
                "    }\n" +
                "}\n");

        return data.toString();
    }
}
