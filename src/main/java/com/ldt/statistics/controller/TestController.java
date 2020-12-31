package com.ldt.statistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldt.statistics.entity.Test;
import com.ldt.statistics.utils.BaiduPersonalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author LiuDeTong
 * @date 2020/12/10 16:15
 */
@CrossOrigin
@RestController
public class TestController {

    @Autowired
    private BaiduPersonalUtil baiduPersonalUtil;

    @GetMapping("/authorize")
    public void authorize() {
        baiduPersonalUtil.authorize();
    }

    /**
     * 百度回调
     * @param code
     */
    @GetMapping("callback/baidu")
    public void token(@RequestParam("code") String code) {

        baiduPersonalUtil.token(code);
    }

    /*@PostMapping("/arr")
    public String arr(@RequestBody Test test) {
        System.err.println(test);
        return test.toString();
    }*/

    @PostMapping("/arr")
    public String arr(@RequestParam int[] arr) {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "zhangsan");
        Test test = jsonObject.toJavaObject(Test.class);
        System.err.println(test);
    }
}
