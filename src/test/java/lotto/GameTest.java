package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void 천원단위확인(){
        assertTrue(exception.checkValidPurchase(4000));
        assertFalse(exception.checkValidPurchase(4500));
    }

    @Test
    void 보너스숫자중복확인(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertTrue(exception.checkDuplication(4,lotto));
        assertFalse(exception.checkDuplication(7,lotto));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
