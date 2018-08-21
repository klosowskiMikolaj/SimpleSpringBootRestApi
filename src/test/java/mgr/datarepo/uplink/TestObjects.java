package mgr.datarepo.uplink;

import mgr.datarepo.uplink.entity.*;


import java.util.ArrayList;
import java.util.Arrays;

public class TestObjects {

    public static Uplink Uplink() {
        return Uplink.builder()
                .devEUI("3930a2357c378422")
                .txInfo(TestObjects.TxInfo())
                .rxInfo(Arrays.asList(TestObjects.Rxinfo()))
                .applicationID("a")
                .applicationName("test")
                .deviceName("abp")
                .data("RHVtbXkgU2Vuc29yIFZhbHVlIGlzIDIuMQ==")
                .build();
    }

    public static RxInfo Rxinfo() {
        return RxInfo.builder()
                .altitude(0)
                .latitude(0)
                .longitude(0)
                .loRaSNR(3)
                .rssi(-2)
                .mac("a")
                .name("test")
                .build();

    }

    public static TxInfo TxInfo() {
        return TxInfo.builder()
                .adr(true)
                .frequency(868000000)
                .codeRate("4/5")
                .dataRate(TestObjects.DataRate())
                .build();
    }

    public static DataRate DataRate(){
        return DataRate.builder()
                .bandwidth(125)
                .spreadFactor(12)
                .modulation("LORA")
                .build();
    }

}
