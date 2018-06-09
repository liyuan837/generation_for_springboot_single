package com.gen.dao.annotation;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class EqualLengthGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package "+ Config.basePackage+".annotation.equallength;\n" +
                "\n" +
                "import javax.validation.Constraint;\n" +
                "import javax.validation.Payload;\n" +
                "import java.lang.annotation.*;\n" +
                "\n" +
                "/**\n" +
                " * 验证值是否为指定长度。length（-1不限制）只指定长度。\n" +
                " * isnull指是否可以为空。regexp（为空则不校验）表示同时匹配正则表达式\n" +
                " */\n" +
                "@Documented\n" +
                "@Constraint(validatedBy = {EqualLengthValidator.class})\n" +
                "@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})\n" +
                "@Retention(RetentionPolicy.RUNTIME)\n" +
                "public @interface EqualLength {\n" +
                "    String message() default \"内容不一致\";\n" +
                "\n" +
                "    Class<?>[] groups() default {};\n" +
                "\n" +
                "    Class<? extends Payload>[] payload() default {};\n" +
                "\n" +
                "    String field() default \"\";\n" +
                "\n" +
                "    int[] length() default {};\n" +
                "\n" +
                "    boolean isBlank() default false;\n" +
                "\n" +
                "    String regexp() default \"\";\n" +
                "\n" +
                "\n" +
                "}\n");

        return data.toString();
    }
}
