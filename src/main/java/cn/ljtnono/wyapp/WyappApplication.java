package cn.ljtnono.wyapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  springboot启动程序
 *  @author 凌家童
 *  @date 2019/9/5
 *  @version 1.0
 *
*/
@SpringBootApplication
@MapperScan(basePackages = {"cn.ljtnono.wyapp.dao"})
public class WyappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WyappApplication.class, args);
    }

}
