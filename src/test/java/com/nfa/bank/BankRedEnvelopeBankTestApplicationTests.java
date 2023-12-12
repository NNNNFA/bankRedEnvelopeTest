package com.nfa.bank;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayUserDtbankcustChannelvoucherSendRequest;
import com.alipay.api.response.AlipayUserDtbankcustChannelvoucherSendResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankRedEnvelopeBankTestApplicationTests {

    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqqga+EjElYUxv1AX4j7Y0v4BWeumbYd15UH9aQl37psOCgIjuFQCLl46oF4eLGw5yljtk6dcWmxisK7hxD7RcvDiGJhHYsht3QOpvNUyZkYbN9cjXueBNF9qlhkQK5KnZPmLipb+DrP62cIhUuguGjDs6ZDZllV+iSNkMKzEDvI8kBwOC+Zbu0xq58izPFB4T+tEksBpjHXUrfKRIVbceZv1FdmR1oNEW0R2ONhflqN9sf6wnSISI8m6nle/aAKESItGK9IgrLPmk6WCBF3/DYTvKY9a+wC7gZFMlDfu2OwvaV7Pq3t/tLjM6rIShTlX8aD16adrcnbB6B6aKIDvwQIDAQAB";
    private String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC4+CmY+RQuC0aJ191AzZIFrFbEf7+G0cm4qGJiitk+ruMlkQxjEk4LBXh7WlQbSUxgNW6slOX36txbAunYQtXnziBr/F4Ck95ddHJB/F3TJFiDQAwcxIf+tJogMaCcmbfmHV1ZBnTkvW2TtJxMiviIlaCvgcwVAtAwokgEWTEQCragRuq85hWlpgnOAdaoFb3yqsLOc1IDtDRi3lWcWhsOyHH+YZdwSJyltGycoxT8GwDxea5qd2GajTEXQrz6uJytmrdMTkymcN5Dgcv8nHLxVLsWEnqvegfhwerfj83jPXfJvLWmqOMbLpRTp2USNGqpCDSJaJvmnod4MpnhwxdBAgMBAAECggEAFsyP5AkfkaVWJntzDB/KleRuNX5Bj06gfKBUsCzJJk7MNL8yNav17qnX9exmXY6lWV58q80Wo35Rdu5fAIcMcqwXlvfeZpbvW7mUs8l1jyb1ugfU9l7LHHwKW1mCoIrZ/gU0klqXYfJvZTtn4I9onv1Cdx+aliRooPX/xnlv8LgLsWgMVuS+Rp154Y9t7SGBcgOBQBp075juHO5RfzpWMioA0WQwRBeVxmtYVvn1Gc3tsLMkOnyontJoYjk+buYyeFLr1DouFANrG+S6NmcDdGqU7lVF2MfgWyPAsJaBhAXFLuyqTfClsEY9deUgi9cTptYpOjq6SS2GEsh8/A9GoQKBgQDbEaIHSPSVS9MP3KRV8eZwsXLVMiiZXGe3ldLgz2/7wEAsHor22/QdCyz1vpsscVNjSPmy9zs/BWFltZo0Sub7h7KuiEXS9mWvk2lnzc+xxD+6pmVS5XhNbFN0799WXlD4vB6dkjftFxf+if4+p8+OID6XgdNi2WdLPVQ6r755TQKBgQDYJuVbJtYli3XJ/kDvCsEgJFl7BzoE1kTkDf9mbVb3rVhzp8bbIrDZq1pwZGQwrauuLlYe5Hhwjx4AmjT3ukHFs/b80EP7PAHUY+pPKuUI0NwrMKsO4NVC847q7b/9/8fi/BDGzg6alwKQlgyVHQQ4UHJlz76oiylxFLHikac7xQKBgQDX2mz7nqAYh0jlRTPL13mHKuGKPk0Qp6MumnrZtquRtKHGlyW4DYxgHcXkMjZ1uQhAOQSImeCPvT512FWkFvW3e8LNBEtAjjYtpSNj+8AdWdCtmg0WfDJon0cwXraCRJamL74+5ncirvGehdu1YuY5FX53DJ37tVl5ImnfFZGptQKBgB2v0eZgAh9r9QSGGBL8riOk+mksR+qsJxAPYBmIQN6Jf1F7JJOqQxHSN/yhvST2ZVLp6Egb5vLGpT897rJrcWce3XhBfmS+DB5IjsDKymQYk3SXHZdQh9nHK8TWXH0dKS3iosc7O8Q9o0uKYDYGozK80clr6+qoGkv+pKPSj15lAoGAHRaKd4ZudmrLHjy2nDwe3MbVUl6y/iYs44yctDEdi6VwV0bwTk839h38IDmn+9PF0H4iksTYkcm6W4PxXseRR3/kG8/8tnwz6TdlXVIc46RuPOg6bFg2fhZyevqNsAAnuq7KECHO0xXJTdsEAxNjN+kxZ8QbUpgmtCLU4VIKlPo=";

    @Test
    void contextLoads() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","2021004128660369",privateKey,"json","GBK",publicKey,"RSA2");
        AlipayUserDtbankcustChannelvoucherSendRequest request = new AlipayUserDtbankcustChannelvoucherSendRequest();
        request.setBizContent("{" +
                "  \"user_id\":\"2088442941999612\"," +
                "  \"open_id\":\"\"," +
                "  \"logon_id\":\"\"," +
                "  \"phone_id\":\"13337942828\"," +
                "  \"activity_id\":\"ACT83VQZA0020212\"," +
                "  \"out_biz_no\":\"20231228141643ddadaee\"" +
                "}");


        AlipayUserDtbankcustChannelvoucherSendResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
