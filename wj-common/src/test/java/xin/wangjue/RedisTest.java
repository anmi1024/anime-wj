package xin.wangjue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate objectRedisTemplate;

    @Test
    public void test_redis_strings() {
        stringRedisTemplate.opsForValue().set("nami","nnnnnnnami");
        Assert.assertEquals("nnnnnnnami",stringRedisTemplate.opsForValue().get("nami"));
    }
}
