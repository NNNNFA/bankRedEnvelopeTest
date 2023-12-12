package com.nfa.bank;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.AlipayConfig;
import com.alipay.api.response.AlipayMarketingMaterialImageUploadResponse;
import com.alipay.api.request.AlipayMarketingMaterialImageUploadRequest;
import com.alipay.api.domain.BelongMerchantInfo;
import com.alipay.api.FileItem;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class AlipayMarketingMaterialImageUpload {

    private static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi+miauK8CqsK7KOMWqNY1+qyecmyUB9GnZ1Q3jdJ+22KPvV61LL5vyiSq8e/pvy4j25YPfT75TkmB3zC6YHY43Z45QmnxjrMtOF/TOlqxgRQpwldRpb7wCoPJT9vJuLE33lmke8gHOHvIOhHd7m/zo8kkt6KkQxT1OMWQOU+3SEKNg5uHlA/lPwfOXRf644LbhB/R75SkVY2LTMN1s8kWxfUKcCUq56Ph0vbzOiVBzUGnfy8ZQSKFiDkO98KD+ZEX4Wx6KSrz7cQKeaGFrkZhLZ63gvbTeu/IQeNnrOLWHmp9D4kdT2RrBQ6WT1MDL0ukIAgHQh34BqmplCSZqD7IwIDAQAB";
    private static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQl2CNGpuJOcaRY6n3y20BQi6TkGc/R51poNa2LjWcndkeNjNwqCL/ZMSXE16XyV8gzC3wYliGxkQFzp1vho0fMaCDboCLVfl77AhtJL0z1eguahPsOdcwbJZJTuiaEJpC/lkNZ2W/UUfsKKHkmKkoxT4CJo7ykcMFfH4ElWDmbi4z6mCxc0O//bnjVgcFGRyl7kME80SKTIC/k/laooyqqGNeYOP+3c0hyGfZ3mRpmrpf29/f+un0uGrVtIetYmyHl9I8x9v6rkzRIWxjENUsQK6G64X4MTOYAThEmTfcP3C1MbjfR9X4Ws3Z/OVmkmhiZICOkxyxKBOaMhpP4zcjAgMBAAECggEAft6jng9B7MwUR1fcCFhVe396fsxE0AtJ5fYqwfIHL7QeW67RyMKrTrVGkTD5xs53KqalhmD6wTaUJwgNX8jxyrhPjcFHM/hd3w6n7WJ8JawEJT7l0Tc4+D4DhqEU/qf8e6TiGzH5g8z3Nt9b4IMt2Btn5Lz5EvavLIYUy8rjfiMJszNusou1blzZsEufjSHBBWnLFYzu5IdiY+btSyp1lX4Z3jUofhh0XZL2GivH2eJ4WXy2i78ZOHh5BqRjjyzs+eH8qMWPFo7OCZNIzbdsBipONsFyOAOJVFsWDPUtEk7mFSrD+3nY430unHLjeIZkksfXQRf4kt/fqTROw4onYQKBgQD6tub79twq8jew0AUHwvo7XpC1s9+LN1ZDw3MezKVWyq6Bx8JNsXCibx5h1wZLi6aGdnII8nUYtd1tvN9b6oi5NhXRft8usZAUuHGRiF0rCPLXL/wcahLKmHON9487UCrEXuyHjmX0CC7A5+0W5nnWwpuOQCnEMqHY/b37MYP70wKBgQDU/SM8aOIFEUvHpn6g725rXtCDxVwCvA+yYgxpBTOlyl+aGyGInwxKIo06VtyUa/Sp5yITjTJYwlq2Z+OGBe9Pgqh2cfhSk3hLc2tbw1enWnADCwaNVlye9ZIHoTimoFZBYRlqy0ybNqTKHGGxE7urXRsU0FcIB67SK8FF52xVcQKBgQDiXG8SgSDpuYWkozxXdKf/IHNhSsUDafP9/KKc5UJGqXqDfHsnMJS0Y8U3qy9o1+6DKr/s6hPlOpZwtP2pfIjzSCzM2FLjUrf2rU0Ei+0qpMq0lQN4GCFdP+XdAO4WLFxgrh+6iEvu19B2pS//5BmPWGegOLg9B0Xvp7F28Y7rtwKBgF/gF0VxPRTk5UTZGLVfMkhY5On8JGACwdodstJvigE+aOyY++5hEgopJYO2aBLTyc3Vgoxkid5Ulrr3Zv8EmuYivaybvxmE0qi8Kv6in0lxN2zXQLrMvmK7zmFq3HJ9SHaju+pL248e+O0V+4/XfyozfiZPZm3x72siUR0jgKuxAoGBAMBZj3jDI2KpOJ9MoPOIPk09K1vDEmG9PN84C3mtr3TzUgDGWUVwGsU2Nel3HOH0kpdxRfIoLCzWxspdcEUzyGZWiC89A8jSuDXjDGqSQbOF9S1a/b26EYm8pJueqKf/R+IcX+VBUfqGhaF0o8FGB5EmjgqUaHQ9/H9f35P968l/";


    public static void main(String[] args) throws AlipayApiException {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi-sandbox.dl.alipaydev.com/gateway.do");
        alipayConfig.setAppId("9021000129607956");
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        alipayConfig.setCharset("UTF-8");
        alipayConfig.setSignType("RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
        // 这是一个1x1像素的图片流
        //String imageBase64 = "iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAEUlEQVR42mP4TyRgGFVIX4UAI/uOgGWVNeQAAAAASUVORK5CYII=";
        // 下列FileItem中也可用直接读取本地文件的方式来获取文件
        FileItem imageContent = new FileItem("D:\\AOX\\3335.png");
        AlipayMarketingMaterialImageUploadRequest request = new AlipayMarketingMaterialImageUploadRequest();
        //FileItem fileContent = new FileItem("fileContent.jpg", Base64.getDecoder().decode(imageBase64));
        request.setFileContent(imageContent);
        request.setFileKey("PROMO_BRAND_LOGO");
        request.setMerchantAccessMode("SELF_MODE");
        AlipayMarketingMaterialImageUploadResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            // System.out.println(diagnosisUrl);
        }
    }
}
