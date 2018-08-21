package mgr.datarepo.uplink.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RxInfo {

    private String mac;
    private int rssi;
    private double loRaSNR;
    private String name;
    private int latitude;
    private int longitude;
    private int altitude;
}
