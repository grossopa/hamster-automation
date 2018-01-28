package org.hamster.automation.driver;

/**
 * Available web driver types
 *
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public enum DriverType {
    CHROME {
        @Override
        <T, R> R apply(DriverAction<T, R> action, T t) {
            return action.applyChrome(t);
        }
    },
    EDGE {
        @Override
        <T, R> R apply(DriverAction<T, R> action, T t) {
            return action.applyEdge(t);
        }
    },
    FIREFOX {
        @Override
        <T, R> R apply(DriverAction<T, R> action, T t) {
            return action.applyFirefox(t);
        }
    },
    IE {
        @Override
        <T, R> R apply(DriverAction<T, R> action, T t) {
            return action.applyIE(t);
        }
    },
    OPERA {
        @Override
        <T, R> R apply(DriverAction<T, R> action, T t) {
            return action.applyOpera(t);
        }
    },
    SAFARI {
        @Override
        <T, R> R apply(DriverAction<T, R> action, T t) {
            return action.applySafari(t);
        }
    };

    /**
     * for {@link DriverType} enum type to apply their own action.
     * 
     * @param action
     *            the action to be executed, only desired action will be applied based on the current driver type.
     * @param t
     *            input parameter to be passed into action
     * @return action execution result
     */
    abstract <T, R> R apply(DriverAction<T, R> action, T t);

    /**
     * action applied to driver
     * 
     * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
     * @since 1.0
     */
    public static interface DriverAction<T, R> {

        /**
         * applies the action to Chrome driver.
         * 
         * @param t
         *            input
         * @return action execution result
         */
        R applyChrome(T t);

        /**
         * applies the action to Edge driver.
         * 
         * @param t
         *            input
         * @return action execution result
         */
        R applyEdge(T t);

        /**
         * applies the action to Firefox driver.
         * 
         * @param t
         *            input
         * @return action execution result
         */
        R applyFirefox(T t);

        /**
         * applies the action to IE driver.
         * 
         * @param t
         *            input
         * @return action execution result
         */
        R applyIE(T t);

        /**
         * applies the action to Opera driver.
         * 
         * @param t
         *            input
         * @return action execution result
         */
        R applyOpera(T t);

        /**
         * applies the action to Safari driver.
         * 
         * @param t
         *            input
         * @return action execution result
         */
        R applySafari(T t);

    }
}
