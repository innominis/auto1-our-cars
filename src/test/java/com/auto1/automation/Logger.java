package com.auto1.automation;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static final String DEFAULT_LOGGER_NAME = "com.auto1.automation";

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DEFAULT_LOGGER_NAME);

    public static void info(String msg) {
        LOGGER.info(msg);
    }

    public static void info(String msg, Throwable error) {
        LOGGER.info(msg, error);
    }

    public static void info(Object message) {
        LOGGER.info(message);
    }

    public static void debug(String msg) {
        LOGGER.debug(msg);
    }

    public static void debug(Object message) {
        LOGGER.debug(message);
    }

    public static void debug(String msg, Throwable error) {
        LOGGER.debug(msg, error);
    }

    public static void warn(String msg) {
        LOGGER.warn(msg);
    }

    public static void fatal(String msg) {
        LOGGER.fatal(msg);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
    }

    public static void trace(String msg) {
        LOGGER.trace(msg);
    }
}