package com.ouyang.lesson.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ouyang.lesson.filter.BigToStrFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect;
import static com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames;

/**
 * @author Ouyang
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private BigToStrFilter bigToStrFilter;
    @Autowired
    private JTalkClientLoginInterceptor interceptor;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //序列化配置
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // 输出key时是否使用双引号
                QuoteFieldNames,
                //禁止循环引用
                DisableCircularReferenceDetect
        );
        config.setSerializeFilters(bigToStrFilter);
        converter.setFastJsonConfig(config);
        //优先使用FastJson进行序列化
        converters.set(1,converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //log.info("PortalWebMvcConfig#当前的appToken:{}",appToken);
        //properties.put("app.token", appToken);

        //H5登录拦截
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/log/hindex.htm");

    }

}