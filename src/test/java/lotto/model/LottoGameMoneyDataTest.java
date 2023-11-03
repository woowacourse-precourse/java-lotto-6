package lotto.model;

import lotto.util.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameMoneyDataTest {
    LottoGameData lottoGameData = new LottoGameData();
    @Test
    void invalidPatternCheck1() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setMoney("1001");
        });
    }
    @Test
    void invalidPatternCheck2() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setMoney("100");
        });
    }
    @Test
    void invalidPatternCheck3() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setMoney("0000");
        });
    }
    @Test
    void invalidPatternCheck4() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setMoney("a00b");
        });
    }
    @Test
    void validPatternCheck() {
        LottoGameData lottoGameData = new LottoGameData();
        lottoGameData.setMoney("1000");
        assertEquals(1000, lottoGameData.getMoney());
    }
    @Test
    public void setMoneyLoopTest() {
        Status status = Status.FAIL;
        int attempt = 0;

        while (status == Status.FAIL) {
            try {
                lottoGameData.setMoney("test");
                status = Status.SUCCESS;
            }catch (IllegalArgumentException ignored){

            }
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