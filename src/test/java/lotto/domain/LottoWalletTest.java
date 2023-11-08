package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LottoWalletTest {

    private LottoWallet lottoWallet;

    @BeforeEach
    void setUp() {
        lottoWallet = new LottoWallet(10000);  // 예시로 10,000원을 지불했다고 가정
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void testCalculateProfitRate() {
        lottoWallet.addLottoResult(LottoResult.THREE);
        lottoWallet.addLottoResult(LottoResult.FOUR);

        // 상금: 5,000원 + 50,000원 = 55,000원, 투입금액: 10,000원
        // 수익률: (55,000 / 10,000) * 100 = 550%
        assertEquals(550.0, lottoWallet.calculateProfitRate());
    }

    @DisplayName("0원으로 수익률 계산 시 예외 발생 테스트")
    @Test
    void testCalculateProfitRateWithZeroPaidAmount() {
        LottoWallet emptyWallet = new LottoWallet(0);

        assertThrows(ArithmeticException.class, emptyWallet::calculateProfitRate);
    }
}