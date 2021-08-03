package devlab.shoperintegrator.utils;

import devlab.shoperintegrator.server.ShoperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class EnvironmentUtils {

    private static final Logger logger = LoggerFactory.getLogger(ShoperService.class);

    private EnvironmentUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String getProperty(String key) {
        String value = System.getenv(key);
        if(StringUtils.hasText(value)) {
            return value;
        }
        logger.error("Cannot get env: {}", key);
        return null;
    }
}
