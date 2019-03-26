package com.example.springaop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.rongdasoft.com
 *
 * @version V1.0
 * @Title: HelloController
 * @Description:
 * @author:jichao
 * @date: 2019/3/22
 * @Copyright: 2019/3/22 www.rongdasoft.com
 * Inc. All rights reserved.
 */
@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/index")
    public String indexController() {
        System.out.println("index");
        logger.info("info msg");
        logger.error("error msg");
        logger.debug("debug msg");
        return "index";
    }
}
