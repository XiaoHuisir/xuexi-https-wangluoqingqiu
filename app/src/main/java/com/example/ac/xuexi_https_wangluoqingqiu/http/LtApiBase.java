package com.example.ac.xuexi_https_wangluoqingqiu.http;

import android.util.Log;


import com.example.ac.xuexi_https_wangluoqingqiu.utils.LogUtil;
import com.example.ac.xuexi_https_wangluoqingqiu.utils.encoder.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LtApiBase implements HttpLoggingInterceptor.Logger {
    private final String TAG = "ApiBase";
    private final int TIMEOUT = 30;
    //请求日志拦截器
    public HttpLoggingInterceptor mHttpLogInterceptor;

    protected LtIApiService getService(String ip) {
        mHttpLogInterceptor = new HttpLoggingInterceptor(this);
        //打印http的body体
        mHttpLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        SSLContext sslContext = null;
      /*  try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }*/
        LogUtil.e("ApiBase", "baseUrl:" + ip);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpInterceptor())
                .addInterceptor(mHttpLogInterceptor)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                //.sslSocketFactory(sslContext.getSocketFactory(), xtm)
                .hostnameVerifier(DO_NOT_VERIFY)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ip)
                .client(client)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(LtIApiService.class);
    }


    private HostnameVerifier DO_NOT_VERIFY = (hostname, session) -> true;

    private X509TrustManager xtm = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
            //do nothing
            LogUtil.d(TAG, "checkClientTrusted");
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
            //do nothing
            LogUtil.d(TAG, "checkServerTrusted");
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] x509Certificates = new X509Certificate[0];
            return x509Certificates;
        }
    };

    @Override
    public void log(String message) {
        if (message.length() > 4000) {
            Log.e(TAG, "sb.length = " + message.length());
            int chunkCount = message.length() / 4000;     // integer division
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= message.length()) {
                    Log.e(TAG, "chunk " + i + " of " + chunkCount + ":" + message.substring(4000 * i));
                } else {
                    Log.e(TAG, "chunk " + i + " of " + chunkCount + ":" + message.substring(4000 * i, max));
                }
            }
        } else {
            Log.e(TAG, message);
        }
    }


    private class HttpInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request oldRequest = chain.request();
            //获取请求体字符串
            Buffer sink = new Buffer();
            oldRequest.body().writeTo(sink);
            String string = sink.readString(Charset.defaultCharset());
            //将请求体字符串签名之后加到请求头
            Request request = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .headers(oldRequest.headers())
                    .tag(oldRequest.tag())
                    .cacheControl(oldRequest.cacheControl())
                    .header("Accept", "application/json")
                    .header("sign", getSign(string))
                    .build();
            return chain.proceed(request);
        }
    }

    private static byte[] key = "A301D46C29176D5F".getBytes();

    private static BASE64Encoder encoder = new BASE64Encoder();

    //对请求体字符串进行签名
    private static String getSign(String data) {
        String ret = null;
        try {
            ret = encodeBase64(encodeHmacMD5(key, data.trim().getBytes("UTF-8")));
        } catch (Exception e) {
        }
        return ret;
    }

    private static String encodeBase64(byte[] data) {
        String ret = null;
        try {
            ret = encoder.encodeBuffer(data).replaceAll("(\r|\n|\t)", "");
        } catch (Exception e) {
        }
        return ret;
    }

    private static byte[] encodeHmacMD5(byte[] key, byte[] data) {
        byte[] ret = null;
        try {
            Mac mac = Mac.getInstance("HmacMD5");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacMD5");
            mac.init(secretKeySpec);
            ret = mac.doFinal(data);
        } catch (Exception e) {
        }
        return ret;
    }
}
