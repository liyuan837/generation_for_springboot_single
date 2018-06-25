package com.gen.conf;

/**
 * @Author: LiYuan
 * @Description:配置项目常量
 * @Date: 17:58 2018/5/9
 */
public interface Config {

    /**
     * 项目名称
     */
    String projectName = "spring-cloud-consumer";

    /**
     * 数据库名称
     */
    String dbName = "leolderdb";

    /**
     * groupId:
     */
    String groupId = "com.liyuan";

    /**
     * projectVersion:
     */
    String projectVersion = "1.0-SNAPSHOT";

    /**
     * 项目路径：项目所在磁盘路径
     */
    String projectPath = "D:/"+projectName+"/";

    /**
     * 项目基本包名:groupId + 项目名
     */
    String basePackage = "com.liyuan.demo";

    /**
     * 异常类名:项目名 + Exception
     */
    String exceptionName = "DemoException";

    /**
     * 生成的接口根uri：所有Controller的访问前缀，不设置或者设成项目名
     */
    //String parentUri = "/king";
    String parentUri = "/demo";

    /**
     * 入口类类名
     */
    String webApplicationName = "DemoApplication";

    /**
     * 代码路径
     */
    String javaPath = "/src/main/java/";

    /**
     * 资源路径
     */
    String resourcePath = "/src/main/resources/";

    /**
     * 项目主配置文件路径
     */
    String applicationPropertiesPath = projectPath + resourcePath;

    /**
     * 实体类所在包名
     */
    String domainPackage = basePackage + ".domain";

    /**
     * Po包名
     */
    String poPackage = domainPackage + ".po";

    /**
     * Condition包名
     */
    String conditionPackage = domainPackage + ".condition";

    /**
     * 异常类所在包
     */
    String exceptionPackage = domainPackage + ".exception";

    /**
     * ResponseEntity.java所在包
     */
    String responsePackage = domainPackage + ".response";

    /**
     * Form包名
     */
    String formPackage = basePackage + ".form";


    /**
     * Mapper.java包名
     */
    String mapperJavaPackage = basePackage + ".mapper";

    /**
     * Service.java包名
     */
    String servicePackage = basePackage + ".service";

    /**
     * ServiceImp.java包名
     */
    String serviceImplPackage = servicePackage + ".impl";

    /**
     * Vo包名
     */
    String voPackage = basePackage + ".vo";

    /**
     * Controller包名
     */
    String controllerPackage = basePackage + ".controller";

    /**
     * 自定义异常类路径
     */

    String customExceptionPath = projectPath + javaPath + exceptionPackage.replaceAll("\\.","/") + "/";

    /**
     * response类路径
     */
    String responsePath = projectPath + javaPath + responsePackage.replaceAll("\\.","/") + "/";

    /**
     * Mapper.xml路径
     */
    String mapperXMLPath = projectPath + resourcePath + mapperJavaPackage.replaceAll("\\.", "/") + "/";

    /**
     * Mapper.java文件路径
     */
    String mapperJavaPath = projectPath + javaPath + mapperJavaPackage.replaceAll("\\.", "/") + "/";

    /**
     * Service.java文件路径
     */
    String servicePath = projectPath + javaPath + servicePackage.replaceAll("\\.", "/") + "/";


    /**
     * ServiceImp.java文件路径
     */
    String serviceImplPath = servicePath + "impl/";


    /**
     * Controller.java文件路径
     */
    String controllerPath = projectPath + javaPath + controllerPackage.replaceAll("\\.", "/") + "/";

    /**
     * pom文件路径
     */
    String mainPomPath = projectPath + "/";

    /**
     * 基本包名路径
     */
    String basePackagePath = projectPath + javaPath + basePackage.replaceAll("\\.","/") + "/";

    /**
     * domain包名路径
     */
    String domainPackagePath = projectPath + javaPath + domainPackage.replaceAll("\\.","/") + "/";

    /**
     * form包名路径
     */
    String formPath = projectPath + javaPath + formPackage.replaceAll("\\.","/") + "/";

    String htmlResourcePath = projectPath + resourcePath +"html/";
}
