package mgr.datarepo.uplink.repository;

import mgr.datarepo.uplink.entity.Uplink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UplinkRepository extends CrudRepository<Uplink, Long> {

    @Override
    List<Uplink> findAll();

    List<Uplink> findAllByDevEUI(String devEUI);
}
