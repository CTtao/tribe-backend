package com.ct.tribe.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CT
 * @description
 */
public class BeanCopyUtils {
    private BeanCopyUtils(){}

    /**
     * @Author CT
     * @Description // 单拷贝
     * @Date 23:06 2022/10/27
     * @Param [source, clazz]
     * @return V
     **/
    public static <V> V copyBean(Object source,Class<V> clazz){
        V result = null;
        try {
            result = clazz.newInstance();
            BeanUtils.copyProperties(source,result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <S,V> List<V> copyBeanList(List<S> list, Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o,clazz))
                .collect(Collectors.toList());
    }
}
