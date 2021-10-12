package com.example.ac.xuexi_https_wangluoqingqiu.interfaces;

import com.example.ac.xuexi_https_wangluoqingqiu.oma.CardResult;
import com.example.ac.xuexi_https_wangluoqingqiu.oma.SmartCard;

public class InterfaceManage {
    public static void getInterface(InterfaceApi<CardResult> interfaceApi){
        ThreadPoolManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                InterfaceBean zhang = new InterfaceBean("zhang", "100", "9000");
//        interfaceApi.complete(zhang);
                CardResult cardResult=null;
                cardResult = SmartCard.getInstance().execute("S");
                String rapdu = cardResult.getRapdu();
                interfaceApi.complete(cardResult);
            }
        });

    }
}
