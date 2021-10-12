package com.example.ac.xuexi_https_wangluoqingqiu.cardutils;


import com.example.ac.xuexi_https_wangluoqingqiu.interfaces.ThreadPoolManager;
import com.example.ac.xuexi_https_wangluoqingqiu.oma.CardResult;
import com.example.ac.xuexi_https_wangluoqingqiu.oma.SmartCard;

public class GetCardIccidUtils {


    public static void getIccid(OperationCallBack<Result> callBack) {
//        String[] defaultCapu = {"00A4040010A0000000871002FF86FFFF89FFFFFFFF", "01A4000C023F00", "01A4000C022FE2", "00B000000A"};
        String[] defaultCapu = {"00A4040010A0000000871002FF86FFFF89FFFFFFFF", "01A4000C023F00", "01A4000C022FE2", "00B000000A"};
        ThreadPoolManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                CardResult cardResult = null;
                for (String capu : defaultCapu) {
                    //执行指令
                    cardResult = SmartCard.getInstance().execute(capu);
                    if (cardResult.getStatus() == -1) {
                        callBack.complete(new Result(cardResult.getStatus(), cardResult.getMessage()));
                        SmartCard.getInstance().closeChannel();
                        return;
                    }
                }
                if (cardResult.getStatus() == 0) {
                    String iccid = Utils.reverse(cardResult.getRapdu());
                    callBack.complete(new Result(cardResult.getStatus(), iccid, cardResult.getMessage()));
                    SmartCard.getInstance().closeChannel();
                    return;
                }
                callBack.complete(new Result(cardResult.getStatus(), cardResult.getMessage()));
                SmartCard.getInstance().closeChannel();
            }
        });
    }
}
