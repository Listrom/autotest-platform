/**
 * All rights Reserved, Designed By DragonTest.
 *
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2018/11/13
 * @Copyright: 2017 DragonTest. All rights reserved.
 * 注意：本内容仅限于懒龙科技有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.dragon.platform.autotest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description:
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2018/11/13 15:45
 * @version: V1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class HolidayInfo {
    /** 编号 **/
    private String id;
    /** 月份编号 **/
    private String monthName;
    /** 日期编号 **/
    private String dayName;
    /** 类型 1普通假期 2节日**/
    private Integer type;
    /** 描述 **/
    private String description;
    /** 日期 **/
    private Date day;
}
