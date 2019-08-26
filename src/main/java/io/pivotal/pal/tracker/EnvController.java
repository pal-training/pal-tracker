package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddress;

    public EnvController(@Value("${port:NOT SET}")String port,
                         @Value("${memory.limit:NOT SET}")String memoryLimit,
                         @Value("${cg.instance.index.limit:NOT SET}")String cfInstanceIndex,
                         @Value("${cf.instance.addr:NOT SET}")String cfInstanceAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }

    @GetMapping("/env")

    public Map<String,String> getEnv()
    {
        Map<String,String> environmentMap = new HashMap<>();
        environmentMap.put("PORT",port);
        environmentMap.put("MEMORY_LIMIT",memoryLimit);
        environmentMap.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        environmentMap.put("CF_INSTANCE_ADDR",cfInstanceAddress);

        return environmentMap;
    }
}
