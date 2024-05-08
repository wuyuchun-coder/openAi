package com.example.openAi.api;


import org.apache.commons.codec.StringEncoder;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;


@SpringBootTest
public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
        HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie","zsxq_access_token=36AB64C8-40FA-9DBA-9074-CE6FFF10E086_1292CBD345202CA4; tfstk=fUxITOqVRWVIiYJ1ZwHNf6qS3DjWABiqA86JnLEUeMILw8C6LkPP8LCWNC5M4WknrNd6sCAeLL-WSu9DEHkh4vjHKgj-gjo2VpvhqkVfwwxQ6OBHBuFd9eIBLOI-gjowD_qdPgLzeTFGfdCGFkULvQBOW1XzwgCdy5UOH1CR2gdRX5BVeuFLvynO6bZq1O0C9pGrr-uSFo26d1Z8c-fdJPJazoZX89_BDp16dpt1dw1f7Z22AHdweH-hSVU1qd8XNUdx_y5pltO1ueGbAIOheL6JOm2f6H9WfwYa3o91P6T9vNw82dJOwI8WOXah9eR1oOQTFmXwg1pHvFMu6pdVOMBO7mHXBaLwxZxE6ksvopSeyIha86Lfegyu0sOFNzw1ou61gAM_rzP8nrN5obGLVwBGQnksCWalJOX1gAM_rzbdIO-qCANQr; abtest_env=product; zsxqsessionid=7b24b14d7bbcb6be1a7f8ba5347e5bfe; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185441115111512%22%2C%22first_id%22%3A%2218f53233a6824b-04a4fa4fa4fa4fc-26001a51-1327104-18f53233a694c4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmNTMyMzNhNjgyNGItMDRhNGZhNGZhNGZhNGZjLTI2MDAxYTUxLTEzMjcxMDQtMThmNTMyMzNhNjk0YzQiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODU0NDExMTUxMTE1MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185441115111512%22%7D%2C%22%24device_id%22%3A%2218f53233a6824b-04a4fa4fa4fa4fc-26001a51-1327104-18f53233a694c4%22%7D");
        get.addHeader("content-type","application/json;charSet=utf8");
        CloseableHttpResponse response=httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res= EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/1522412528184852/comments");
        post.addHeader("cookie","zsxq_access_token=36AB64C8-40FA-9DBA-9074-CE6FFF10E086_1292CBD345202CA4; tfstk=fUxITOqVRWVIiYJ1ZwHNf6qS3DjWABiqA86JnLEUeMILw8C6LkPP8LCWNC5M4WknrNd6sCAeLL-WSu9DEHkh4vjHKgj-gjo2VpvhqkVfwwxQ6OBHBuFd9eIBLOI-gjowD_qdPgLzeTFGfdCGFkULvQBOW1XzwgCdy5UOH1CR2gdRX5BVeuFLvynO6bZq1O0C9pGrr-uSFo26d1Z8c-fdJPJazoZX89_BDp16dpt1dw1f7Z22AHdweH-hSVU1qd8XNUdx_y5pltO1ueGbAIOheL6JOm2f6H9WfwYa3o91P6T9vNw82dJOwI8WOXah9eR1oOQTFmXwg1pHvFMu6pdVOMBO7mHXBaLwxZxE6ksvopSeyIha86Lfegyu0sOFNzw1ou61gAM_rzP8nrN5obGLVwBGQnksCWalJOX1gAM_rzbdIO-qCANQr; abtest_env=product; zsxqsessionid=7b24b14d7bbcb6be1a7f8ba5347e5bfe; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185441115111512%22%2C%22first_id%22%3A%2218f53233a6824b-04a4fa4fa4fa4fc-26001a51-1327104-18f53233a694c4%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmNTMyMzNhNjgyNGItMDRhNGZhNGZhNGZhNGZjLTI2MDAxYTUxLTEzMjcxMDQtMThmNTMyMzNhNjk0YzQiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODU0NDExMTUxMTE1MTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185441115111512%22%7D%2C%22%24device_id%22%3A%2218f53233a6824b-04a4fa4fa4fa4fc-26001a51-1327104-18f53233a694c4%22%7D");
        post.addHeader("content-type","application/json;charSet=utf8");
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity entity=new StringEntity(paramJson, ContentType.create("text/json","UTf-8"));
        post.setEntity(entity);
        CloseableHttpResponse response=httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
            String res=EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
