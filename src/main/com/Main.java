package com;

import com.gen.dao.MybatisGenerator;

public class Main {
	public static void main(String[] args) throws Exception {
		MybatisGenerator generator = new MybatisGenerator();

		String[] maps = {
			"hero"
		};

		// [0]生成基类和工具类
		generator.init();

		// [1]生成模板
		for (int i = 0; i < maps.length; i++) {
			String tableName = maps[i];
			generator.generate(tableName);
		}
	}

}
