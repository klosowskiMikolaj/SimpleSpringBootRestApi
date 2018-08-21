package mgr.datarepo.uplink.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TxInfo {

    public int frequency;

    @Embedded
    public DataRate dataRate;
    public boolean adr;
    public String codeRate;
}
