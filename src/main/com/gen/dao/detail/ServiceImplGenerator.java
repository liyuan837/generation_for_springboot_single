package com.gen.dao.detail;

import com.gen.conf.Config;
import com.gen.dao.DatabaseTableInfo;

import java.sql.SQLException;


/**
 * @Author: LiYuan
 * @Description:生成ServiceImpl.java
 * @Date: 11:54 2018/5/11
 */
public class ServiceImplGenerator {

	
	public String generate(DatabaseTableInfo dbTableInfo) throws SQLException {

		String poClassName=dbTableInfo.getPo().getClassName();
		String conditionClassName=dbTableInfo.getCondition().getClassName();

		StringBuffer data = new StringBuffer();

		data.append("package " + Config.serviceImplPackage + ";\r\n\r\n")

				.append("import " + dbTableInfo.getPo().getPackageName() + "." + poClassName + ";\r\n")
				.append("import " + dbTableInfo.getCondition().getPackageName() + "." + conditionClassName + ";\r\n")
				.append("import " + Config.mapperJavaPackage + "." + dbTableInfo.getMapperClassName() + ";\r\n")
				.append("import org.springframework.cache.annotation.CacheConfig;\r\n")
				.append("import org.springframework.cache.annotation.Cacheable;\r\n")
				.append("import "+ Config.exceptionPackage + "." + Config.exceptionName +";\r\n")
				.append("import "+ Config.serviceImplPackage +".BaseServiceImpl;\r\n");
		if (!Config.serviceImplPackage.equals(Config.servicePackage)) {
			data.append("import " + Config.servicePackage + "." + dbTableInfo.getServiceClassName() + ";\r\n");
		}

		data.append("import org.springframework.stereotype.Service;\r\n\r\n");
		data.append("@Service\r\n" +
				"@CacheConfig(cacheNames = \""+dbTableInfo.getPo().getPackageName()+"\")\r\n")
				.append("public class " + dbTableInfo.getServiceImplClassName() + " extends BaseServiceImpl<" + poClassName + ", " + conditionClassName + ", " + dbTableInfo.getMapperClassName() + "> implements " + dbTableInfo.getServiceClassName() + " {\r\n\r\n")
				.append("@Override\n" +
						"    @Cacheable(key = \"#id\")\n" +
						"    public "+poClassName+" queryWithValid(Object id) throws "+Config.exceptionName+" {\n" +
						"        return super.queryWithValid(id);\n" +
						"    }")
		.append("}");

		return data.toString();
	}



}
