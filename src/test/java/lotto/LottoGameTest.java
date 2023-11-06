package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {


    @Test
    @DisplayName("수익률 계산 테스트. 소수점 둘째자리에서 반올림된다.")
    void testCalculateReturn() {
        LottoGame lottoGame = new LottoGame();

        double rateReturn = lottoGame.calculateReturn(Prize.Fifth.getMoney(), 1000);

        Assertions.assertEquals(500.0, rateReturn);
    }

    @Test
    @DisplayName("수익률 계산 테스트. 소수점 둘째자리에서 반올림된다.")
    void testCalculateReturn2() {
        LottoGame lottoGame = new LottoGame();

        double rateReturn = lottoGame.calculateReturn(Prize.Fifth.getMoney(), 8000);

        Assertions.assertEquals(62.5, rateReturn);
    }

    @Test
    @DisplayName("수익률 계산 테스트. 소수점 둘째자리에서 반올림된다.")
    void testCalculateReturn3() {
        LottoGame lottoGame = new LottoGame();

        double rateReturn = lottoGame.calculateReturn(Prize.Fifth.getMoney(), 9000);

        Assertions.assertEquals(55.6, rateReturn);
    }
}