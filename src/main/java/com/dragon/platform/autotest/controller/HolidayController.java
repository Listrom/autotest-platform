/**
 * All rights Reserved, Designed By DragonTest.
 *
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2018/11/13
 * @Copyright: 2017 DragonTest. All rights reserved.
 * 注意：本内容仅限于懒龙科技有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.dragon.platform.autotest.controller;

import com.dragon.platform.autotest.repository.HolidayInfoRepository;
import com.dragon.platform.common.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @description:
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2018/11/13 14:38
 * @version: V1.0
 */
@Slf4j
@RestController
public class HolidayController {

    @Autowired
    private HolidayInfoRepository holidayInfoRepository;

    /** 查询节假日列表 **/
    @GetMapping("/open/holiday")
    public Callable<List<String>> holiday(@RequestParam(value = "begin") Long begin, @RequestParam(value = "end") Long end) {
        Date beginDate = getDate(begin);
        Date endDate = getDate(end);
        return () -> holidayInfoRepository.findHolidayListByDate(beginDate, endDate);
    }

    /** 测试部署版本 **/
    @GetMapping("/open/version/test")
    public Callable<String> holidayTest() {
        return () -> "测试部署版本 V2.0  时间：2018年11月21日10:53:39";
    }

    /** 仅获取日期部分 **/
    private static Date getDate(Long time){
        Calendar cl = Calendar.getInstance();
        cl.setTimeInMillis(time);
        cl.set(Calendar.HOUR_OF_DAY,0);
        cl.set(Calendar.MINUTE,0);
        cl.set(Calendar.SECOND,0);
        cl.set(Calendar.MILLISECOND,0);
        return cl.getTime();
    }

    /**
     * 根据日期区间查询节假日
     * @param begin 开始时间
     * @param end 结束时间
     * @return 节假日列表
     */
    @GetMapping("/open/holiday/by/date")
    public Callable<GenericResponse<Map>> findHolidayByDate(@RequestParam("beginDate") Long begin, @RequestParam("endDate") Long end){
        Date beginDate = getDate(begin);
        Date endDate = getDate(end);
        return () -> GenericResponse.success(holidayInfoRepository.findHolidayByDate(beginDate, endDate));
    }

    /**
     * 根据节假日查询日期区间
     * @param holiday 节假日名称
     * @return 节假日列表
     */
    @GetMapping("/open/date/by/holiday")
    public Callable<GenericResponse<Map>> findDateByHoliday(@RequestParam("holiday") String holiday) {
        String[] param = holiday.split("-");
        if (param.length != 2) {
            return () -> GenericResponse.failed("参数错误");
        }
        return () -> GenericResponse.success(holidayInfoRepository.findDateByHoliday(param[0], param[1]));
    }

    /**
     * 查询最近的10个节假日
     * @return 节假日列表
     */
    @GetMapping("/open/near/future/holiday")
    public Callable<GenericResponse<List<String>>> findNearFutureHoliday(){
        return () -> GenericResponse.success(holidayInfoRepository.findNearFutureHoliday());
    }



    /**
     * 查询最近的10个节假日
     * @return 节假日列表
     */
    @GetMapping("/open/near/test")
    public Callable<GenericResponse<List<String>>> findTest(){
        return () -> GenericResponse.success(holidayInfoRepository.findNearFutureHoliday());
    }
}
