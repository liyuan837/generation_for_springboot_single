package com.gen.dao.config;

import com.gen.conf.Config;

/**
 * @Author: LiYuan
 * @Description:
 * @Date: 17:20 2018/5/17
 */
public class MyBatisConfigurationGenerator {
    public String generate() {
        StringBuffer data = new StringBuffer();
        data.append("package " + Config.basePackage + ".config;\r\n\r\n")

                .append("import com.zaxxer.hikari.HikariDataSource;\r\n")
                .append("import org.apache.ibatis.session.SqlSessionFactory;\r\n")
                .append("import org.mybatis.spring.SqlSessionFactoryBean;\r\n")
                .append("import org.mybatis.spring.SqlSessionTemplate;\r\n")
                .append("import org.mybatis.spring.annotation.MapperScan;\r\n")
                .append("import org.springframework.beans.factory.annotation.Qualifier;\r\n")
                .append("import org.springframework.beans.factory.annotation.Value;\r\n")
                .append("import org.springframework.context.annotation.Bean;\r\n")
                .append("import org.springframework.context.annotation.Configuration;\r\n")
                .append("import org.springframework.context.annotation.Primary;\r\n")
                .append("import org.springframework.jdbc.datasource.DataSourceTransactionManager;\r\n")
                .append("import org.springframework.transaction.annotation.EnableTransactionManagement;\r\n")
                .append("import javax.sql.DataSource;\r\n\n")

                .append("@Configuration\n" +
                        "@MapperScan(basePackages={\""+ Config.mapperJavaPackage+"\"},sqlSessionTemplateRef = \"makeSqlSessionTemplate\")\n" +
                        "@EnableTransactionManagement\n" +
                        "public class MyBatisConfiguration {\n" +
                        "    @Value(\"${jdbc.driver}\")\n" +
                        "    private String driverClassName;\n" +
                        "    @Value(\"${jdbc.url}\")\n" +
                        "    private String url;\n" +
                        "    @Value(\"${jdbc.username}\")\n" +
                        "    private String username;\n" +
                        "    @Value(\"${jdbc.password}\")\n" +
                        "    private String password;\n" +
                        "\n" +
                        "    @Bean(destroyMethod = \"close\",name = \"dataSource\")\n" +
                        "    @Primary\n" +
                        "    public DataSource primaryDataSource() {\n" +
                        "        HikariDataSource hikariDataSource = new HikariDataSource();\n" +
                        "        hikariDataSource.setPoolName(\""+ Config.projectName+"\");\n" +
                        "        hikariDataSource.setDriverClassName(driverClassName);\n" +
                        "        hikariDataSource.setJdbcUrl(url);\n" +
                        "        hikariDataSource.setUsername(username);\n" +
                        "        hikariDataSource.setPassword(password);\n" +
                        "        return hikariDataSource;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Bean(name = \"makeDataSourceTransactionManager\")\n" +
                        "    @Primary\n" +
                        "    public DataSourceTransactionManager makeDataSourceTransactionManager(@Qualifier(\"dataSource\")DataSource dataSource) {\n" +
                        "        DataSourceTransactionManager manager = new DataSourceTransactionManager();\n" +
                        "        manager.setDataSource(dataSource);\n" +
                        "        return manager;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Bean(name = \"makeSqlSessionFactoryBean\")\n" +
                        "    @Primary\n" +
                        "    public SqlSessionFactory makeSqlSessionFactoryBean(@Qualifier(\"dataSource\")DataSource dataSource) throws Exception {\n" +
                        "        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();\n" +
                        "        sessionFactory.setDataSource(dataSource);\n" +
                        "        sessionFactory.setTypeAliasesPackage(\""+Config.domainPackage+"\");\n" +
                        "        return sessionFactory.getObject();\n" +
                        "    }\n" +
                        "\n" +
                        "    @Bean(name = \"makeSqlSessionTemplate\")\n" +
                        "    @Primary\n" +
                        "    public SqlSessionTemplate makeSqlSessionTemplate(@Qualifier(\"makeSqlSessionFactoryBean\")SqlSessionFactory sqlSessionFactory) throws Exception {\n" +
                        "        return new SqlSessionTemplate(sqlSessionFactory);\n" +
                        "    }\n" +
                        "}\n");

        return data.toString();
    }
}
