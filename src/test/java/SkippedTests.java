import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class SkippedTests {

    @Test
    @Disabled
    void someTest() {
        fail();
    }

    @Test
    @Disabled("Some reason")
        void someTest1() {
            fail();
        }
}
