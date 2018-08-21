package mgr.datarepo.uplink;

import mgr.datarepo.uplink.entity.Uplink;
import mgr.datarepo.uplink.repository.UplinkRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UplinkRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UplinkRepository uplinkRepository;

    @Test
    public void findByDevEUI_returnsListOfUplinkModel(){

        Uplink u = TestObjects.Uplink();
        entityManager.persist(u);
        entityManager.flush();

        Uplink found = uplinkRepository.findAllByDevEUI(u.getDevEUI()).get(0);

        Assert.assertEquals(found.getDevEUI(), u.getDevEUI());
    }
}
