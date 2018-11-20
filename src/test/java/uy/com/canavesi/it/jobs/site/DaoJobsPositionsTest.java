package uy.com.canavesi.it.jobs.site;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uy.com.canavesi.it.jobs.site.daos.DaoJobPositions;
import uy.com.canavesi.it.jobs.site.entities.JobPosition;

/**
 *
 * @author Andres Canavesi
 */
public class DaoJobsPositionsTest {

    private static final Logger LOG = Logger.getLogger(DaoJobsPositionsTest.class.getName());

    public DaoJobsPositionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void find() {

        try {
            DaoJobPositions daoJobPositions = new DaoJobPositions();
            List<JobPosition> jobPositions = daoJobPositions.find(0, 1);
            Assert.assertEquals(1, jobPositions.size());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            fail(ex.getMessage());
        }
    }
}
