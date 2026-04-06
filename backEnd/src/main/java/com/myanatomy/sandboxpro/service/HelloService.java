package com.myanatomy.sandboxpro.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HelloService {

    private final int NODE_COUNT = 3;
    private final int CACHE_SIZE = 3;

    private List<LinkedHashMap<String, String>> nodes;

    public HelloService() {
        nodes = new ArrayList<>();

        for (int i = 0; i < NODE_COUNT; i++) {
            nodes.add(new LinkedHashMap<String, String>(CACHE_SIZE, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                    return size() > CACHE_SIZE;
                }
            });
        }
    }

    // Hash function to decide which node
    private int getNodeIndex(String key) {
        return Math.abs(key.hashCode()) % NODE_COUNT;
    }

    // PUT operation
    public String put(String key, String value) {
        int index = getNodeIndex(key);
        nodes.get(index).put(key, value);
        return "Stored in Node " + index;
    }

    // GET operation
    public String get(String key) {
        int index = getNodeIndex(key);
        String value = nodes.get(index).get(key);

        if (value == null) {
            return "MISS ❌";
        }
        return "HIT ✅ (Node " + index + ") → " + value;
    }

    // GET ALL NODES (FIXED METHOD ✅)
    public List<Map<String, String>> getAll() {
        List<Map<String, String>> result = new ArrayList<>();

        for (LinkedHashMap<String, String> node : nodes) {
            result.add(node);
        }

        return result;
    }
}