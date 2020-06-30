package com.lj.cmml.common.log.converter;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.NamePatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

// Bypassing nested braces bug in Log4j2
@Plugin(name="LoggerClassPatternConverter", category=PatternConverter.CATEGORY)
@ConverterKeys({"loggerClass"})
public class LoggerClassPatternConverter extends NamePatternConverter {

    private static final LoggerClassPatternConverter INSTANCE = new LoggerClassPatternConverter(null);

    private LoggerClassPatternConverter(final String[] options) {
        super("LoggerClass", "loggerClass", options);
    }

    public static LoggerClassPatternConverter newInstance(final String[] options) {
        if (options.length > 0) {
            LOGGER.error("Incorrect number of options on loggerClass: expected 0 received {}: {}", options.length,
                options);
            return null;
        }
        return INSTANCE;
    }

    @Override
    public void format(final LogEvent event, final StringBuilder toAppendTo) {
        String logger = event.getLoggerName();
        if (logger == null) {
            abbreviate("", toAppendTo);
        } else {
            String[] path = logger.split("\\.");
            String className = path[path.length - 1];
            abbreviate(className, toAppendTo);
        }
    }

}
