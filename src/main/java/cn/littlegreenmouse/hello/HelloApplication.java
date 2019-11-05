package cn.littlegreenmouse.hello;

import cn.littlegreenmouse.hello.customlistener.MyListener1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"cn.littlegreenmouse.hello.generator"})
@ServletComponentScan
public class HelloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HelloApplication.class, args);
        context.addApplicationListener(new MyListener1());
    }

}
