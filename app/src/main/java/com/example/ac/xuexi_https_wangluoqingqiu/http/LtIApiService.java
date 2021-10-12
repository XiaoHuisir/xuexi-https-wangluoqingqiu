package com.example.ac.xuexi_https_wangluoqingqiu.http;




import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.AppDeleteReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.AppDeleteResqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.AppInstallApduReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.AppInstallApduResqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardStatusReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardStatusResqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardTypeReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardTypeRespInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.IndentifyReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.IndentifyResqInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface LtIApiService {
    /**
     * 应用管理
     */
//    @POST("appManager")
    @POST("SeiTsm/appManager")
    Call<AppInstallApduResqInfo> appManager(@Body AppInstallApduReqInfo data);

    /**
     * 应用删除
     */
//    @POST("appDelete")
    @POST("SeiTsm/appDelete")
    Call<AppDeleteResqInfo> appDelete(@Body AppDeleteReqInfo data);


    /**
     * 开卡状态查询
     */
//    @POST("cardStatus")
    @POST("SeiTsm/cardStatus")
    Call<CardStatusResqInfo> getCardStatus(@Body CardStatusReqInfo cardStatusReqInfo);


    /**
     * 订购权益接口
     */
    @POST("api/app/verify")
    Call<IndentifyResqInfo> getIdentitystatus(@Body IndentifyReqInfo indentifyReqInfo);


    /**
     * 卡片类型
     */
    @POST("SeiTsm/cardType")
    Call<CardTypeRespInfo> checkCardType(@Body CardTypeReqInfo cardTypeReqInfo);

}
