package com.fei.androidmodel.http.inter;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface RequestApi {

    //本来应该是以Observable<BaseEntity<UserEntity>> 形式返回，因为后台没统一，所以BaseEntity没用

    @GET("versionUpdate/update_info.do")
    Call<ResponseBody> update();

    @GET("App/login.shtml")
    Observable<ResponseBody> login(@QueryMap Map<String, String> map);

//    @GET("api.php?op=content")
//    Observable<List<NcwEntity>> getNcw();
//
//    @FormUrlEncoded
//    @POST("app/field/getRecommendPlansMore.do")
//    Observable<BaseEntity<List<RecommendEntity>>> getRecommendPlan(@FieldMap Map<String, String> map);


}
