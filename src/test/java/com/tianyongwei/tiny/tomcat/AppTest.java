package com.tianyongwei.tiny.tomcat;

import static org.assertj.core.api.Assertions.*;

import com.tianyongwei.tiny.tomcat.ch01.App;
import org.junit.jupiter.api.*;
import org.springframework.test.web.reactive.server.WebTestClient;

public class AppTest {

    WebTestClient client;

    @BeforeEach
    void init() {
        client = WebTestClient.bindToServer().baseUrl("https://www.baidu.com").build();
    }

    @Test
    @DisplayName("baidu")
    public void testBaidu() {
        client.get().uri("/").exchange().expectStatus().isOk();
    }
}
