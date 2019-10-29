package cn.littlegreenmouse.hello.model.yaml;

import cn.littlegreenmouse.hello.config.MixPropertySourceFactory;
import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Component
@Validated
@PropertySource(value = {"classpath:family.yaml"}, factory = MixPropertySourceFactory.class)
@ConfigurationProperties(prefix = "family")
public class Family {
    // @Value("${family.family-name}")
    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
    @Email
    private String email;
}
