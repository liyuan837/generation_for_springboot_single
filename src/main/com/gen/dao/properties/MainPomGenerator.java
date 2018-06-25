package com.gen.dao.properties;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class MainPomGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "\t<modelVersion>4.0.0</modelVersion>\n" +
                "\n" +
                "\t<groupId>"+Config.groupId+"</groupId>\n" +
                "\t<artifactId>"+Config.projectName+"</artifactId>\n" +
                "\t<version>"+ Config.projectVersion+"</version>\n" +
                "\t<packaging>jar</packaging>\n" +
                "\n" +
                "\t<name>"+Config.projectName+"</name>\n" +
                "\t<description>"+Config.projectName+" project for Spring Boot</description>\n" +
                "\n" +
                "\t<parent>\n" +
                "\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t<artifactId>spring-boot-starter-parent</artifactId>\n" +
                "\t\t<version>2.0.1.RELEASE</version>\n" +
                "\t\t<relativePath/>\n" +
                "\t</parent>\n" +
                "\n" +
                "\t<properties>\n" +
                "\t\t<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n" +
                "\t\t<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n" +
                "\t\t<java.version>1.8</java.version>\n" +
                "\t</properties>\n" +
                "\n" +
                "\t<dependencies>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-web</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-test</artifactId>\n" +
                "\t\t\t<scope>test</scope>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--mysql驱动依赖-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>mysql</groupId>\n" +
                "\t\t\t<artifactId>mysql-connector-java</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--mybatis和spring整合的依赖-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.mybatis.spring.boot</groupId>\n" +
                "\t\t\t<artifactId>mybatis-spring-boot-starter</artifactId>\n" +
                "\t\t\t<version>1.3.1</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--c3p0连接池依赖-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>com.mchange</groupId>\n" +
                "\t\t\t<artifactId>c3p0</artifactId>\n" +
                "\t\t\t<version>0.9.5.2</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--数据库连接池-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>com.zaxxer</groupId>\n" +
                "\t\t\t<artifactId>HikariCP</artifactId>\n" +
                "\t\t\t<version>2.4.0</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--redis缓存数据库依赖-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t<artifactId>spring-boot-starter-data-redis</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--swagger依赖-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>io.springfox</groupId>\n" +
                "\t\t\t<artifactId>springfox-swagger2</artifactId>\n" +
                "\t\t\t<version>2.5.0</version>\n" +
                "\t\t</dependency>\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>io.springfox</groupId>\n" +
                "\t\t\t<artifactId>springfox-swagger-ui</artifactId>\n" +
                "\t\t\t<version>2.5.0</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--分页插件-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>com.github.pagehelper</groupId>\n" +
                "\t\t\t<artifactId>pagehelper-spring-boot-starter</artifactId>\n" +
                "\t\t\t<version>1.2.3</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.springframework.data</groupId>\n" +
                "\t\t\t<artifactId>spring-data-commons</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>commons-beanutils</groupId>\n" +
                "\t\t\t<artifactId>commons-beanutils</artifactId>\n" +
                "\t\t\t<version>1.6</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.apache.commons</groupId>\n" +
                "\t\t\t<artifactId>commons-lang3</artifactId>\n" +
                "\t\t\t<version>3.0.1</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--jwt-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>io.jsonwebtoken</groupId>\n" +
                "\t\t\t<artifactId>jjwt</artifactId>\n" +
                "\t\t\t<version>0.5.1</version>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--可以用@Data注解取代getter和setter方法-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>org.projectlombok</groupId>\n" +
                "\t\t\t<artifactId>lombok</artifactId>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<!--json依赖-->\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>net.sf.json-lib</groupId>\n" +
                "\t\t\t<artifactId>json-lib</artifactId>\n" +
                "\t\t\t<version>2.4</version>\n" +
                "\t\t\t<classifier>jdk15</classifier>\n" +
                "\t\t</dependency>\n" +
                "\n" +
                "\t\t<dependency>\n" +
                "\t\t\t<groupId>commons-collections</groupId>\n" +
                "\t\t\t<artifactId>commons-collections</artifactId>\n" +
                "\t\t\t<version>3.2.1</version>\n" +
                "\t\t</dependency>\n" +
                "\t</dependencies>\n" +
                "\n" +
                "\t<build>\n" +
                "\t\t<plugins>\n" +
                "\t\t\t<plugin>\n" +
                "\t\t\t\t<groupId>org.springframework.boot</groupId>\n" +
                "\t\t\t\t<artifactId>spring-boot-maven-plugin</artifactId>\n" +
                "\t\t\t</plugin>\n" +
                "\t\t</plugins>\n" +
                "\t</build>\n" +
                "\n" +
                "\n" +
                "</project>\n");

        return data.toString();
    }
}
