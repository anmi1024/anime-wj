package xin.wangjue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.wangjue.consumer.HelloConsumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerTest {

    @Test
    public void test_hi() {
        new HelloConsumer().hi();
    }
}
