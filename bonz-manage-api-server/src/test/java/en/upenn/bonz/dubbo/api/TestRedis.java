package en.upenn.bonz.dubbo.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSave() {

        for (int i = 0; i < 100; i++) {
            this.redisTemplate.opsForValue().set("key_" + i, "value_" + i);
        }

        Set<String> keys = this.redisTemplate.keys("key_*");

        for (String key : keys) {
            String value = this.redisTemplate.opsForValue().get(key);
            System.out.println(value);

//            this.redisTemplate.delete(key);
        }
    }
}