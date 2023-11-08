package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest extends NsTest {
    public static Exception exception = new Exception();

    @Test
    void 범위내숫자확인(){
        assertTrue(exception.checkInputInRange("5"));
        assertFalse(exception.checkInputInRange("46"));
        assertFalse(exception.checkInputInRange("-1"));
        assertFalse(exception.checkInputInRange("0"));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
