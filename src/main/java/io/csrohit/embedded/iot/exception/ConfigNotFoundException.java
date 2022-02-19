package io.csrohit.embedded.iot.exception;

/**
 * Custom exception thrown when required config is not defined in the properties files
 */
public class ConfigNotFoundException extends Exception{
    public ConfigNotFoundException() {
    }

    public ConfigNotFoundException(String message) {
        super(message);
    }

    public ConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    public ConfigNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
