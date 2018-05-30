package com.gen.dao.html;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 16:37 2018/5/26
 * @Modified By:
 */
public class DownloadHtmlGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<input type=\"button\" value=\"下载\" onclick=\"download()\" />\n" +
                "</body>\n" +
                "<script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n" +
                "\n" +
                "<script type=\"text/javaScript\">\n" +
                "    function download(){\n" +
                "        var form=$(\"<form>\");//定义一个form表单\n" +
                "        form.attr(\"style\",\"display:none\");\n" +
                "        form.attr(\"target\",\"\");\n" +
                "        form.attr(\"method\",\"post\");\n" +
                "        form.attr(\"action\",\"http://localhost:8081/util/download\");//请求url\n" +
                "        var input1=$(\"<input>\");\n" +
                "        input1.attr(\"type\",\"hidden\");\n" +
                "        input1.attr(\"name\",\"rows\");//设置属性的名字\n" +
                "        input1.attr(\"value\",\"text\");//设置属性的值\n" +
                "        $(\"body\").append(form);//将表单放置在web中\n" +
                "        form.append(input1);\n" +
                "        form.submit();//表单提交\n" +
                "    }\n" +
                "</script>\n" +
                "</html>");

        return data.toString();
    }
}
