/**
 * All rights Reserved, Designed By DragonTest.
 *
 * @author: 刘一男<liu_yn1@DragonTest.com>
 * @date: 2019/3/23
 * @Copyright: 2017 DragonTest. All rights reserved.
 * 注意：本内容仅限于懒龙科技有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.dragon.platform.autotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: 刘一男<liu_yn1@DragonTest.com>
 * @date: 2019/3/23 13:12
 * @version: V1.0
 */
@RestController
@RequestMapping("/testCases")
public class TestCaseController {

    /** 方法描述 **/
    @GetMapping("/list")
    public Callable<Object> list(String arg) {
        return () -> arg;
    }
}
