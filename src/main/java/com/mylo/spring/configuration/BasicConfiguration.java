package com.mylo.spring.configuration;

import com.mylo.properties.ProjectData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;


/**
 * 서비스의 기본 설정값 초기화
 *
 */
@Slf4j
@Configuration
@ComponentScan(
        basePackages = {
                "com.mylo.spring",
                "com.mylo.process.rest",
                "com.mylo.domain"
        }
)
public class BasicConfiguration {
    @Bean
    public ProjectData projectData() throws Exception {
            Yaml yaml = new Yaml();
            try (InputStream in = (new ClassPathResource("project-data.yml")).getInputStream()) {
                    ProjectData projectData = yaml.loadAs(in, ProjectData.class);
                    return projectData;
            }
    }

}
