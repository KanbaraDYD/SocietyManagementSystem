package com.societymanagementsystem.back.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
/**
 * <p>created time:2023/4/25 19:34</p>
 * <p>des:
 *     代码生成器（新）
 * </p>
 *
 * @author Ya Shi
 */
public class CodeGenerator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/societymanagementsystem?characterEncoding=UTF-8", "root", "admin")
            .dbQuery(new MySqlQuery());

    /**
     * 输出路径
     */
    private static final String outputDir = System.getProperty("user.dir") + "/src/main/java";

    public static void main(String[] args) {

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("Kanbara") // 设置作者
//                            .enableSpringdoc()
                            // .enableSwagger() // 开启 swagger 模式
                            .outputDir(outputDir)   // 指定输出目录
                            .disableOpenDir();   //禁止打开输出目录
                })
                .packageConfig(builder -> {
                    // builder.parent("com.ya.boottest.fruit.autoCode"); // 设置父包名
                    builder.parent("com.societymanagementsystem.back"); // 设置父包名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("manage")
                            .controllerBuilder().enableFileOverride().enableRestStyle()
                            .serviceBuilder().enableFileOverride()
                            .entityBuilder().enableFileOverride().enableLombok()
                            .mapperBuilder().enableFileOverride().enableMapperAnnotation(); // 设置需要生成的表名
                })
//                .templateConfig(builder -> {
//                    builder.controller("templates/controller.java")
//                            .service("templates/service.java")
//                            .serviceImpl("templates/serviceImpl.java")
//                            .entity("templates/entity.java");
//                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}


