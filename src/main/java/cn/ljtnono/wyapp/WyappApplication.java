package cn.ljtnono.wyapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.ljtnono.wyapp.dao"})
public class WyappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WyappApplication.class, args);
    }

}
