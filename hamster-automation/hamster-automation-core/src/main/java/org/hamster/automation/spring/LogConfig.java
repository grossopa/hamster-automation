/**
 * 
 */
package org.hamster.automation.spring;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.hamster.automation.log.AppenderProvider;
import org.hamster.automation.log.ConsoleAppenderProvider;
import org.hamster.automation.log.DefaultEncoderProvider;
import org.hamster.automation.log.EncoderProvider;
import org.hamster.automation.log.FileAppenderProvider;
import org.hamster.automation.log.FilterProvider;
import org.hamster.automation.log.ThresholdFilterProvider;
import org.hamster.automation.spring.util.TestConsts;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.PropertyPlaceholderHelper;

import com.google.common.collect.Lists;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

/**
 * Defines log related configuration
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class LogConfig {

    public static final String ENCODER_PATTERN = "log.encoder.pattern";
    public static final String FILE_PATH = "log.file.path";
    public static final String LEVEL = "log.level";

    private Properties properties;

    private final String encoderPattern;
    private final String filePath;
    private final Level level;

    /**
     * Constructor
     * 
     * @param propertyFiles
     *            the URI path of properties files, support placeholders and values are coming from {@link System#getProperties}
     */
    public LogConfig(List<String> propertyFiles) {
        this.properties = initProperties(propertyFiles);

        this.encoderPattern = properties.getProperty(ENCODER_PATTERN, "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        this.filePath = properties.getProperty(FILE_PATH);
        this.level = Level.valueOf(properties.getProperty(LEVEL, Level.DEBUG.levelStr));
    }

    /**
     * initializes the properties from a list of properties files.
     * 
     * @param propertyFiles
     *            the URI path of properties files, support placeholders and values are coming from {@link System#getProperties}
     * @return merged properties instance
     */
    protected Properties initProperties(List<String> propertyFiles) {
        final Properties result = new Properties();

        PropertyPlaceholderHelper placeholderHelper = new PropertyPlaceholderHelper("${", "}");
        propertyFiles.forEach(p -> {
            String denormalizedResourceName = placeholderHelper.replacePlaceholders(p, System.getProperties());
            try {
                Properties temp = PropertiesLoaderUtils.loadAllProperties(denormalizedResourceName);
                temp.forEach((k, v) -> {
                    String key = (String) k;
                    String value = (String) v;
                    result.setProperty(key, placeholderHelper.replacePlaceholders(value, System.getProperties()));
                });
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });

        return result;
    }

    /**
     * starts the logger
     * 
     * @param logger
     *            the logger to be started
     */
    public void start(Logger logger) {
        Objects.requireNonNull(logger);

        LoggerContext context = logger.getLoggerContext();

        logger.setLevel(level);

        List<AppenderProvider> appenderProviders = Lists.newArrayList();
        appenderProviders.add(consoleAppenderProvider());

        if (this.filePath != null) {
            appenderProviders.add(fileAppenderProvider());
        }

        appenderProviders.forEach(p -> logger.addAppender(p.createAppender(context)));
        context.start();
    }

    /**
     * @return default EncoderProvider instance with pattern set from property file
     */
    private EncoderProvider encoderProvider() {
        return new DefaultEncoderProvider(encoderPattern);
    }

    /**
     * @return default ThresholdFilterProvider instance with level specified from property file
     */
    protected FilterProvider thresholdFilterProvider() {
        return new ThresholdFilterProvider(level);
    }

    /**
     * Default Console Appender
     * 
     * @return instance of {@link ConsoleAppenderProvider} for being injected into {@link TestConfig#logAppenderProviders}.
     */
    public ConsoleAppenderProvider consoleAppenderProvider() {
        return new ConsoleAppenderProvider(encoderProvider(), thresholdFilterProvider());
    }

    /**
     * File appender is not enabled by default, sub-classes can override this method with {@link Bean} annotation to enable it. Must log.file.path be
     * defined in properties as well.
     * 
     * @return instance of {@link FileAppenderProvider} for being injected into {@link TestConfig#logAppenderProviders}.
     */
    protected FileAppenderProvider fileAppenderProvider() {
        return new FileAppenderProvider(encoderProvider(), thresholdFilterProvider(), filePath);
    }

    /**
     * start the root logger with pre-defined properties files
     */
    public static final void startDefault() {
        Logger rootLogger = (Logger) LoggerFactory.getLogger("ROOT");
        rootLogger.getLoggerContext().reset();
        
        // filter out unnecessary library logs
        ((Logger) LoggerFactory.getLogger("org.springframework.test")).setLevel(Level.WARN);
        
        new LogConfig(Lists.newArrayList(TestConsts.PROPERTIES_CORE, TestConsts.PROPERTIES_ENVIRONMENT)).start(rootLogger);
    }
    

}
