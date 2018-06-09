package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class ValidUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package "+Config.basePackage+".util;\n" +
                "\n" +
                "import java.util.regex.Pattern;\n" +
                "\n" +
                "/**\n" +
                " * 验证帮助类\n" +
                " */\n" +
                "public final class ValidUtil {\n" +
                "\n" +
                "    /**\n" +
                "     * 手机号码:13333333333\n" +
                "     */\n" +
                "    public static final String MOBILE = \"^((1)+\\\\d{10})$\";\n" +
                "    /**\n" +
                "     * 手机号或者固话号码\n" +
                "     **/\n" +
                "    public static final String MOBILEORTELL = \"^(\\\\d{3,4}-?\\\\d{7,8})|(1\\\\d{10})$\";\n" +
                "    /**\n" +
                "     * QQ\n" +
                "     * 必须是数字，且首位不能为0，最短4位，最长13位,可以为空\n" +
                "     */\n" +
                "    public static final String QQ = \"([1-9][0-9]{4,14})?\";\n" +
                "    /**\n" +
                "     * 邮箱:service@ofpay.com\n" +
                "     */\n" +
                "    public static final String EMAIL = \"^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\";\n" +
                "    /**\n" +
                "     * 邮箱前缀\n" +
                "     */\n" +
                "    public static final String EMAILPRE = \"[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*\";\n" +
                "    /**\n" +
                "     * 固定电话:025-88888888\n" +
                "     */\n" +
                "    public static final String TELL = \"^(0[0-9]{2,3}\\\\-?)?([2-9][0-9]{6,7})+(\\\\-[0-9]{1,4})?$\";\n" +
                "    /**\n" +
                "     * 身份证号码:15 或 17为数字 + 字母\n" +
                "     */\n" +
                "    public static final String IDNO = \"^(\\\\d{15}|\\\\d{17}[A-Za-z0-9])$\";\n" +
                "    /**\n" +
                "     * 判断是手机号\n" +
                "     */\n" +
                "    public static final String PRICEMODULE = \"5|6|7\";\n" +
                "    /**\n" +
                "     * 是否是数字\n" +
                "     */\n" +
                "    public static final String NUMBER = \"\\\\d*\";\n" +
                "    /**\n" +
                "     * 是否是IP地址段\n" +
                "     */\n" +
                "    public static final String SHORTIP = \"25[0-5]|2[0-4]\\\\d|((1\\\\d{2})|([1-9]?\\\\d))\";\n" +
                "    public static final String NUMWITHPOINT = \"^\\\\d+[\\\\.]?\\\\d*$\";\n" +
                "    /**\n" +
                "     * 最多两位小数的正实数\n" +
                "     */\n" +
                "    public static final String NUMWITH2POINT = \"^[0-9]+(.[0-9]{1,2})?$\";\n" +
                "    /**\n" +
                "     * 最多三位小数的正实数\n" +
                "     */\n" +
                "    public static final String NUMWITH3POINT = \"^[0-9]+(.[0-9]{1,3})?$\";\n" +
                "    /**\n" +
                "     * 人天(0.5的倍数或空)\n" +
                "     */\n" +
                "    public static final String MANDAY = \"^([0-9]+(.5)?)|$\";\n" +
                "    /**\n" +
                "     * 手机号码或者为空\n" +
                "     */\n" +
                "    public static final String MOBILEOREMPTY = \"^((1)+\\\\d{10})+|$\";\n" +
                "    /**\n" +
                "     * 邮箱:service@ofpay.com或者为空\n" +
                "     */\n" +
                "    public static final String EMAILOREMPTY = \"^([_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,}))+|$\";\n" +
                "    public static final String PWDSTRING = \"[A-Za-z]\";\n" +
                "    public static final String PWDNUM = \"[0-9]\";\n" +
                "    public static final String SPECIALSTRING = \"[`~!@#$%^&*()\\\\-_+=\\\\\\\\|{}':;'\\\",\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]\";\n" +
                "    public static final String SECURITYQ1 = \"[1-5]{1}\";\n" +
                "    public static final String SECURITYQ2 = \"[6-9]{1}||10\";\n" +
                "    public static final String SECURITYQ3 = \"1[1-5]{1}\";\n" +
                "    public static final String PWD_RULE = \"^(?![0-9]+$)(?![a-z]+$)(?![0-9a-z]+$)(?![\\\\~\\\\)\\\\!@#\\\\$%^&\\\\*\\\\(\\\\)_\\\\+\\\\-=\\\\{\\\\}\\\\[\\\\]|:;<>\\\\?,\\\\./]+$)[0-9A-Za-z\\\\~\\\\)\\\\!@#\\\\$%^&\\\\*\\\\(\\\\)_\\\\+\\\\-=\\\\{\\\\}\\\\[\\\\]|:;<>\\\\?,\\\\./]{8,16}$\";\n" +
                "    /**\n" +
                "     * 短信验证码\n" +
                "     */\n" +
                "    public static final String MOBILECODE = \"\\\\d{6}\";\n" +
                "    /**\n" +
                "     * 邮箱验证码\n" +
                "     */\n" +
                "    public static final String EMAILCODE = \"\\\\d{6}\";\n" +
                "    /**\n" +
                "     * 金额\n" +
                "     */\n" +
                "    public static final String CREDIT = \"^\\\\d+[\\\\.]?\\\\d*$||''\";\n" +
                "    public static final String CREDIT2 = \"^\\\\d+[\\\\.]?\\\\d*$||-\\\\d+[\\\\.]?\\\\d*$||''\";\n" +
                "    /**\n" +
                "     * 日期格式 ：yyyy-MM-dd HH:mm:ss\n" +
                "     */\n" +
                "    public static final String DATEFORMAT = \"^(\\\\d{4})-(0\\\\d{1}|1[0-2])-(0\\\\d{1}|[12]\\\\d{1}|3[01])\\\\s(0\\\\d{1}|1\\\\d{1}|2[0-3]):[0-5]\\\\d{1}:([0-5]\\\\d{1})$\";\n" +
                "    /**\n" +
                "     * 日期格式 不带时分秒：yyyy-MM-dd\n" +
                "     */\n" +
                "    public static final String DATEFORMATSHORT = \"^(\\\\d{4})-\\\\d{1,2}-\\\\d{1,2}$\";\n" +
                "    /**\n" +
                "     * 日期格式 不带时分秒：yyyy-MM\n" +
                "     */\n" +
                "    public static final String DATEFORMATMONTH = \"^(\\\\d{4})-\\\\d{1,2}$\";\n" +
                "\n" +
                "    private ValidUtil() {\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 判断密码是否是字母和数字的组合\n" +
                "     *\n" +
                "     * @param str\n" +
                "     * @return\n" +
                "     */\n" +
                "    public static boolean isPwd(String str) {\n" +
                "        Pattern p1 = Pattern.compile(PWDNUM);\n" +
                "        Pattern p2 = Pattern.compile(PWDSTRING);\n" +
                "        return (p1.matcher(str).find() && p2.matcher(str).find());\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 判断密码是否包含特殊字符\n" +
                "     *\n" +
                "     * @param str\n" +
                "     * @return\n" +
                "     */\n" +
                "    public static boolean isSpecialString(String str) {\n" +
                "        Pattern p = Pattern.compile(SPECIALSTRING);\n" +
                "        return p.matcher(str).find();\n" +
                "    }\n" +
                "\n" +
                "    public static boolean matchNewPwdRule(String str) {\n" +
                "        Pattern p = Pattern.compile(PWD_RULE);\n" +
                "        return p.matcher(str).find();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 只是验证日期格式，不验证其正确性。\n" +
                "     * 基本格式：yyyy-MM-dd HH:mm:ss\n" +
                "     */\n" +
                "    public static boolean isDateSimpleFormat(String dateTime) {\n" +
                "        Pattern pattern = Pattern.compile(DATEFORMAT);\n" +
                "        return pattern.matcher(dateTime).find();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 是否是手机号码\n" +
                "     *\n" +
                "     * @param mobile\n" +
                "     * @return\n" +
                "     */\n" +
                "    public static boolean isMobile(String mobile) {\n" +
                "        Pattern pattern = Pattern.compile(MOBILE);\n" +
                "        return pattern.matcher(mobile).find();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 是否是邮箱地址\n" +
                "     *\n" +
                "     * @param email\n" +
                "     * @return\n" +
                "     */\n" +
                "    public static boolean isEmail(String email) {\n" +
                "        Pattern pattern = Pattern.compile(EMAIL);\n" +
                "        return pattern.matcher(email).find();\n" +
                "    }\n" +
                "}\n");

        return data.toString();
    }
}
