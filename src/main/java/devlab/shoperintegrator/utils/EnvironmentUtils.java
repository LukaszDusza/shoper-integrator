package devlab.shoperintegrator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class EnvironmentUtils {

    private static final Logger logger = LoggerFactory.getLogger(EnvironmentUtils.class);

    private EnvironmentUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getEnv(String key) {
        String value = System.getenv(key);
        if(StringUtils.hasText(value)) {
            return value;
        }
        logger.error("Cannot get env: {}", key);
        return null;
    }

    public static void setProperty(String key, String value) {
        System.setProperty(key, value);
        logger.info("Setting property: {}={}", key, value);
    }

    public static String getProperty(String key) {
        String value = System.getProperty(key);
        logger.info("getting property: {}={}", key, value);
        return value;
    }
}
