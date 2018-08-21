package mgr.datarepo.uplink.controller;

import mgr.datarepo.uplink.entity.Uplink;
import mgr.datarepo.uplink.service.UplinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("uplink")
public class UplinkController {

    private final UplinkService uplinkService;

    @Autowired
    public UplinkController(UplinkService uplinkService) {
        this.uplinkService = uplinkService;
    }

    @PostMapping
    public ResponseEntity<Uplink> create(@RequestBody Uplink uplink) throws URISyntaxException {
        if (uplink.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }

        Uplink result = uplinkService.save(uplink);

        return ResponseEntity.created(new URI("uplink/" + result.getId())).body(result);
    }

    @GetMapping
    public List<Uplink> readAll() {
        return uplinkService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Uplink> read(@PathVariable Long id) {
        return uplinkService.getById(id)
                .map(r -> ResponseEntity.ok().body(r))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("eui/{eui}")
    public List<Uplink> readByDevEUI(@PathVariable String eui) {
        return uplinkService.getByIdDevEUI(eui);
    }

    @PutMapping
    public ResponseEntity<Uplink> update(@RequestBody Uplink uplink) throws URISyntaxException {
        if (uplink.getId() == null) {
            return create(uplink);
        }

        Uplink result = uplinkService.save(uplink);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        uplinkService.delete(id);
    }
}
