package com.imdb.service.impl;

import com.imdb.MicroImdbApplication;
import com.imdb.exception.OutOfKevinBaconNetworkException;
import com.imdb.exception.ServiceNotReadyException;
import com.imdb.exception.TitleNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.imdb.util.InMemoryCheckValues.IS_TITLE_MAP_READY;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;

/**
 * @developer -- ilkercolakoglu
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = MicroImdbApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yaml")
public class NameBasicServiceTest {

    @Autowired
    NameBasicService nameBasicService;

    @Before
    public void setup() throws InterruptedException {
        Thread.sleep(10000); // for preparing titleMap
    }

    @Test
    public void findDegreesOfKevinBacon() {
        try {
            IS_TITLE_MAP_READY = true;
            int bacon = nameBasicService.findDegreesOfKevinBacon("Rishaab Chauhaan");
            assertEquals(5, bacon);
        } catch (ServiceNotReadyException e) {
            fail("should be thrown ServiceNotReadyException");
        } catch (TitleNotFoundException e) {
            fail("should be thrown TitleNotFoundException");
        } catch (OutOfKevinBaconNetworkException e) {
            fail("should be thrown OutOfKevinBaconNetworkException");
        }
    }

    @Test(expected = ServiceNotReadyException.class)
    public void should_get_service_not_ready_exception()
            throws ServiceNotReadyException, OutOfKevinBaconNetworkException, TitleNotFoundException {
        IS_TITLE_MAP_READY = false;
        nameBasicService.findDegreesOfKevinBacon("Ahmed Hmaied");
    }

    @Test(expected = OutOfKevinBaconNetworkException.class)
    public void should_get_out_of_kevin_bacon_exception()
            throws ServiceNotReadyException, OutOfKevinBaconNetworkException, TitleNotFoundException {
        IS_TITLE_MAP_READY = true;
        nameBasicService.findDegreesOfKevinBacon("Ahmed Hmaied");
    }

    @Test(expected = TitleNotFoundException.class)
    public void should_title_not_found_exception()
            throws ServiceNotReadyException, OutOfKevinBaconNetworkException, TitleNotFoundException {
        IS_TITLE_MAP_READY = true;
        nameBasicService.findDegreesOfKevinBacon("Frank Martinez");
    }

}
