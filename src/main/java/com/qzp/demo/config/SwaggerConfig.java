package com.qzp.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @projectname springbootDemo
 * @Classname SwaggerConfig
 * @Description swagger2配置类
 * @Version 1.0.0
 * @Date 2022/8/26 14:05
 * @Created by qiuzepeng
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     *  创建API应用
     *  apiInfo() 增加API相关信息
     *  通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     *  本例采用指定扫描的包路径来定义指定要建立API的目录。
     * @return
     */
    @Bean
    public Docket createRestApi() {
        final String SWAGGER_SCAN_BASE_PACKAGE = "com.qzp.demo.controller";
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
//                .apis(RequestHandlerSelectors.basePackage("com.qzp.demo.controller"))//扫描服务的包
              //  .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * http://localhost:8080/swagger-ui/index.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot API 文档")
                .description("springboot API 接口")
//                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }
}
