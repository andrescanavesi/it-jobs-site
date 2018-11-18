package uy.com.canavesi.it.jobs.site.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Andres Canavesi
 */
@WebListener
public class AppInitServletListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(AppInitServletListener.class.getName());

    /**
     *
     * @param event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOG.log(Level.INFO, "\n***** Initializing {0}", AppInitServletListener.class.getSimpleName());
        LOG.info("\n***** App initialized");
    }

    /**
     *
     * @param event
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LOG.log(Level.INFO, "\n***** Destroying {0}", AppInitServletListener.class.getSimpleName());

        LOG.info("\n***** App destroyed");
    }

}
