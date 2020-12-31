package com.ldt.statistics.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LiuDeTong
 * @date 2020/12/10 16:10
 */
@SpringBootTest
public class BaiduPersonalUtilTest {

    @Autowired
    private BaiduPersonalUtil baiduPersonalUtil;

    @Test
    public void test1() {
        baiduPersonalUtil.authorize();
    }
}