package com.gen.dao.util;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class ZipUtilGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".util;\r\n\r\n")

                .append("import "+Config.exceptionPackage+"."+Config.exceptionName+";\r\n")
                .append("import java.io.BufferedInputStream;\r\n")
                .append("import java.io.File;\r\n")
                .append("import java.io.FileInputStream;\r\n")
                .append("import java.io.FileOutputStream;\r\n")
                .append("import java.util.zip.CRC32;\r\n")
                .append("import java.util.zip.CheckedOutputStream;\r\n")
                .append("import java.util.zip.ZipOutputStream;\r\n")
                .append("import java.util.zip.ZipEntry;\r\n\n")

                .append("/**\n" +
                        " * @Description:压缩文件工具类\n" +
                        " */\n" +
                        "public class ZipUtil {\n" +
                        "    static final int BUFFER = 8192;\n" +
                        "    private static File zipFile;\n" +
                        "    /**\n" +
                        "     * 压缩单个或多文件方法\n" +
                        "     * @param zipPath 压缩后的文件路径\n" +
                        "     * @param srcPathName 要压缩的文件路径\n" +
                        "     * 参数srcPathName也可以定义成数组形式，需调用方把参数封装到数组中传过来即可\n" +
                        "     */\n" +
                        "    public static void compress(String zipPath,String... srcPathName) {\n" +
                        "        //压缩后的文件对象\n" +
                        "        zipFile = new File(zipPath);\n" +
                        "        try {\n" +
                        "        \t//创建写出流操作\n" +
                        "            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);\n" +
                        "            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,new CRC32());\n" +
                        "            ZipOutputStream out = new ZipOutputStream(cos);\n" +
                        "        \tfor(String srcPath:srcPathName){\n" +
                        "        \t\t//创建需要压缩的文件对象\n" +
                        "            \tFile file = new File(srcPath);\n" +
                        "                if (!file.exists()){\n" +
                        "                \tthrow new "+Config.exceptionName+"(srcPath + \"不存在！\");\n" +
                        "                }\n" +
                        "                /*\n" +
                        "                 * (1)如果在zip压缩文件中不需要一级文件目录，定义String basedir = \"\";\n" +
                        "                 * 下面的compress方法中当判断文件file是目录后不需要加上basedir = basedir + file.getName() + File.separator;\n" +
                        "                 * (2)如果只是想在压缩后的zip文件里包含一级文件目录，不包含二级以下目录，\n" +
                        "                 * 直接在这定义String basedir = file.getName() + File.separator;\n" +
                        "                 * 下面的compress方法中当判断文件file是目录后不需要加上basedir = basedir + file.getName() + File.separator;\n" +
                        "                 * (3)如果想压缩后的zip文件里包含一级文件目录，也包含二级以下目录，即zip文件里的目录结构和原文件一样\n" +
                        "                 * 在此定义String basedir = \"\";\n" +
                        "                 * 下面的compress方法中当判断文件file是目录后需要加上basedir = basedir + file.getName() + File.separator;\n" +
                        "                 */\n" +
                        "                //String basedir = file.getName() + File.separator;\n" +
                        "                String basedir = \"\";\n" +
                        "                compress(file, out, basedir);\n" +
                        "        \t}\n" +
                        "        \tout.close();\n" +
                        "        } catch (Exception e) {\n" +
                        "            throw new RuntimeException(e);\n" +
                        "        }\n" +
                        "    }\n" +
                        "    private static void compress(File file, ZipOutputStream out, String basedir) {\n" +
                        "        /* \n" +
                        "         * 判断是目录还是文件 \n" +
                        "         */\n" +
                        "        if (file.isDirectory()) {\n" +
                        "        \tbasedir += file.getName() + File.separator;\n" +
                        "            compressDirectory(file, out, basedir);\n" +
                        "        } else {\n" +
                        "            System.out.println(\"压缩：\" + basedir + file.getName());\n" +
                        "            compressFile(file, out, basedir);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 压缩一个目录\n" +
                        "     */\n" +
                        "    private static void compressDirectory(File dir, ZipOutputStream out, String basedir) {\n" +
                        "        if (!dir.exists()){\n" +
                        "        \t return;\n" +
                        "        }\n" +
                        "        File[] files = dir.listFiles();\n" +
                        "        for (int i = 0; i < files.length; i++) {\n" +
                        "            /* 递归 */\n" +
                        "            compress(files[i], out, basedir);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    /** \n" +
                        "     * 压缩一个文件 \n" +
                        "     */\n" +
                        "    private static void compressFile(File file, ZipOutputStream out, String basedir) {\n" +
                        "        if (!file.exists()) {\n" +
                        "            return;\n" +
                        "        }\n" +
                        "        try {\n" +
                        "            BufferedInputStream bis = new BufferedInputStream(\n" +
                        "                    new FileInputStream(file));\n" +
                        "            //创建Zip实体，并添加进压缩包  \n" +
                        "            ZipEntry entry = new ZipEntry(basedir + file.getName());\n" +
                        "            out.putNextEntry(entry);\n" +
                        "            //读取待压缩的文件并写进压缩包里\n" +
                        "            int count;\n" +
                        "            byte data[] = new byte[BUFFER];\n" +
                        "            while ((count = bis.read(data, 0, BUFFER)) != -1) {\n" +
                        "                out.write(data, 0, count);\n" +
                        "            }\n" +
                        "            bis.close();\n" +
                        "        } catch (Exception e) {\n" +
                        "            throw new RuntimeException(e);\n" +
                        "        }\n" +
                        "    }\n" +
                        "    \n" +
                        "    \n" +
                        "//    /**\n" +
                        "//     * 解压缩\n" +
                        "//     * @param sourceFile 要解压缩的文件的路径\n" +
                        "//     * @param destDir 解压缩后的目录路径\n" +
                        "//     * @throws Exception\n" +
                        "//     */\n" +
                        "//    public static void deCompress(String sourceFile,String destDir) throws Exception{\n" +
                        "//    \t//创建需要解压缩的文件对象\n" +
                        "//    \tFile file = new File(sourceFile);\n" +
                        "//        if (!file.exists()){\n" +
                        "//        \tthrow new RuntimeException(sourceFile + \"不存在！\");\n" +
                        "//        }\n" +
                        "//        //创建解压缩的文件目录对象\n" +
                        "//    \tFile destDiretory  = new File(destDir);\n" +
                        "//        if(!destDiretory.exists()){\n" +
                        "//        \tdestDiretory.mkdirs();\n" +
                        "//        }\n" +
                        "//    \t/*\n" +
                        "//         * 保证文件夹路径最后是\"/\"或者\"\\\"\n" +
                        "//         * charAt()返回指定索引位置的char值\n" +
                        "//         */\n" +
                        "//        char lastChar = destDir.charAt(destDir.length()-1);\n" +
                        "//        if(lastChar!='/'&&lastChar!='\\\\'){\n" +
                        "//        \t//在最后加上分隔符\n" +
                        "//            destDir += File.separator;\n" +
                        "//        }\n" +
                        "//        unzip(sourceFile, destDir);\n" +
                        "//    }\n" +
                        "    \n" +
                        "//    /**\n" +
                        "//     * 解压方法\n" +
                        "//     * 需要ant.jar\n" +
                        "//     */\n" +
                        "//    private static void unzip(String sourceZip,String destDir) throws Exception{\n" +
                        "//        try{\n" +
                        "//            Project p = new Project();\n" +
                        "//            Expand e = new Expand();\n" +
                        "//            e.setProject(p);\n" +
                        "//            e.setSrc(new File(sourceZip));\n" +
                        "//            e.setOverwrite(false);\n" +
                        "//            e.setDest(new File(destDir));\n" +
                        "//            e.execute();\n" +
                        "//        }catch(Exception e){\n" +
                        "//            throw e;\n" +
                        "//        }\n" +
                        "//    }\n" +
                        "\n" +
                        "    public static void main(String[] args){\n" +
                        "        String[] srcPath = new String[]{\"d:/1.txt\",\"d:/2.txt\"};\n" +
                        "        ZipUtil.compress(\"d:/1.zip\",srcPath);\n" +
                        "    }\n" +
                        "    \n" +
                        "}");

        return data.toString();
    }
}
