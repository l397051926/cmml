package com.lj.cmml.common.log.converter;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.*;

import java.util.Arrays;
import java.util.List;

// Bypassing nested braces bug in Log4j2
@Plugin(name="ShortenPatternConverter", category=PatternConverter.CATEGORY)
@ConverterKeys({"shorten"})
public class ShortenPatternConverter extends LogEventPatternConverter {

    public static ShortenPatternConverter newInstance(Configuration config, String[] options) {
        if (options.length < 2) {
            LOGGER.error("Incorrect number of options on shorten: expected at least 2 received {}: {}", options.length,
                options);
            return null;
        }
        if (options[0] == null) {
            LOGGER.error("No pattern supplied on shorten");
            return null;
        }
        if (options[1] == null) {
            LOGGER.error("No length supplied on shorten");
            return null;
        }
        final PatternParser parser = PatternLayout.createPatternParser(config);
        final List<PatternFormatter> fmts = parser.parse(options[0]);
        EllipsisPosition ep = EllipsisPosition.SUFFIX;
        if (options[2] != null) {
            try {
                ep = EllipsisPosition.valueOf(options[2].toUpperCase());
            } catch (IllegalArgumentException e) {
                LOGGER.error("Unknown ellipsis position: " + options[2] + ", expect " + Arrays.asList(EllipsisPosition.values()));
            }
        }
        return new ShortenPatternConverter(fmts, AbstractAppender.parseInt(options[1], 100), ep);
    }

    private enum EllipsisPosition {
        PREFIX,
        BODY,
        SUFFIX
    }

    private final List<PatternFormatter> formatters;
    private final int expectedLength;
    private final EllipsisPosition ellipsisPosition;

    private ShortenPatternConverter(List<PatternFormatter> formatters, int expectedLength, EllipsisPosition ellipsisPosition) {
        super("Shorten", "shorten");
        this.formatters = formatters;
        this.expectedLength = expectedLength;
        this.ellipsisPosition = ellipsisPosition;
        LOGGER.trace("new ShortenPatternConverter with {}", expectedLength);
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        final StringBuilder buf = new StringBuilder();
        for (PatternFormatter formatter: formatters) {
            formatter.format(event, buf);
        }
        String s = buf.toString();
        if (buf.length() > expectedLength) {
            if (expectedLength == 0) {
                s = "";
            } else {
                String ellipsis = expectedLength > 4 ? "..." : expectedLength == 4 ? ".." : ".";
                switch (ellipsisPosition) {
                    case PREFIX:
                        s = ellipsis + s.substring(s.length() - expectedLength + ellipsis.length());
                        break;
                    case SUFFIX:
                        s = s.substring(0, expectedLength - ellipsis.length()) + ellipsis;
                        break;
                    case BODY:
                        int prefix = (expectedLength - ellipsis.length()) / 2;
                        int suffix = expectedLength - prefix - ellipsis.length();
                        s = s.substring(0, prefix) + ellipsis + s.substring(s.length() - suffix);
                        break;
                }
            }
        }
        toAppendTo.append(s);
    }

}
