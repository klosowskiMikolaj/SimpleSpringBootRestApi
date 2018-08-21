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
public class DataRate {

    private String modulation;
    private int bandwidth;
    private int spreadFactor;
}
