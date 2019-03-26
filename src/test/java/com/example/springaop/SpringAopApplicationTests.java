package com.example.springaop;

import com.example.springaop.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        System.out.println("index");
        logger.info("info msg");
        logger.error("error msg");
        logger.debug("debug msg");
    }

}
