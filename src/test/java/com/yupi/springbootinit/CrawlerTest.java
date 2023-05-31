package com.yupi.springbootinit;

import com.yupi.springbootinit.service.PostService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;


@SpringBootTest
class CrawlerTest {


    @Resource
    private PostService postService;


    @Test
    void testFetchPic() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://cn.bing.com/images/search?q=%E5%BC%A0%E5%85%83%E8%8B%B1&qs=n&form=QBIR&sp=-1&lq=0&pq=zhangyuanying&sc=10-13&cvid=F5A64D22D9134A24BF63104E36269BA6&ghsh=0&ghacc=0&first=1").get();
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {

        }

    }



}
