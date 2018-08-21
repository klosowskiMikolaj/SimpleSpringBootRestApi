package mgr.datarepo.uplink.service;

import mgr.datarepo.uplink.entity.Uplink;

import java.util.List;
import java.util.Optional;

public interface UplinkService {

    List<Uplink> getAll();

    Optional<Uplink> getById(Long id);

    List<Uplink> getByIdDevEUI(String eui);

    Uplink save(Uplink uplink);

    void delete(Long id);
}
