package com.ouyang.lesson;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import com.ouyang.lesson.http.HttpApi;
import okhttp3.ResponseBody;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import retrofit2.Call;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = "com.ouyang.lesson.dao")
@EnableTransactionManagement
@ServletComponentScan(basePackages = "com.ouyang.lesson.filter")
@RetrofitScan("com.ouyang.lesson.http")
public class LessonApplication {

    @Autowired
    private HttpApi httpApi;

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(LessonApplication.class, args);
    }

    @PostConstruct
    public void t() throws IOException {
        Call<ResponseBody> personCall = httpApi.getPersonCall();
        System.out.println(personCall.execute());
    }

}
