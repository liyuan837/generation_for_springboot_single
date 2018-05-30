package com.gen.dao.attach;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class UtilControllerGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.controllerPackage + ";\r\n\r\n")

                .append("import "+Config.basePackage+".util.ZipUtil;\r\n")
                .append("import "+Config.responsePackage+".ResponseEntity;\r\n")
                .append("import org.springframework.web.bind.annotation.*;\r\n")
                .append("import org.springframework.web.multipart.MultipartFile;\r\n")
                .append("import javax.servlet.http.HttpServletResponse;\r\n")
                .append("import java.io.*;\r\n")

                .append("@RestController\n" +
                        "@RequestMapping(\"/util\")\n" +
                        "public class UtilController extends BaseController {\n" +
                        "\n" +
                        "    /*\n" +
                        "   * 上传多个文件:produces属性防止乱码\n" +
                        "   */\n" +
                        "    @RequestMapping(value = \"/upload\", produces = \"application/json;charset=UTF-8\")\n" +
                        "    public @ResponseBody\n" +
                        "    ResponseEntity uploadFiles(@RequestParam(\"file_upload\") MultipartFile[] files) throws Exception {\n" +
                        "        String realPath;\n" +
                        "        for(int i=0;i<files.length;i++){\n" +
                        "            if (!files[i].isEmpty()) {\n" +
                        "                String uniqueName=files[i].getOriginalFilename();//得到文件名\n" +
                        "\n" +
                        "                realPath=\"E:\"+ File.separator+uniqueName;//文件上传的路径这里为E盘\n" +
                        "                files[i].transferTo(new File(realPath));  // 转存文件\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return getSuccessResult();\n" +
                        "    }\n" +
                        "\n" +
                        "    /*\n" +
                        "   * 下载多个文件\n" +
                        "   */\n" +
                        "    @RequestMapping(value = \"/download\")\n" +
                        "    public ResponseEntity downloadFiles(HttpServletResponse response) {\n" +
                        "        //定义目标文件的完整路径\n" +
                        "        String[] paths = new String[]{\"E:/pic/1.png\", \"E:/img/2.png\"};\n" +
                        "\n" +
                        "        //定义压缩后文件的临时路径\n" +
                        "        String uri = \"d:\" + File.separator + \"download.zip\";//临时文件存储路径\n" +
                        "        ZipUtil.compress(uri, paths);\n" +
                        "\n" +
                        "        File zipFile = new File(uri);\n" +
                        "        try {\n" +
                        "            // 以流的形式下载文件\n" +
                        "            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(zipFile));\n" +
                        "            byte[] buffer = new byte[fis.available()];\n" +
                        "            fis.read(buffer);\n" +
                        "            fis.close();\n" +
                        "            // 清空response\n" +
                        "            response.reset();\n" +
                        "            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());\n" +
                        "            response.setContentType(\"application/x-msdownload;\");\n" +
                        "            response.setHeader(\"Content-Disposition\", \"attachment;filename=\" + zipFile.getName());\n" +
                        "            toClient.write(buffer);\n" +
                        "            toClient.flush();\n" +
                        "            toClient.close();\n" +
                        "            zipFile.delete();    //将生成的服务器端文件删除\n" +
                        "        } catch (IOException ex) {\n" +
                        "            ex.printStackTrace();\n" +
                        "        }\n" +
                        "\n" +
                        "        return getSuccessResult();\n" +
                        "    }\n" +
                        "}");

        return data.toString();
    }
}
