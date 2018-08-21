package mgr.datarepo.uplink.service.impl;

import mgr.datarepo.uplink.entity.Uplink;
import mgr.datarepo.uplink.repository.UplinkRepository;
import mgr.datarepo.uplink.service.UplinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UplinkServiceImpl implements UplinkService {

    private final UplinkRepository uplinkRepository;

    @Autowired
    public UplinkServiceImpl(UplinkRepository uplinkRepository) {
        this.uplinkRepository = uplinkRepository;
    }

    @Override
    public Uplink save(Uplink uplink) {
        return uplinkRepository.save(uplink);
    }

    @Override
    public List<Uplink> getAll() {
        return uplinkRepository.findAll();
    }

    @Override
    public Optional<Uplink> getById(Long id) {
        return uplinkRepository.findById(id);
    }

    @Override
    public List<Uplink> getByIdDevEUI(String eui){ return uplinkRepository.findAllByDevEUI(eui);}

    @Override
    public void delete(Long id) {
        uplinkRepository.deleteById(id);
    }
}
