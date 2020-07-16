package assembly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pmatusiak
 */
class LineStartupTest {
//    Initialize
    private final LineStartup lineStartup = new LineStartup();

    @Test
    void mainAlgorithmAssertionsWithZeroOrGreater(){
        Assertions.assertAll("Main algorithm",
                () -> Assertions.assertEquals( 1, lineStartup.mainAlgorithm(1,1)),
                () -> Assertions.assertEquals( 3, lineStartup.mainAlgorithm(5,5)),
                () -> Assertions.assertEquals(33, lineStartup.mainAlgorithm(1100,1100)),
                () -> Assertions.assertEquals(0, lineStartup.mainAlgorithm(10,0)),
                () -> Assertions.assertEquals(0, lineStartup.mainAlgorithm(0,10)),
                () -> Assertions.assertEquals(0, lineStartup.mainAlgorithm(0,0)));
    }

    @Test
    void mainAlgorithmShouldThrowException(){
        Assertions.assertAll("Exception throw assertions",
                () -> Assertions.assertThrows(IllegalArgumentException.class,() -> lineStartup.mainAlgorithm(-1,-1)),
                () -> Assertions.assertThrows(IllegalArgumentException.class,() -> lineStartup.mainAlgorithm(-1100,-1100)));
    }
}