package com.nfa.bank;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.diagnosis.DiagnosisUtils;
import com.alipay.api.domain.*;
import com.alipay.api.request.AlipayMarketingActivityVoucherCreateRequest;
import com.alipay.api.response.AlipayMarketingActivityVoucherCreateResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class AlipayMarketingActivityVoucherCreateTest {

    private static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi+miauK8CqsK7KOMWqNY1+qyecmyUB9GnZ1Q3jdJ+22KPvV61LL5vyiSq8e/pvy4j25YPfT75TkmB3zC6YHY43Z45QmnxjrMtOF/TOlqxgRQpwldRpb7wCoPJT9vJuLE33lmke8gHOHvIOhHd7m/zo8kkt6KkQxT1OMWQOU+3SEKNg5uHlA/lPwfOXRf644LbhB/R75SkVY2LTMN1s8kWxfUKcCUq56Ph0vbzOiVBzUGnfy8ZQSKFiDkO98KD+ZEX4Wx6KSrz7cQKeaGFrkZhLZ63gvbTeu/IQeNnrOLWHmp9D4kdT2RrBQ6WT1MDL0ukIAgHQh34BqmplCSZqD7IwIDAQAB";
    private static String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCl3nyCQCOo4LHpwrxAilIgJdgwJWZ1O09N9juWSbQ3BwFClUUFvMHB472Eex8DdbfGJHB6ZjaGArsKQtsAwAO2E7yIIkxq1SGZnxZUR0+5w+95FvtsBXAo6lSSvJNm2ezE1MzoKs5dDiyBMPiSzVgUcO2wuxH2XEwR3QpG6CrNSZaGqwEJWWIWwlj4drABMcZw20DRUWPqXc/CWu06uKJRLvm/NSu3uWWiGM/eRFHllBSLT8Sh85WeZQm5Ea0Cj40RBv68lCcXXN9mHo/m0qiYqQmmQCBgTYQ9wHG7wOJiiex7rEr4inm5tC8ZvjNr6DnAq5HnUdU2Q4vacNhIDretAgMBAAECggEAVyhKmpKjakjvk9rM2skUEGpyaBIu/Wj16gx6ESWXedbHdbpD85jU41INMsETcdj4gTiClf6BpfdnWyP4OjOrf5BtX8dOClEF/9gVfqGeJgnsGt/Vq1RMNGO1nwlSFxhqDp+XMGPV3hXlktkttM4L+2m/rD8QWDj1i+lvTgUPAKFSrDBJMCVBpZt4dxec1cnVmXdfJ3KOJB3JcaJckOYjH7BUaayNqCaRG0Cp2mcuQc+iPJ4MSyqvW3UQDsVvR6fjGDVuyO24YaspphVPGtMv5XO589+hwZwwE79g6N+nsoL/ioaFI21pkD/1u2pF8XsLIR/NRgu3TcuNBIbZaxq3oQKBgQDWIJOwMLi7CTl6OSoLayoQ9tr2acvZNJXcbAu1IS7ix/tHyySW9MZ3h6ZVp3wcCd2O5YILyTwsm2ICtVJ69OKWbT3Nr0Gf4LTv17GM75lNTEBdRlCcSPqpoXpICo4/3075B4BdEpBdnUlB6CofqIZOJDAbqLA1p/40EoqRTF9eRQKBgQDGTg7FgKyXxvyEqNVrTDbb6Ewvj+Hbzv1lVvrdlywvdiVD5wTCQGTM1Kb/MqnYd3fW4CotfV6I0fmVIvFwzU/e+iI97qdn3pNVjBHRp+j0OwnrFRZNG8MXvz1Vf4FxxHysY7wgX+sC/pbQ8xqsDiFO39k1GGvdy7Kuez/7bPneSQKBgBQIGijqde2xcDoZ7PACh33syhExVousWrSzOukoAI3grYZK39JrdcGq5AmxUHADEEIVAHR/z+xQYPvl4KB2FliCQbzjP11olSS25fpMU+giUQco09O7FBAYdisVKbeZ+XZcmEqcuPq5AyhyQraRencG9aUww8NRQvu2HFZ5cZaNAoGAK3RFZmAI8gVnpkY85hNAXjXsI+v6iSk1e7RwqogK5aeVCOkhsNNdg0kCAx/9+fJL72kVtPwo8ABbGaQbliVXYDwdrsaSJn+ud2uHKBMMSCB7zujDB0iTGqwMa6TSH7T3wOrl+Y4rOG/Daqwq5xL9l4QT27+rO2H8mKFnZtf9dQkCgYBG1m8iZlLypOWQRpBX4c1xC7Ji92B0Ria9MmmOupauZhX1jfeEeIk9+DTCnOHI6Xkrqt+M8vRdzW8lXFZi5f8I6BimeF/alGfDKQZb/3JRvAcrDQrpLIeQS7srgLhvdFCl1RQ0/38t9/Q7AvqPEixj4jHfTzGG+5xBXv++a/gOKw==";
    public static void main(String[] args) throws AlipayApiException, ParseException {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi-sandbox.dl.alipaydev.com/gateway.do");
        alipayConfig.setAppId("2021004128660369");
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        alipayConfig.setCharset("UTF-8");
        alipayConfig.setSignType("RSA2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);
        AlipayMarketingActivityVoucherCreateRequest request = new AlipayMarketingActivityVoucherCreateRequest();
        AlipayMarketingActivityVoucherCreateModel model = new AlipayMarketingActivityVoucherCreateModel();
        model.setOutBizNo("20213asd4h12e3412321ddas2021");
        model.setMerchantAccessMode("SELF_MODE");
        ActivityBaseInfo activityBaseInfo = new ActivityBaseInfo();
        activityBaseInfo.setActivityName("满10减1活动");
        model.setActivityBaseInfo(activityBaseInfo);
        VoucherSendModeInfo voucherSendModeInfo = new VoucherSendModeInfo();
        voucherSendModeInfo.setVoucherSendMode("DIRECT_SEND_MODE");
        VoucherSendRuleInfo voucherSendRuleInfo = new VoucherSendRuleInfo();
        voucherSendRuleInfo.setQuantity(1000L);
        voucherSendRuleInfo.setPublishStartTime(sdf.parse("2023-12-12 15:00:01"));
        voucherSendRuleInfo.setPublishEndTime(sdf.parse("2023-12-31 00:00:01"));
        voucherSendModeInfo.setVoucherSendRuleInfo(voucherSendRuleInfo);
        model.setVoucherSendModeInfo(voucherSendModeInfo);
        VoucherDeductInfo voucherDeductInfo = new VoucherDeductInfo();
        voucherDeductInfo.setVoucherType("FIX_VOUCHER");
        FixVoucherInfo fixVoucherInfo = new FixVoucherInfo();
        fixVoucherInfo.setAmount("1");
        fixVoucherInfo.setFloorAmount("10");
        voucherDeductInfo.setFixVoucherInfo(fixVoucherInfo);
        model.setVoucherDeductInfo(voucherDeductInfo);
        VoucherAvailableScopeInfo voucherAvailableScopeInfo = new VoucherAvailableScopeInfo();
        VoucherAvailableAccountInfo voucherAvailableAccountInfo = new VoucherAvailableAccountInfo();
        ArrayList<String> pIds = new ArrayList<>();
        pIds.add("2088721015307293");
        voucherAvailableAccountInfo.setAvailablePids(pIds);
        voucherAvailableScopeInfo.setVoucherAvailableAccountInfo(voucherAvailableAccountInfo);
        model.setVoucherAvailableScopeInfo(voucherAvailableScopeInfo);
        VoucherUseRuleInfo voucherUseRuleInfo = new VoucherUseRuleInfo();
        VoucherUseTimeInfo voucherUseTimeInfo = new VoucherUseTimeInfo();
        voucherUseTimeInfo.setPeriodType("ABSOLUTE");
        VoucherAbsolutePeriodInfo voucherAbsolutePeriodInfo = new VoucherAbsolutePeriodInfo();
        voucherAbsolutePeriodInfo.setValidBeginTime(sdf.parse("2023-12-12 12:00:00"));
        voucherAbsolutePeriodInfo.setValidEndTime(sdf.parse("2023-12-31 12:00:00"));
        voucherUseTimeInfo.setAbsolutePeriodInfo(voucherAbsolutePeriodInfo);
        voucherUseRuleInfo.setVoucherUseTimeInfo(voucherUseTimeInfo);
        model.setVoucherUseRuleInfo(voucherUseRuleInfo);
        VoucherCustomerGuideInfo voucherCustomerGuideInfo = new VoucherCustomerGuideInfo();
        VoucherUseGuideInfo voucherUseGuideInfo = new VoucherUseGuideInfo();
        ArrayList<String> modes = new ArrayList<>();
        modes.add("SCAN_CODE");
        voucherUseGuideInfo.setUseGuideMode(modes);
        voucherCustomerGuideInfo.setVoucherUseGuideInfo(voucherUseGuideInfo);
        model.setVoucherCustomerGuideInfo(voucherCustomerGuideInfo);
        VoucherDisplayPatternInfo voucherDisplayPatternInfo = new VoucherDisplayPatternInfo();
        voucherDisplayPatternInfo.setBrandName("肯德基");
        voucherDisplayPatternInfo.setVoucherDescription("1、本券不可兑换现金，不可找零。2、每个用户最多可以领取1张。3、如果订单发生退款，优惠券无法退还。");
        model.setVoucherDisplayPatternInfo(voucherDisplayPatternInfo);
        VoucherBudgetSupplyInfo voucherBudgetSupplyInfo = new VoucherBudgetSupplyInfo();
        voucherBudgetSupplyInfo.setBudgetType("NO_CASH");
        model.setVoucherBudgetSupplyInfo(voucherBudgetSupplyInfo);
        request.setBizModel(model);
        AlipayMarketingActivityVoucherCreateResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            System.out.println(diagnosisUrl);
        }
    }
}
