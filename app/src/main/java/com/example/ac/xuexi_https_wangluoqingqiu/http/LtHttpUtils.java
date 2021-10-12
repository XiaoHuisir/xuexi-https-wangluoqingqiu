package com.example.ac.xuexi_https_wangluoqingqiu.http;





import com.example.ac.xuexi_https_wangluoqingqiu.BuildConfig;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.AppInstallApduReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.AppInstallApduResqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardStatusReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardStatusResqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardTypeReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.CardTypeRespInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.IndentifyReqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.IndentifyResqInfo;
import com.example.ac.xuexi_https_wangluoqingqiu.http.bean.base.Rapdu;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class LtHttpUtils {

    private static LtApiBase apiBase;
    private static LtIApiService iService;

    private Call call;

    public synchronized static LtHttpUtils getInstance() {
        if (apiBase == null) {
            apiBase = new LtApiBase();
        }
        if (iService == null) {
            iService = apiBase.getService(BuildConfig.BASE_URL);
        }
        return new LtHttpUtils();
    }

    /**
     * 应用安装
     */
    public void AppManager(Callback<AppInstallApduResqInfo> callback, String msisdn, String taskId, String iccid, String operType, List<Rapdu> rapduList) {
        AppInstallApduReqInfo appInstallApduReqInfo = new AppInstallApduReqInfo();
        appInstallApduReqInfo.setMsisdn(msisdn);
        appInstallApduReqInfo.setTaskId(taskId);
        appInstallApduReqInfo.setClientType("0");
        appInstallApduReqInfo.setSeid(iccid);
        appInstallApduReqInfo.setAppletAID(BuildConfig.APPLET_AID);
        appInstallApduReqInfo.setOperType(operType);
        appInstallApduReqInfo.setApdus(rapduList);

        call = iService.appManager(appInstallApduReqInfo);
        call.enqueue(callback);
    }

    /**/
    public void getCardStatus(Callback<CardStatusResqInfo> callback, String iccid) {
        CardStatusReqInfo cardStatusReqInfo = new CardStatusReqInfo();
        cardStatusReqInfo.setClientType("0");
        cardStatusReqInfo.setSeid(iccid);

        call = iService.getCardStatus(cardStatusReqInfo);
        call.enqueue(callback);
    }

    //请求订购权益接口
    public void getIndentifyStatus(Callback<IndentifyResqInfo> callback, String iccid) {
        IndentifyReqInfo indentifyReqInfo = new IndentifyReqInfo();
        indentifyReqInfo.setIccid(iccid);

        call = iService.getIdentitystatus(indentifyReqInfo);
        call.enqueue(callback);
    }


    /**
     * 查询卡片类型
     */
    public void checkCardType(Callback<CardTypeRespInfo> callback, String iccid) {
        CardTypeReqInfo cardTypeReqInfo = new CardTypeReqInfo();
        cardTypeReqInfo.setSeid(iccid);

        call = iService.checkCardType(cardTypeReqInfo);
        call.enqueue(callback);
    }
}
