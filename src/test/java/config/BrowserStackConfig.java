package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "file:~/${env}.properties",
        "classpath:android.properties"
})

public interface BrowserStackConfig extends Config {

    String userName();
    String accessKey();
    String url();
    String app();
    String deviceName();
    String platformVersion();
    String projectName();
    String buildName();
    String name();
}
