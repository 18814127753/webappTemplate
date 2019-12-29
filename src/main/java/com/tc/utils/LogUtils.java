package com.tc.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogUtils {
	private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);
	@Test
	public void test(){
		logger.debug("debug哈哈哈");
		logger.info("info哈哈哈");
		logger.warn("warn哈哈哈");
		logger.error("error哈哈哈");
	}
}
