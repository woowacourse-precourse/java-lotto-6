package lotto.model;

import lotto.util.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameMoneyDataTest {
    LottoGameData lottoGameData = new LottoGameData();
    @Test
    void invalidPatternCheck1() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setChance("1001");
        });
    }
    @Test
    void invalidPatternCheck2() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setChance("100");
        });
    }
    @Test
    void invalidPatternCheck3() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setChance("0000");
        });
    }
    @Test
    void invalidPatternCheck4() {
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGameData.setChance("a00b");
        });
    }
    @Test
    void validPatternCheck() {
        LottoGameData lottoGameData = new LottoGameData();
        lottoGameData.setChance("1000");
        assertEquals(1000, lottoGameData.getChance());
    }
    @Test
    public void setMoneyLoopTest() {
        Status status = Status.FAIL;
        int attempt = 0;

        while (status == Status.FAIL) {
            try {
                lottoGameData.setChance("test");
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