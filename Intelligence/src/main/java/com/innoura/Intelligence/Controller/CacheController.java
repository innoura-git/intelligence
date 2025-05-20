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

    @PostMapping("/set/{key}")
    public ResponseEntity<String> set(@PathVariable String requestId, @RequestBody Map<String, String> body) {
        log.info("Received headers {}",body);
        jedis.hset(requestId, body);
        return ResponseEntity.ok("Set OK");
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<Map<String,String>> get(@PathVariable String requestId) {
        log.info("get key {}",requestId);
        Map<String,String> value = jedis.hgetAll(requestId);
        if (value == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/delete/{key}")
    public ResponseEntity<String> delete(@PathVariable String requestId) {
        log.info("deleted key {}",requestId);
        Long result = jedis.del(requestId);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
        }
        return ResponseEntity.ok("Deleted key: " + requestId);
    }
    @DeleteMapping("/flush")
    public ResponseEntity<String> flush()
    {
        jedis.flushDB();
        return ResponseEntity.ok("Database Cleared Successfully.");
    }


}
