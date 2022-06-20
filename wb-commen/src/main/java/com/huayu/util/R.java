package com.huayu.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map<String,Object> map = new HashMap<>(); //动态数据

    public static <T> R<T> success(T object) {
        return new R<T>().setCode(1).setMsg("request success").setData(object);
    }

    public static <T> R<T> error(String msg) {

        return new R<T>().setCode(1).setMsg(msg);
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}