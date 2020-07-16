package assembly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pmatusiak
 */
class PLCTest {

    @Test
    void modeChange(){
        PLC runModePLC = new PLC(Mode.RUN);
        PLC programModePLC = new PLC(Mode.PROGRAM);

        runModePLC.switchMode();
        programModePLC.switchMode();

        Assertions.assertAll("PLC mode assertions",
                () -> Assertions.assertEquals(runModePLC.getMode(), Mode.PROGRAM),
                () -> Assertions.assertEquals(programModePLC.getMode(), Mode.RUN));
    }
}