/**
 * All rights Reserved, Designed By DragonTest.
 *
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2019/3/23
 * @Copyright: 2017 DragonTest. All rights reserved.
 * 注意：本内容仅限于懒龙科技有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.dragon.platform.autotest.controller;

import com.dragon.platform.autotest.entity.CaseInfo;
import com.dragon.platform.common.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2019/3/23 13:12
 * @version: V1.0
 */
@Slf4j
@RestController
@RequestMapping("/testCases")
public class TestCaseController {

    /** 方法描述 **/
    @GetMapping("/list")
    public Callable<Object> list(String arg) {
        return () -> arg;
    }


    /** rest风格 **/
    @GetMapping("/rest/{type}")
    public Callable<GenericResponse<Object>> rest(@PathVariable("type") String type) {
        return () -> GenericResponse.success("你选择的类型是："+type);
    }

    /** 方法描述 **/
    @PostMapping("/rest/body")
    public Callable<GenericResponse<CaseInfo>> restBody(@RequestBody CaseInfo caseInfo) {
        return () -> {
            log.info(caseInfo.toString());
            return GenericResponse.success(caseInfo);
        };
    }

}
