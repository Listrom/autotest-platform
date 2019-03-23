/**
 * All rights Reserved, Designed By DragonTest.
 *
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2017/11/21
 * @Copyright: ©2017 DragonTest. All rights reserved.
 * 注意：本内容仅限于懒龙科技有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.dragon.platform.common.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * @description: 自定义返回
 * @author: Listrom<listrom@DragonTest.com>
 * @date: 2017/11/21 上午11:16
 * @version: V1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GenericResponse<T> {

    /**
     * 默认成功code
     */
    public static final String DEFAULT_SUCCESS_CODE = "0";

    /**
     * 默认成功message
     */
    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 默认失败code
     */
    public static final String DEFAULT_FAILED_CODE = "9999";

    /**
     * 默认失败message
     */
    public static final String DEFAULT_FAILED_MESSAGE = "FAILED";

    @Builder.Default
    private String code = DEFAULT_SUCCESS_CODE;

    @Builder.Default
    private String message = DEFAULT_SUCCESS_MESSAGE;

    private T data;

    /**
     * 返回成功方法
     * 
     * @return
     */
    public static GenericResponse success() {
        return success(null);
    }

    /**
     * 返回带数据成功方法
     * 
     * @param data
     * @param <T>
     * @return
     */
    public static <T> GenericResponse success(T data) {
        return success("0", "SUCCESS", data);
    }

    /**
     * 自定义code message成功方法
     * 
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> GenericResponse success(String code, String message, T data) {
        Objects.requireNonNull(code);
        Objects.requireNonNull(message);
        return GenericResponse.<T>builder().code(code).message(message).data(data).build();
    }

    /**
     * 默认失败方法
     * 
     * @return
     */
    public static GenericResponse failed() {
        return failed(DEFAULT_FAILED_CODE, DEFAULT_FAILED_MESSAGE);
    }

    /**
     * 自定义message失败方法
     * 
     * @param message
     * @return
     */
    public static GenericResponse failed(String message) {
        return failed(DEFAULT_FAILED_CODE, message);
    }

    /**
     * 自定义code message失败方法
     * 
     * @param code
     * @param message
     * @return
     */
    public static GenericResponse failed(String code, String message) {
        return GenericResponse.builder().code(code).message(message).build();
    }

    public Boolean successed() {
        return DEFAULT_SUCCESS_CODE.equals(this.getCode());
    }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }

}
