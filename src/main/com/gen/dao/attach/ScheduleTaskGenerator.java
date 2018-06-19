package com.gen.dao.attach;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class ScheduleTaskGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package "+Config.servicePackage+";\n" +
                "\n" +
                "import "+ Config.basePackage+".util.DateUtil;\n" +
                "import org.springframework.scheduling.annotation.EnableScheduling;\n" +
                "import org.springframework.scheduling.annotation.Scheduled;\n" +
                "import org.springframework.stereotype.Component;\n" +
                "\n" +
                "import java.util.Date;\n" +
                "\n" +
                "@Component\n" +
                "@EnableScheduling\n" +
                "public class ScheduleTask {\n" +
                "    //单位：毫秒，1分钟 = 60秒 = 60 * 1000毫秒\n" +
                "    public final static long ONE_Minute =  60 * 1000;\n" +
                "\n" +
                "    /**\n" +
                "     * fixedDelay是当任务执行完毕后1分钟再执行。所以根据实际业务不同，我们会选择不同的方式\n" +
                "     */\n" +
                "    @Scheduled(fixedDelay=ONE_Minute)\n" +
                "    public void fixedDelayJob(){  \n" +
                "        System.out.println(DateUtil.getCurrentTime(DateUtil.FORMAT)+\" >>fixedDelay执行....\");\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * fixedRate就是每多次分钟一次，不论你业务执行花费了多少时间。我都是1分钟执行1次\n" +
                "     */\n" +
                "    @Scheduled(fixedRate=ONE_Minute)  \n" +
                "    public void fixedRateJob(){  \n" +
                "        System.out.println(DateUtil.getCurrentTime(DateUtil.FORMAT)+\" >>fixedRate执行....\");\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * cron表达式:\n" +
                "     * cron一共有7位，但是最后一位是年，可以留空，所以我们可以写6位：\n" +
                "     * 第一位，表示秒，取值0-59\n" +
                "     * 第二位，表示分，取值0-59\n" +
                "     * 第三位，表示小时，取值0-23\n" +
                "     * 第四位，日期天/日，取值1-31\n" +
                "     * 第五位，日期月份，取值1-12\n" +
                "     * 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思\n" +
                "     另外：1表示星期天，2表示星期一。\n" +
                "     * 第7为，年份，可以留空，取值1970-2099\n" +
                "     *\n" +
                "     * (*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...\n" +
                "     * (?)问号：问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天3点执行，所以第六位星期的位置，我们是不需要关注的，就是不确定的值。同时：日期和星期是两个相互排斥的元素，通过问号来表明不指定值。比如，1月10日，比如是星期1，如果在星期的位置是另指定星期二，就前后冲突矛盾了。\n" +
                "     * (-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12\n" +
                "     * (,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四\n" +
                "     * (/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60    另：*'/y，等同于0/y\n" +
                "     */\n" +
                "    @Scheduled(cron=\"0 15 3 * * ?\")  \n" +
                "    public void cronJob(){  \n" +
                "        System.out.println(DateUtil.getCurrentTime(DateUtil.FORMAT)+\" >>cron执行....\");\n" +
                "    }  \n" +
                "}  ");

        return data.toString();
    }
}
