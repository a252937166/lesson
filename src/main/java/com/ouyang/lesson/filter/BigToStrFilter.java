package com.ouyang.lesson.filter;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.ouyang.lesson.annotation.BigToStr;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangduning
 * @date 2019/10/7 15:53
 */
@Component
public class BigToStrFilter implements ValueFilter {
    /**
     * 需要处理的类
     */
    private Map<String,Integer> map = null;
    /**
     * 当前实体类
     */
    private Object currentObject = null;
    private void getNames(Object object) {
        if (currentObject == object) {
            return;
        }
        currentObject = object;
        map = new HashMap<>();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        //扫描每个字段，找出需要转化的字段
        for (Field field : fields) {
            BigToStr bigToStr = field.getAnnotation(BigToStr.class);
            if (bigToStr != null) {
                map.put(field.getName(),bigToStr.length());
            }
        }
    }
    /**
     * @param object 对象
     * @param name   对象的字段的名称
     * @param value  对象的字段的值
     */
    @Override
    public Object process(Object object, String name, Object value) {
        getNames(object);
        //如果是需要转化的字段，对值进行转化
        if (map.containsKey(name) && value instanceof BigDecimal) {
            return bigDecimal2String((BigDecimal) value,map.get(name));
        }
        return value;
    }


    private static String bigDecimal2String(BigDecimal var,Integer length){
        if(null==var) {
            StringBuilder value = new StringBuilder("0.0");
            while (length > 1) {
                value.append("0");
                length--;
            }
            return value.toString();
        }
        //BigDecimal格式化
        return var.setScale(length,BigDecimal.ROUND_HALF_UP).toPlainString();
    }
}
