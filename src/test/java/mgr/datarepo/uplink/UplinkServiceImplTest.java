package mgr.datarepo.uplink;

import mgr.datarepo.uplink.entity.Uplink;
import mgr.datarepo.uplink.repository.UplinkRepository;
import mgr.datarepo.uplink.service.UplinkService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UplinkServiceImplTest {

    @Autowired
    private UplinkService uplinkService;

    @MockBean
    private UplinkRepository uplinkRepository;

    @Test
    public void whenValidEUI_thenUplinkShouldBeFound() {
        Uplink uplink = TestObjects.Uplink();

        Mockito.when(uplinkRepository.findAllByDevEUI(uplink.getDevEUI()))
                .thenReturn(new ArrayList<Uplink>(){{add(uplink);}});

        Uplink found = uplinkService.getByIdDevEUI(uplink.getDevEUI()).get(0);

        Assert.assertEquals(uplink.getDevEUI(), found.getDevEUI());
    }
}
