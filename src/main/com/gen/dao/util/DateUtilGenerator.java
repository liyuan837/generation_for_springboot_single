package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class DateUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import org.apache.commons.lang3.ArrayUtils;\r\n")
                .append("import org.apache.commons.lang3.StringUtils;\r\n")
                .append("import org.apache.commons.lang3.time.DateUtils;\r\n")
                .append("import org.slf4j.Logger;\r\n")
                .append("import org.slf4j.LoggerFactory;\r\n")
                .append("import java.math.BigDecimal;\r\n")
                .append("import java.text.DateFormat;\r\n")
                .append("import java.text.ParseException;\r\n")
                .append("import java.text.SimpleDateFormat;\r\n")
                .append("import java.util.Calendar;\r\n")
                .append("import java.util.Date;\r\n")
                .append("import java.util.GregorianCalendar;\r\n")
                .append("import java.util.regex.Matcher;\r\n")
                .append("import java.util.regex.Pattern;\r\n\n")

                .append("/**\n" +
                        " * 时间处理工具类\n" +
                        " *\n" +
                        " * @see\n" +
                        " */\n" +
                        "public final class DateUtil {\n" +
                        "    public static final String FORMAT = \"yyyy-MM-dd HH:mm:ss\";\n" +
                        "    public static final String DATE_PATTERN = \"yyyy-MM-dd\";\n" +
                        "    public static final String DATE_SHORT_PATTERN = \"MM-dd\";\n" +
                        "    public static final String DATE_TIME_PATTERN = DATE_PATTERN + \" HH:mm:ss\";\n" +
                        "    public static final String FORMAT_ONE = \"yyyy/MM/dd HH:mm:ss\";\n" +
                        "    public static final BigDecimal MAN_DAY = new BigDecimal(\"0.5\");//人天\n" +
                        "    /**\n" +
                        "     * 一周的天数为7天\n" +
                        "     */\n" +
                        "    private static final int DAYS_ONE_WEEK = 7;\n" +
                        "    /**\n" +
                        "     * 日期格式 年-月-日 时:分:秒， 年份为四位，其他为一位或者两位\n" +
                        "     */\n" +
                        "    private static final String FULL_DATE_FORMAT = \"^(\\\\d{4})-(0?\\\\d{1}|1[0-2])-(0?\\\\d{1}|[12]\\\\d{1}|3[01])\\\\s(0?\\\\d{1}|1\\\\d{1}|2[0-3]):[0-5]?\\\\d{1}:([0-5]?\\\\d{1})$\";\n" +
                        "    private static final String[] constellationArr = {\"水瓶座\", \"双鱼座\", \"白羊座\", \"金牛座\", \"双子座\", \"巨蟹座\", \"狮子座\", \"处女座\", \"天秤座\", \"天蝎座\", \"射手座\", \"摩羯座\"};\n" +
                        "    private static final int[] constellationEdgeDay = {20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22};\n" +
                        "    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * /**\n" +
                        "     * 获得当前时间，格式 yyyy-MM-dd HH:mm:ss\n" +
                        "     *\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getCurrentDate() {\n" +
                        "        return getCurrentDate(FORMAT);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得当前时间，格式自定义\n" +
                        "     *\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getCurrentDate(String format) {\n" +
                        "        Calendar day = Calendar.getInstance();\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        return sdf.format(day.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得当前时间减少一个月，格式自定义\n" +
                        "     *\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getYesterMonthDate(String format) {\n" +
                        "        Calendar day = Calendar.getInstance();\n" +
                        "        day.add(Calendar.MONTH, -1);\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        return sdf.format(day.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得昨天时间，格式自定义\n" +
                        "     *\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getYesterdayDate(String format) {\n" +
                        "        Calendar day = Calendar.getInstance();\n" +
                        "        day.add(Calendar.DATE, -1);\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        return sdf.format(day.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得明天时间\n" +
                        "     *\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getTomorrowDate(String format) {\n" +
                        "        Calendar day = Calendar.getInstance();\n" +
                        "        day.add(Calendar.DATE, 1);\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        return sdf.format(day.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获取每个月的第一天时间\n" +
                        "     *\n" +
                        "     * @param year\n" +
                        "     * @param month\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getFirstDayOfMonth(int year, int month) {\n" +
                        "        Calendar c = Calendar.getInstance();\n" +
                        "        c.set(year, month, 1, 0, 0, 0);\n" +
                        "        c.add(Calendar.MONTH, -1);\n" +
                        "        c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);\n" +
                        "        return sdf.format(c.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获取每个月的最后一天时间\n" +
                        "     *\n" +
                        "     * @param year\n" +
                        "     * @param month\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getLastDayOfMonth(int year, int month) {\n" +
                        "        Calendar c = Calendar.getInstance();\n" +
                        "        c.set(year, month, 1, 0, 0, 0);\n" +
                        "        c.add(Calendar.MONTH, -1);\n" +
                        "        c.set(Calendar.DAY_OF_MONTH, c.getMaximum(Calendar.DAY_OF_MONTH));\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);\n" +
                        "        return sdf.format(c.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修复代码质量加的注释，这个方法很绕- -\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     * @author lihe 2013-7-4 下午5:21:33\n" +
                        "     * @see\n" +
                        "     */\n" +
                        "    public static String formatDate(String date, String format) {\n" +
                        "        try {\n" +
                        "            SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "            return sdf.format(new SimpleDateFormat(\"yyyy-MM-dd\").parse(date));\n" +
                        "        } catch (ParseException e) {\n" +
                        "            return \"\";\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * @param date\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     * @author shayankui 2014-6-26 下午5:21:33\n" +
                        "     * @see\n" +
                        "     */\n" +
                        "    public static String formatDate(Date date, String format) {\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        return sdf.format(date);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 格式化时间\n" +
                        "     *\n" +
                        "     * @param calendar\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String formatDate(Calendar calendar, String format) {\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        return sdf.format(calendar.getTime());\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 按照时间字符串和格式转换成Date类\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     * @throws ParseException\n" +
                        "     * @author lihe 2013-7-4 下午5:21:50\n" +
                        "     * @see\n" +
                        "     */\n" +
                        "    public static Date getDate(String date, String format) {\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        try {\n" +
                        "            return sdf.parse(date);\n" +
                        "        } catch (ParseException e) {\n" +
                        "            logger.error(e.getMessage(), e);\n" +
                        "            return new Date();\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 按照时间字符串和格式转换成Date类\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param format\n" +
                        "     * @return\n" +
                        "     * @throws ParseException\n" +
                        "     * @author lihe 2013-7-4 下午5:21:50\n" +
                        "     * @see\n" +
                        "     */\n" +
                        "    public static Date getDateOrNull(String date, String format) {\n" +
                        "        if (StringUtils.isBlank(date)) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        try {\n" +
                        "            return sdf.parse(date);\n" +
                        "        } catch (ParseException e) {\n" +
                        "            logger.error(e.getMessage(), e);\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    public static Date getDateForTodayStart() {\n" +
                        "        return getDateForTodayStart(new Date());\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    public static Date getDateForTodayStart(Date date) {\n" +
                        "        return DateUtils.truncate(date, Calendar.DATE);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    public static Date getDateForHourStart(Date date) {\n" +
                        "        return DateUtils.truncate(date, Calendar.HOUR);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获取指定时间,精确到秒(年-月-日 时:分:秒)\n" +
                        "     *\n" +
                        "     * @param aDate 指定时间\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getDateTime(Date aDate) {\n" +
                        "        String returnValue = \"\";\n" +
                        "\n" +
                        "        if (aDate != null) {\n" +
                        "            SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_PATTERN);\n" +
                        "            returnValue = df.format(aDate);\n" +
                        "        }\n" +
                        "\n" +
                        "        return (returnValue);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 注释详见 dateBaseFormat\n" +
                        "     * 入参：2014-3-8 8:38:59\n" +
                        "     * 出参：2014-03-08 08:38:59\n" +
                        "     *\n" +
                        "     * @param dateString\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String formatFullDate(String dateString) {\n" +
                        "        return dateBaseFormat(dateString).toString();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 格式化日期，可作为参数校验<br/>\n" +
                        "     * 入参格式要求：年-月-日 时:分:秒<br/>\n" +
                        "     * <p/>\n" +
                        "     * 入参：2014-3-8 8:38:59\n" +
                        "     * 出参：2014-03-08 08:38:59\n" +
                        "     * <p/>\n" +
                        "     * 入参：2014-3-8 8:38: (或其他错误格式)\n" +
                        "     * 出参：null\n" +
                        "     *\n" +
                        "     * @param dateStr\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static StringBuilder dateBaseFormat(String dateStr) {\n" +
                        "        String dateString = validFullDate(dateStr);\n" +
                        "        if (dateString == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "\n" +
                        "        StringBuilder result = new StringBuilder();\n" +
                        "        Pattern compile = Pattern.compile(\"([-:\\\\s]?\\\\d+)\");\n" +
                        "        Matcher matcher = compile.matcher(dateString);\n" +
                        "        while (matcher.find()) {\n" +
                        "            int start = matcher.start();\n" +
                        "            int end = matcher.end();\n" +
                        "            if (start == 0 || end - start == 3) {\n" +
                        "                result.append(dateString.substring(start, end));\n" +
                        "                continue;\n" +
                        "            }\n" +
                        "            char startMark = dateString.charAt(start);\n" +
                        "            if ('-' == startMark) {\n" +
                        "                result.append(\"-0\").append(dateString.charAt(end - 1));\n" +
                        "            } else if (':' == startMark) {\n" +
                        "                result.append(\":0\").append(dateString.charAt(end - 1));\n" +
                        "            } else {\n" +
                        "                result.append(\" 0\").append(dateString.charAt(end - 1));\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 验证日期的正确性，并去除首尾的空白字符\n" +
                        "     * 如果返回 null 则日期有误\n" +
                        "     * 否则，返回去除首尾空白字符的字符串\n" +
                        "     *\n" +
                        "     * @param dateStr\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String validFullDate(String dateStr) {\n" +
                        "        if (dateStr == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        String target = dateStr.trim();\n" +
                        "        Pattern dateFormat = Pattern.compile(FULL_DATE_FORMAT);\n" +
                        "        Matcher dateMatcher = dateFormat.matcher(target);\n" +
                        "        return dateMatcher.matches() ? target : null;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 判断两个时间是否跨月\n" +
                        "     *\n" +
                        "     * @param startTime\n" +
                        "     * @param endTime\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static boolean isCrossMonth(String startTime, String endTime) {\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");\n" +
                        "\n" +
                        "        try {\n" +
                        "            // 格式化开始日期和结束日期\n" +
                        "            Calendar objCalendarDate1 = Calendar.getInstance();\n" +
                        "            objCalendarDate1.setTime(sdf.parse(startTime));\n" +
                        "\n" +
                        "            Calendar objCalendarDate2 = Calendar.getInstance();\n" +
                        "            objCalendarDate2.setTime(sdf.parse(endTime));\n" +
                        "\n" +
                        "            // 开始时间结束时间大小比较\n" +
                        "            long start = objCalendarDate1.getTimeInMillis();\n" +
                        "            long end = objCalendarDate2.getTimeInMillis();\n" +
                        "            if (start - end > 0) {\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "\n" +
                        "            int startYear = objCalendarDate1.get(Calendar.YEAR);\n" +
                        "            int endYear = objCalendarDate2.get(Calendar.YEAR);\n" +
                        "\n" +
                        "            // 判断是否跨年\n" +
                        "            if (startYear - endYear != 0) {\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "            // 判断是否跨月\n" +
                        "            int startMonth = objCalendarDate1.get(Calendar.MONTH);\n" +
                        "            int endMonth = objCalendarDate2.get(Calendar.MONTH);\n" +
                        "            if (startMonth - endMonth != 0) {\n" +
                        "                return true;\n" +
                        "            }\n" +
                        "\n" +
                        "        } catch (ParseException e) {\n" +
                        "            logger.error(e.getMessage(), e);\n" +
                        "            return true;\n" +
                        "        }\n" +
                        "\n" +
                        "        return false;\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 生成日期\n" +
                        "     *\n" +
                        "     * @param year\n" +
                        "     * @param month  从0开始\n" +
                        "     * @param day\n" +
                        "     * @param hour\n" +
                        "     * @param minute\n" +
                        "     * @param second\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    private static Date parseDate(int year, int month, int day, int hour, int minute, int second) {\n" +
                        "        Calendar currentDate = new GregorianCalendar();\n" +
                        "\n" +
                        "        currentDate.set(Calendar.YEAR, year);\n" +
                        "        currentDate.set(Calendar.MONTH, month);\n" +
                        "        currentDate.set(Calendar.DAY_OF_MONTH, day);\n" +
                        "        currentDate.set(Calendar.HOUR_OF_DAY, hour);\n" +
                        "        currentDate.set(Calendar.MINUTE, minute);\n" +
                        "        currentDate.set(Calendar.SECOND, second);\n" +
                        "        currentDate.set(Calendar.MILLISECOND, 0);\n" +
                        "\n" +
                        "        return currentDate.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 转换字符串为时间返回，如果转换不成功则返回默认日期时间\n" +
                        "     *\n" +
                        "     * @param dateStr\n" +
                        "     * @param pattern\n" +
                        "     * @param defaultDate\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date parseDate(String dateStr, String pattern, Date defaultDate) {\n" +
                        "\n" +
                        "        if (StringUtils.isBlank(dateStr) || \"null\".equals(dateStr)) {\n" +
                        "            return defaultDate;\n" +
                        "        }\n" +
                        "\n" +
                        "        DateFormat sdf = new SimpleDateFormat(pattern);\n" +
                        "        try {\n" +
                        "            return sdf.parse(dateStr.trim());\n" +
                        "        } catch (ParseException e) {\n" +
                        "            logger.error(e.getMessage(), e);\n" +
                        "            return defaultDate;\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 转换字符串为时间返回，如果转换不成功则返回默认日期时间 默认格式：yyyy-MM-dd HH:mm:ss\n" +
                        "     *\n" +
                        "     * @param dateStr\n" +
                        "     * @param defaultDate\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date parseDate(String dateStr, Date defaultDate) {\n" +
                        "\n" +
                        "        return parseDate(dateStr, \"yyyy-MM-dd HH:mm:ss\", defaultDate);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得对应时间的当天结束时间\n" +
                        "     *\n" +
                        "     * @param\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getDayEnd(Date date) {\n" +
                        "\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        if (date != null) { // 如果是空则用默认当前时间\n" +
                        "            calendar.setTime(date);\n" +
                        "        } else {\n" +
                        "            calendar.setTime(new Date());\n" +
                        "        }\n" +
                        "\n" +
                        "        int year = calendar.get(Calendar.YEAR);\n" +
                        "        int month = calendar.get(Calendar.MONTH);\n" +
                        "        int day = calendar.get(Calendar.DAY_OF_MONTH);\n" +
                        "        int hour = 23; // 23点\n" +
                        "        int minute = 59; // 59分\n" +
                        "        int second = 59; // 59秒\n" +
                        "\n" +
                        "        return parseDate(year, month, day, hour, minute, second);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得对应时间的当天开始时间\n" +
                        "     *\n" +
                        "     * @param\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getDayStart(Date date) {\n" +
                        "\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        if (date != null) { // 如果是空则用默认当前时间\n" +
                        "            calendar.setTime(date);\n" +
                        "        } else {\n" +
                        "            calendar.setTime(new Date());\n" +
                        "        }\n" +
                        "\n" +
                        "        int year = calendar.get(Calendar.YEAR);\n" +
                        "        int month = calendar.get(Calendar.MONTH);\n" +
                        "        int day = calendar.get(Calendar.DAY_OF_MONTH);\n" +
                        "        int hour = 00; // 00点\n" +
                        "        int minute = 00; // 00分\n" +
                        "        int second = 00; // 00秒\n" +
                        "\n" +
                        "        return parseDate(year, month, day, hour, minute, second);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得对应时间的月初时间\n" +
                        "     *\n" +
                        "     * @param\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getMonthBegain(Date date) {\n" +
                        "\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        if (date != null) { // 如果是空则用默认当前时间\n" +
                        "            calendar.setTime(date);\n" +
                        "        } else {\n" +
                        "            calendar.setTime(new Date());\n" +
                        "        }\n" +
                        "\n" +
                        "        int year = calendar.get(Calendar.YEAR);\n" +
                        "        int month = calendar.get(Calendar.MONTH); // 从0月开始\n" +
                        "        int day = 1;\n" +
                        "        int hour = 0; // 0点\n" +
                        "        int minute = 0; // 0分\n" +
                        "        int second = 0; // 0秒\n" +
                        "\n" +
                        "        return parseDate(year, month, day, hour, minute, second);\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获取时间的年份\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static int getYear(Date date) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "\n" +
                        "        return calendar.get(Calendar.YEAR);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据生日获取生肖\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getZodiacById(Date date) { // 根据身份证号，自动返回对应的生肖\n" +
                        "\n" +
                        "        String sSX[] = {\"猪\", \"鼠\", \"牛\", \"虎\", \"兔\", \"龙\", \"蛇\", \"马\", \"羊\", \"猴\", \"鸡\", \"狗\"};\n" +
                        "        int year = getYear(date);\n" +
                        "        int end = 3;\n" +
                        "        int x = (year - end) % 12;\n" +
                        "        return sSX[x];\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 增加时间对应的天数\n" +
                        "     *\n" +
                        "     * @param day\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date addDateDay(int day) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.add(Calendar.DATE, day);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 增加时间对应的天数\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param day\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date addDateDay(Date date, int day) {\n" +
                        "        if (null == date) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        calendar.add(Calendar.DATE, day);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 增加时间对应的天数\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param year\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date addDateYear(Date date, int year) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        calendar.add(Calendar.YEAR, year);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修复开始时间\n" +
                        "     *\n" +
                        "     * @param startDate\n" +
                        "     * @param weekDay\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date repairStartDate(Date startDate, String weekDay) {\n" +
                        "        return repairDate(startDate, weekDay, true);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修复结束时间\n" +
                        "     *\n" +
                        "     * @param endDate\n" +
                        "     * @param weekDay\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date repairEndDate(Date endDate, String weekDay) {\n" +
                        "        return repairDate(endDate, weekDay, false);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据单价计算总价\n" +
                        "     *\n" +
                        "     * @param price\n" +
                        "     * @param priceUnit\n" +
                        "     * @param startDate\n" +
                        "     * @param endDate\n" +
                        "     * @param weekDay\n" +
                        "     * @param dayTime\n" +
                        "     * @return\n" +
                        "     * @throws "+Config.exceptionName+"\n" +
                        "     */\n" +
                        "    public static BigDecimal sumServicePrice(BigDecimal price, String priceUnit,\n" +
                        "                                             Date startDate, Date endDate, String weekDay,\n" +
                        "                                             String dayTime) throws "+Config.exceptionName+" {\n" +
                        "        if (startDate == null || endDate == null) {\n" +
                        "            return price;\n" +
                        "        }\n" +
                        "        if (!startDate.before(endDate)) {\n" +
                        "            throw new "+Config.exceptionName+"(\"开始时间不能在结束时间之后\");\n" +
                        "        }\n" +
                        "        if (StringUtils.isNotBlank(weekDay) && weekDay.length() != 7) {\n" +
                        "            throw new "+Config.exceptionName+"(\"每周的工作日不符合要求\");\n" +
                        "        }\n" +
                        "\n" +
                        "        Calendar startCalendar = Calendar.getInstance();\n" +
                        "        startCalendar.setTime(startDate);\n" +
                        "        Calendar endCalendar = Calendar.getInstance();\n" +
                        "        endCalendar.setTime(endDate);\n" +
                        "\n" +
                        "        // 计算总工作天数\n" +
                        "        int workDays = 0;\n" +
                        "        if (StringUtils.isNotBlank(weekDay)) {\n" +
                        "            Calendar calendar = Calendar.getInstance();\n" +
                        "            calendar.setTime(startDate);\n" +
                        "            boolean[] workStatus = getWorkStatus(weekDay);\n" +
                        "            while (calendar.getTime().before(endDate)) {\n" +
                        "                int day = calendar.get(Calendar.DAY_OF_WEEK);\n" +
                        "                day = (day + 5) % DAYS_ONE_WEEK; //  修复日历里面的周1——周日为 0——6\n" +
                        "                if (workStatus[day]) {\n" +
                        "                    workDays++;\n" +
                        "                }\n" +
                        "\n" +
                        "                calendar.add(Calendar.HOUR, 24);\n" +
                        "            }\n" +
                        "        }\n" +
                        "\n" +
                        "        double num;\n" +
                        "        if (\"元\".equals(priceUnit) || \"元/次\".equals(priceUnit)) {\n" +
                        "            num = 1;\n" +
                        "\n" +
                        "        } else if (\"元/月\".equals(priceUnit)) {\n" +
                        "            int years = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);\n" +
                        "            num = 12 * years + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);\n" +
                        "            double dayDiff = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH) + 1;\n" +
                        "            num += dayDiff / 30;\n" +
                        "\n" +
                        "        } else if (\"元/天\".equals(priceUnit)) {\n" +
                        "            num = workDays;\n" +
                        "\n" +
                        "        } else if (\"元/26天\".equals(priceUnit)) {\n" +
                        "            num = (double) workDays / 26;\n" +
                        "\n" +
                        "        } else if (\"元/小时\".equals(priceUnit)) {\n" +
                        "            if (StringUtils.isBlank(dayTime)) {\n" +
                        "                throw new "+Config.exceptionName+"(\"需要确定每天的工作时间段\");\n" +
                        "            }\n" +
                        "\n" +
                        "            // 每天的小时总数\n" +
                        "            double hours = 0;\n" +
                        "            // 所有时间段\n" +
                        "            String[] dayDiffs = dayTime.split(\",\");\n" +
                        "            for (String dayDiff : dayDiffs) {\n" +
                        "                // 开始时间和结束时间\n" +
                        "                String[] startEndTime = dayDiff.split(\"-\");\n" +
                        "                if (startEndTime.length < 2) {\n" +
                        "                    continue;\n" +
                        "                }\n" +
                        "                String startTime = startEndTime[0];\n" +
                        "                String endTime = startEndTime[1];\n" +
                        "                String[] startHourMinute = startTime.split(\":\");\n" +
                        "                String[] endHourMinute = endTime.split(\":\");\n" +
                        "                double startHour = Integer.parseInt(startHourMinute[0]);\n" +
                        "                double startMinute = startHourMinute.length >= 2 ? Integer.parseInt(startHourMinute[1]) : 0;\n" +
                        "                double endHour = Integer.parseInt(endHourMinute[0]);\n" +
                        "                double endMinute = endHourMinute.length >= 2 ? Integer.parseInt(endHourMinute[1]) : 0;\n" +
                        "                hours = endHour - startHour + (endMinute - startMinute) / 60;\n" +
                        "            }\n" +
                        "\n" +
                        "            num = workDays * hours;\n" +
                        "        } else if (\"元/平米\".equals(priceUnit)) {\n" +
                        "            num = 1;\n" +
                        "        } else {\n" +
                        "            throw new "+Config.exceptionName+"(\"价格单位不符合要求\");\n" +
                        "        }\n" +
                        "\n" +
                        "        return price.multiply(BigDecimal.valueOf(num)).setScale(2, BigDecimal.ROUND_HALF_UP);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据月份增减获得新的时间\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param monthOffset\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getDateByMonthOffset(Date date, int monthOffset) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        calendar.add(Calendar.MONTH, monthOffset);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据天数增减获得新的时间\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param dateOffset\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getDateByDateOffset(Date date, int dateOffset) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        calendar.add(Calendar.DATE, dateOffset);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据生日计算年龄\n" +
                        "     *\n" +
                        "     * @param birthday\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Integer getAge(Date birthday) {\n" +
                        "        if (birthday == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(birthday);\n" +
                        "        int startY = calendar.get(Calendar.YEAR);\n" +
                        "\n" +
                        "        calendar.setTime(new Date());\n" +
                        "        int endY = calendar.get(Calendar.YEAR);\n" +
                        "        int age = endY - startY;\n" +
                        "        return age >= 0 ? age : 0;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据生日计算周岁年龄\n" +
                        "     *\n" +
                        "     * @param birthday\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static int getFullAge(Date birthday) {\n" +
                        "        if (birthday == null) {\n" +
                        "            return 0;\n" +
                        "        }\n" +
                        "\n" +
                        "        DateFormat df = new SimpleDateFormat(\"yyyyMMdd\");\n" +
                        "        int start = Integer.parseInt(df.format(birthday));\n" +
                        "        int end = Integer.parseInt(df.format(new Date()));\n" +
                        "        int fullAge = (end - start) / 10000;\n" +
                        "        return fullAge;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据年龄计算生日(一月一日起)\n" +
                        "     *\n" +
                        "     * @param age\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getBirthdayByAge(Integer age) {\n" +
                        "        if (age == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        //一月一日12点\n" +
                        "        calendar.set(calendar.get(Calendar.YEAR) - age, 1, 1, 12, 0, 0);\n" +
                        "        calendar.set(Calendar.MILLISECOND, 0);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据年龄获得星座\n" +
                        "     *\n" +
                        "     * @param birthday\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static String getConstellation(Date birthday) {\n" +
                        "        if (birthday == null) {\n" +
                        "            return \"\";\n" +
                        "        }\n" +
                        "        Calendar cal = Calendar.getInstance();\n" +
                        "        cal.setTime(birthday);\n" +
                        "        int month = cal.get(Calendar.MONTH);\n" +
                        "        int day = cal.get(Calendar.DAY_OF_MONTH);\n" +
                        "        if (day < constellationEdgeDay[month]) {\n" +
                        "            month = month - 1;\n" +
                        "        }\n" +
                        "        if (month >= 0) {\n" +
                        "            return constellationArr[month];\n" +
                        "        }\n" +
                        "        // default to return 魔羯\n" +
                        "        return constellationArr[11];\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据星座获得最小月日\n" +
                        "     *\n" +
                        "     * @param constellation\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Integer getMinDayByConstellation(String constellation) {\n" +
                        "        int minMon = 0;\n" +
                        "        int minDay = 0;\n" +
                        "\n" +
                        "        minMon = ArrayUtils.indexOf(constellationArr, constellation);\n" +
                        "        if (minMon < 0) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        minDay = constellationEdgeDay[minMon];\n" +
                        "        minMon = minMon + 1;\n" +
                        "        return Integer.valueOf(\"\" + minMon + minDay);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据星座获得最大月日\n" +
                        "     *\n" +
                        "     * @param constellation\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Integer getMaxDayByConstellation(String constellation) {\n" +
                        "        int maxMon = 0;\n" +
                        "        int maxDay = 0;\n" +
                        "\n" +
                        "        maxMon = ArrayUtils.indexOf(constellationArr, constellation);\n" +
                        "        if (maxMon < 0) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        maxMon = maxMon == 11 ? 1 : maxMon + 1;\n" +
                        "        maxDay = constellationEdgeDay[maxMon];\n" +
                        "        maxMon = maxMon + 1;\n" +
                        "        return Integer.valueOf(\"\" + maxMon + maxDay);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 修复时间，废除掉非工作日\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param weekDay\n" +
                        "     * @param isAdd\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    private static Date repairDate(Date date, String weekDay, boolean isAdd) {\n" +
                        "        boolean[] workStatus = getWorkStatus(weekDay);\n" +
                        "\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "\n" +
                        "        for (int i = 0; i < DAYS_ONE_WEEK; i++) {\n" +
                        "            int day = calendar.get(Calendar.DAY_OF_WEEK);\n" +
                        "            day = (day + 5) % DAYS_ONE_WEEK; //  修复日历里面的周1——周日为 0——6\n" +
                        "            if (workStatus[day]) {\n" +
                        "                break;\n" +
                        "            }\n" +
                        "\n" +
                        "            calendar.add(Calendar.HOUR, 24 * (isAdd ? 1 : -1));\n" +
                        "        }\n" +
                        "\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获取一周里每天的工作情况，下标从0——6代表周1——周日，\n" +
                        "     * 值true代表工作，false代表不工作\n" +
                        "     *\n" +
                        "     * @param weekday\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    private static boolean[] getWorkStatus(String weekday) {\n" +
                        "        boolean[] weekStates = new boolean[7];\n" +
                        "        for (int i = 0; i < DAYS_ONE_WEEK; i++) {\n" +
                        "            weekStates[i] = \"1\".equals(weekday.substring(i, i + 1));\n" +
                        "        }\n" +
                        "        return weekStates;\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据间隔秒数获得时间\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @param seconds\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getDateBySecondOffset(Date date, int seconds) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        calendar.add(Calendar.SECOND, seconds);\n" +
                        "        return calendar.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    public static boolean isWork(String weekday, Date date) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        int week = (calendar.get(Calendar.DAY_OF_WEEK) - 2 + 7) % 7;\n" +
                        "        return \"1\".equals(weekday.substring(week, week + 1));\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获取增加对应天数之后的日期\n" +
                        "     *\n" +
                        "     * @param dayAdd\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getDateAddDay(int dayAdd) {\n" +
                        "        long data = System.currentTimeMillis() + dayAdd * 24 * 3600 * 1000;\n" +
                        "\n" +
                        "        return new Date(data);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得两个日期相隔的秒数\n" +
                        "     *\n" +
                        "     * @param minuendDate\n" +
                        "     * @param subDate\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static int getSubSeconds(Date minuendDate, Date subDate) {\n" +
                        "        Calendar minuend = Calendar.getInstance();\n" +
                        "        minuend.setTime(minuendDate);\n" +
                        "\n" +
                        "        Calendar sub = Calendar.getInstance();\n" +
                        "        sub.setTime(subDate);\n" +
                        "\n" +
                        "        return minuend.get(Calendar.SECOND) - sub.get(Calendar.SECOND);\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据订单时间获取开始时间\n" +
                        "     *\n" +
                        "     * @param serviceStartDate\n" +
                        "     * @param dayTime\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getStartTime(Date serviceStartDate, String dayTime) {\n" +
                        "        if (serviceStartDate == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        Calendar startDate = Calendar.getInstance();\n" +
                        "        startDate.setTime(serviceStartDate);\n" +
                        "        if (StringUtils.isNotBlank(dayTime)) {\n" +
                        "            int startHour = Integer.valueOf(dayTime.substring(0, 2));\n" +
                        "            startDate.set(Calendar.HOUR_OF_DAY, startHour);\n" +
                        "        }\n" +
                        "        return startDate.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据订单时间获取结束时间\n" +
                        "     *\n" +
                        "     * @param serviceEndDate\n" +
                        "     * @param dayTime\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getEndTime(Date serviceEndDate, String dayTime) {\n" +
                        "        if (serviceEndDate == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        Calendar startDate = Calendar.getInstance();\n" +
                        "        startDate.setTime(serviceEndDate);\n" +
                        "        if (StringUtils.isNotBlank(dayTime)) {\n" +
                        "            String endTime = dayTime.split(\":\")[1];\n" +
                        "            int endHour = Integer.valueOf(endTime.substring(0, 2));\n" +
                        "            startDate.set(Calendar.HOUR_OF_DAY, endHour);\n" +
                        "        }\n" +
                        "        return startDate.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据订单和人天获得结束时间\n" +
                        "     *\n" +
                        "     * @param\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getStartTimeByManDay(Date serviceStartTime) {\n" +
                        "        if (serviceStartTime == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        Calendar startTime = Calendar.getInstance();\n" +
                        "        startTime.setTime(serviceStartTime);\n" +
                        "        startTime.set(Calendar.MINUTE, 0);\n" +
                        "        startTime.set(Calendar.SECOND, 0);\n" +
                        "        startTime.set(Calendar.MILLISECOND, 0);\n" +
                        "        int startHour = startTime.get(Calendar.HOUR_OF_DAY);\n" +
                        "        if (startHour >= 12) {\n" +
                        "            startTime.set(Calendar.HOUR_OF_DAY, 12);\n" +
                        "        } else {\n" +
                        "            startTime.set(Calendar.HOUR_OF_DAY, 0);\n" +
                        "        }\n" +
                        "        return startTime.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 根据订单和人天获得结束时间\n" +
                        "     *\n" +
                        "     * @param\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static Date getEndTimeByManDay(Date serviceStartTime, BigDecimal manDay) {\n" +
                        "        if (serviceStartTime == null) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "        Calendar startTime = Calendar.getInstance();\n" +
                        "        startTime.setTime(serviceStartTime);\n" +
                        "        startTime.set(Calendar.MINUTE, 0);\n" +
                        "        startTime.set(Calendar.SECOND, 0);\n" +
                        "        startTime.set(Calendar.MILLISECOND, 0);\n" +
                        "        int startHour = startTime.get(Calendar.HOUR_OF_DAY);\n" +
                        "        if (startHour >= 12) {\n" +
                        "            startTime.set(Calendar.HOUR_OF_DAY, 12);\n" +
                        "        } else {\n" +
                        "            startTime.set(Calendar.HOUR_OF_DAY, 0);\n" +
                        "        }\n" +
                        "        int hourAdd = (manDay.divide(MAN_DAY).intValue()) * 12;\n" +
                        "        startTime.add(Calendar.HOUR_OF_DAY, hourAdd);\n" +
                        "        return startTime.getTime();\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 获得周一为起始的周几\n" +
                        "     *\n" +
                        "     * @param date\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    public static int getMondayStartDateOfWeek(Date date) {\n" +
                        "        Calendar calendar = Calendar.getInstance();\n" +
                        "        calendar.setTime(date);\n" +
                        "        int week = (calendar.get(Calendar.DAY_OF_WEEK) + 6) % 7;\n" +
                        "        return week == 0 ? 7 : week;\n" +
                        "    }\n" +
                        "\n" +
                        "    public static void main(String[] args) throws Exception {\n" +
                        "        System.out.println(getMondayStartDateOfWeek(DateUtil.getDate(\"2017-07-30\", DateUtil.DATE_PATTERN)));\n" +
                        "    }\n" +
                        "\n" +
                        "    public BigDecimal getManDay(Date serviceStartDate, Date serviceEndDate) {\n" +
                        "        int hour = (int) (serviceEndDate.getTime() - serviceEndDate.getTime()) / 60 * 60 * 1000;\n" +
                        "        int day = hour / 24;\n" +
                        "        if (hour % 24 != 0) {\n" +
                        "            return new BigDecimal(day + \".5\");\n" +
                        "        }\n" +
                        "        return new BigDecimal(day);\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 格式化当前时间\n" +
                        "     */\n" +
                        "    public static Date getCurrentTime(String format){\n" +
                        "        SimpleDateFormat sdf = new SimpleDateFormat(format);\n" +
                        "        Date now = new Date();\n" +
                        "        try {\n" +
                        "            return sdf.parse(sdf.format(now));\n" +
                        "        } catch (ParseException e) {\n" +
                        "            return null;\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
