package com.amitph.spring.songs.actuator;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServerTimeActuator implements Endpoint<Map<String, String>> {
    private final String id = "server-time";

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public Map<String, String> invoke() {
        Map<String, String> map = new HashMap<>();
        map.put("server.date", LocalDate.now().toString());
        map.put("server.time", LocalTime.now().toString());
        return map;
    }
}