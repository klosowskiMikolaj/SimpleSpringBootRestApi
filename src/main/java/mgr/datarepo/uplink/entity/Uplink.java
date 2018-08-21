package mgr.datarepo.uplink.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Base64;
import java.util.List;

@Entity
@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Uplink {

    public String applicationID;
    public String applicationName;
    public String deviceName;
    public String devEUI;
    @ElementCollection
    public List<RxInfo> rxInfo;
    @Embedded
    public TxInfo txInfo = new TxInfo();
    public int fCnt;
    public int fPort;
    public String data;
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    public void setData(String data) {
        this.data = decodeBase64(data);
    }

    private String decodeBase64(String encoded) {
        byte[] decoded = Base64.getMimeDecoder().decode(encoded);
        return new String(decoded);
    }
}
