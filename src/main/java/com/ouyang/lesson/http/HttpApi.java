package com.ouyang.lesson.http;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author ouyangduning
 * @date 2020/9/23 10:24
 */
@RetrofitClient(baseUrl = "${http.baseUrl}")
public interface HttpApi {

    /**
     * Call<T> <br>
     * 不执行适配处理，直接返回Call<T>对象
     *
     * @param id id
     * @return Call<T>实例
     */
    @GET("/")
    Call<ResponseBody> getPersonCall();
}
