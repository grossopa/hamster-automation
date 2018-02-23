/**
 * 
 */
package org.hamster.automation.spring.context.loader;

import org.hamster.automation.spring.LogConfig;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * sub-class of {@link AnnotationConfigContextLoader} for being able to inject initialization in the very early stage. e.g. Logback.
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class AppAnnotationConfigContextLoader extends AnnotationConfigContextLoader {

    /**
     * Constructor with Logback initialization.
     */
    public AppAnnotationConfigContextLoader() {
        super();
        LogConfig.startDefault();
    }

}
