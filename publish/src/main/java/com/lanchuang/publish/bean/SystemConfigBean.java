package com.lanchuang.publish.bean;

import com.lanchuang.publish.config.YamlConfigFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 子系统配置项接受实体，读取sysConfig.yml文件注入到实体中
 * @author Vincent Tao
 * @date 2019/6/25 9:38
 */
@Component
@PropertySource(value ={"classpath:sysConfig.yml"},ignoreResourceNotFound = true, encoding = "utf-8", factory = YamlConfigFactory.class)
@ConfigurationProperties(prefix = "public-system" )
public class SystemConfigBean {
    private Map<String,Map<String,Boolean>> subSystem;

    public Map<String, Map<String, Boolean>> getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(Map<String, Map<String, Boolean>> subSystem) {
        this.subSystem = subSystem;
    }
}
