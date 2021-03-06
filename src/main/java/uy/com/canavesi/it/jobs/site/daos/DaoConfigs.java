package uy.com.canavesi.it.jobs.site.daos;

import java.util.logging.Logger;

/**
 * We use environment variables, we do not store in DB so this class does not
 * extends from DaoBase.
 *
 * Go to README file to configure environment variables in Tomcat
 *
 * In Heroku you can add / edit an environment variable like this:
 *
 * heroku config:set CONFIG_1="your_value"
 *
 * @author Andres Canavesi
 */
public class DaoConfigs {

    private static final Logger LOG = Logger.getLogger(DaoConfigs.class.getName());

    /**
     * There is not public instances of this class
     */
    private DaoConfigs() {

    }

    /**
     *
     * @return
     */
    public static String getDataBaseUrl() {
        String value = System.getenv("DATABASE_URL");
        if (value == null) {
            //since this is a sensitive data we do not return a default value
            throw new IllegalStateException("DATABASE_URL environment variable not found");

        }
        return value;
    }

    /**
     *
     * @return
     */
    public static String getBaseUrl() {
        String value = System.getenv("BASE_URL");
        if (value == null) {
            value = "http://localhost:8080/it-jobs-site/";
        }
        if (!value.endsWith("/")) {
            value += "/";
        }
        return value;
    }

    /**
     *
     * @return
     */
    public static boolean isProduction() {
        String value = System.getenv("IS_PRODUCTION");
        if (value == null) {
            return false;
        }
        return Boolean.valueOf(value);
    }

    /**
     *
     * @return
     */
    public static int getPageSizeDB() {
        String value = System.getenv("PAGE_SIZE_DB");
        if (value == null) {
            return 100;
        }
        return Integer.valueOf(value);
    }

}
