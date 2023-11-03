package lotto.model;

import lotto.util.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameMoneyDataTest {
    MoneyConverter moneyConverter;
    @Test
    void invalidPatternCheck1() {
        assertThrows(IllegalArgumentException.class, () -> {
            moneyConverter = new MoneyConverter("1001");
        });
    }
    @Test
    void invalidPatternCheck2() {
        assertThrows(IllegalArgumentException.class, () -> {
            moneyConverter = new MoneyConverter("100");
        });
    }
    @Test
    void invalidPatternCheck3() {
        assertThrows(IllegalArgumentException.class, () -> {
            moneyConverter = new MoneyConverter("0000");
        });
    }
    @Test
    void invalidPatternCheck4() {
        assertThrows(IllegalArgumentException.class, () -> {
            moneyConverter = new MoneyConverter("a00b");
        });
    }
    @Test
    void validPatternCheck() {
        moneyConverter = new MoneyConverter("1000");
        assertEquals(1, moneyConverter.getChance());
    }

    @Test
    public void setMoneyLoopTest() {
        Status status = Status.FAIL;
        int attempt = 0;

        while (status == Status.FAIL) {
            try {
                moneyConverter = new MoneyConverter("fail");
                status = Status.SUCCESS;
            }catch (IllegalArgumentException ignored){ }
            finally {
                attempt++;
            }
            if(attempt==3){
                break;
            }
        }
        assertEquals(attempt, 3);
    }
}