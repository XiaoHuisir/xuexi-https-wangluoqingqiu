package com.example.ac.xuexi_https_wangluoqingqiu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ac.xuexi_https_wangluoqingqiu.demo.Utils;
import com.example.ac.xuexi_https_wangluoqingqiu.interfaces.InterfaceApi;
import com.example.ac.xuexi_https_wangluoqingqiu.interfaces.InterfaceBean;
import com.example.ac.xuexi_https_wangluoqingqiu.interfaces.InterfaceManage;
import com.example.ac.xuexi_https_wangluoqingqiu.oma.CardResult;
import com.example.ac.xuexi_https_wangluoqingqiu.utils.ConstantUtils;
import com.example.ac.xuexi_https_wangluoqingqiu.utils.LogUtil;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.ac.xuexi_https_wangluoqingqiu.demo.Utils.isWifiConnect;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;
    private Context context;
    private static final int ONE_TYPE = ConstantUtils.ONE_1;
    private static final int TWO_TYPE = ONE_TYPE + 1;
    private static final int THREE_TYPE = TWO_TYPE + 1;
    @SuppressLint("HandlerLeak")
    final
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ONE_TYPE:
                    Timer timer = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, "1" + "\n" + "1", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    };
                    timer.schedule(timerTask, 1000, 2000);
                    break;
                case TWO_TYPE:
                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    break;
                case THREE_TYPE:

                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        tvTest = findViewById(R.id.tv_test);
        initgetData();
    }

    private void initgetData() {
        final double startTime = System.currentTimeMillis();
        Utils.getInstance().getUtilsManag(context, domeBean -> {
//
            float f = domeBean.getF() * 100;
            String substring = String.valueOf(f).substring(0, String.valueOf(f).indexOf("."));
            LogUtil.d(" \n" + "是否有网络连接：" + domeBean.isA() + "\n" + "是否为wifi连接状态:" + domeBean.isB() + "\n" + "是否安装了sdcard:" +
                    domeBean.isC() + "\n" + "获取系统内部可用空间大小:" + domeBean.getD() + "\n获取sd卡可用空间大小:" + domeBean.getE() + "\n" + "获取电池电量:" +
                    substring + "%" + "\n" + "获取手机名称:" + domeBean.getG());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvTest.setText(" \n" + "是否有网络连接：" + domeBean.isA() + "\n" + "是否为wifi连接状态:" + domeBean.isB() + "\n" + "是否安装了sdcard:" +
                            domeBean.isC() + "\n" + "获取系统内部可用空间大小:" + domeBean.getD() + "\n获取sd卡可用空间大小:" + domeBean.getE() + "\n" + "获取电池电量:" +
                            substring + "%" + "\n" + "获取手机名称:" + domeBean.getG() + "\n" + "耗时：" + (System.currentTimeMillis() - startTime) / 1000 + "s");
                }
            });

        });
    }

    public void btns(View view) {
//        Message message = new Message();
//        message.what = ONE_TYPE;
//        message.obj = "one and two";
//        handler.sendMessageDelayed(message, 1000);
        initgetData();
//        InterfaceManage.getInterface(new InterfaceApi<CardResult>() {
//            @Override
//            public void complete(CardResult cardResult) {
//                cardResult.getMessage()
//            }
//        });
        InterfaceManage.getInterface(interfaceBean -> {
            int status = interfaceBean.getStatus();
            if (status == 0) {
                tvTest.setText(interfaceBean.getMessage() + "\n" + interfaceBean.getStatus());
            } else {
                LogUtil.d("null");
                return;
            }

        });
    }

    public void btns1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("yct://load.server:9999/main"));
        startActivity(intent);
    }

    /**
     * activity跳转 activity2
     */
    public void btnsnoe(View view) {
        handler.sendEmptyMessage(TWO_TYPE);
//        handler.sendEmptyMessageDelayed(TWO_TYPE, 1000);
    }
}