/**
 * All rights Reserved, Designed By DragonTest.
 *
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2018/3/15
 * @Copyright: 2017 DragonTest. All rights reserved.
 * 注意：本内容仅限于懒龙科技有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.dragon.platform.autotest.repository;

import com.dragon.platform.autotest.entity.HolidayInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2018/3/15 14:59
 * @version: V1.0
 */
@Mapper
@Repository
public interface HolidayInfoRepository {

    /**
     * 按月份查找节假日
     * @param month 月份
     * @return 节假日列表
     */
    List<HolidayInfo> findByMonth(String month);

    /**
     * 按月份查找节假日
     * @param month 月份
     * @return 节假日列表
     */
    List<String> findHolidayListByMonth(String month);

    /**
     * 按月份查找节假日
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return 节假日列表
     */
    List<String> findHolidayListByDate(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    /**
     * 根据日期区间查询节假日
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return 节假日列表
     */
    Map findHolidayByDate(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    /**
     * 根据节假日查询日期区间
     * @param year 年份
     * @param holiday 节假日名称
     * @return 节假日列表
     */
    Map findDateByHoliday(@Param("year") String year, @Param("holiday") String holiday);

    /**
     * 查询最近的10个节假日
     * @return 节假日列表
     */
    List<String> findNearFutureHoliday();
}
