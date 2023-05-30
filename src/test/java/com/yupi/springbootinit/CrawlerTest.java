package com.yupi.springbootinit;
import java.util.ArrayList;
import java.util.Date;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yupi.springbootinit.model.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
 class CrawlerTest {
    @Test
    void  testPost (){
   String json = "{\n" +
           "  \"sortField\": \"createTime\",\n" +
           "  \"sortOrder\": \"descend\",\n" +
           "  \"reviewStatus\": 1,\n" +
           "  \"current\": 1\n" +
           "}";
    String Url = "https://www.code-nav.cn/api/post/list/page/vo";
    String result2 = HttpRequest.post(Url)
                .body(json)
                .execute().body();
        System.out.println(result2);


        Map<String,Object> map = JSONUtil.toBean(result2, Map.class);
       JSONObject data=(JSONObject) map.get("data");
        JSONArray records=(JSONArray) data.get("records");
        List<Post> postList = new ArrayList<>();
        for(Object record : records){
            JSONObject tempRecords = (JSONObject) record;
            Post post = new Post();

            post.setTitle(tempRecords.getStr("title"));
            post.setContent(tempRecords.getStr("content"));
            JSONArray tags = (JSONArray)  tempRecords.get("tags");
            List<String> tagList = tags.toList(String.class);
            post.setTags(JSONUtil.toJsonStr(tagList));
            post.setUserId(1L);
            post.setCreateTime(new Date());
            post.setUpdateTime(new Date());
            post.setIsDelete(0);
            postList.add(post);



        }
        System.out.println(map);

    }
}
