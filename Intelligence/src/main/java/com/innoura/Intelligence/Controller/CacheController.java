package com.innoura.Intelligence.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.Map;

@RestController
@RequestMapping("/")
@Slf4j
public class CacheController {

    private final Jedis jedis;

    public CacheController() {
        // Connect to the Redis service running in OpenShift
        this.jedis = new Jedis("redis", 6379); // "redis" is the Kubernetes service name
    }

    @PostMapping("/set")
    public ResponseEntity<String> set(@RequestBody Map<String, String> body) {
        log.info("Received headers {}",body);
        String key = body.get("key");
        String value = body.get("value");
        jedis.set(key, value);
        return ResponseEntity.ok("Set OK");
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        log.info("get key {}",key);
        String value = jedis.get(key);
        if (value == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/delete/{key}")
    public ResponseEntity<String> delete(@PathVariable String key) {
        log.info("deleted key {}",key);
        Long result = jedis.del(key);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
        }
        return ResponseEntity.ok("Deleted key: " + key);
    }

}
