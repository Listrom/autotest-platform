
package com.dragon.platform.autotest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description: 测试用例实体类
 * @author: listrom
 * @date: 2019/3/23 22:24
 * @version: V1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CaseInfo {
    /** 编号 **/
    private String id;
    /** 编号 **/
    private String name;
    /**  **/
    private String url;
    /**  **/
    private String param;
    /**  **/
    private String method;
    /** 开始时间 **/
    private Date beginDate;
}
