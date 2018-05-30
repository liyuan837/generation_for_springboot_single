package com.gen.dao.html;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 16:37 2018/5/26
 * @Modified By:
 */
public class UploadHtmlGenerator {
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
                "<form id=\"uploadfiles\" enctype=\"multipart/form-data\">\n" +
                "    <input type=\"file\" multiple=\"multiple\" id=\"file_upload\" name=\"file_upload\" />\n" +
                "    <input type=\"button\" value=\"上传\" onclick=\"upload()\" />\n" +
                "</form>\n" +
                "</body>\n" +
                "<script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n" +
                "\n" +
                "<script type=\"text/javaScript\">\n" +
                "    /*\n" +
                "     * 上传文件\n" +
                "     */\n" +
                "    function upload(){\n" +
                "        var formData = new FormData($( \"#uploadfiles\" )[0]);\n" +
                "        if($(\"input[type=file]\")[0].files.length==0){\n" +
                "            alert(\"请先选择文件\")\n" +
                "            return\n" +
                "        }\n" +
                "        $.ajax({\n" +
                "            type: \"post\",\n" +
                "            url: \"http://localhost:8081/util/upload\",\n" +
                "            dataType: \"json\",\n" +
                "            data: formData,\n" +
                "            /**\n" +
                "             *必须false才会自动加上正确的Content-Type\n" +
                "             */\n" +
                "            contentType : false,\n" +
                "            /**\n" +
                "             * 必须false才会避开jQuery对 formdata 的默认处理\n" +
                "             * XMLHttpRequest会对 formdata 进行正确的处理\n" +
                "             */\n" +
                "            processData : false,\n" +
                "            success: function(data){//从后端返回数据进行处理\n" +
                "                if(data){\n" +
                "                    alert(data.msg);\n" +
                "                }else{\n" +
                "                    alert(\"上传失败！\");\n" +
                "                }\n" +
                "            },\n" +
                "            error: function(err) {//提交出错\n" +
                "                alert(\"服务器无响应\");\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "</script>\n" +
                "</html>");

        return data.toString();
    }
}
