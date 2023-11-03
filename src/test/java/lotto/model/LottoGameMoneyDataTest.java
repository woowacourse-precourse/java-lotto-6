package lotto.model;

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
}