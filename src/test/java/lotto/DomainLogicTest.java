package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import lotto.control.Control;
import lotto.domain.Prize;
import lotto.util.ProfitRate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainLogicTest {

    @Test
    @DisplayName("도메인 로직 테스트: 입력된 금액에 맞춰 로또가 구매되었는가?")
    void purchaseLottoInCostInput() {
        int lottoCost = 5000;
        int expectedLottoCount = lottoCost / 1000;
        int purchasedLottoCount = Control.calculateTicketCount(lottoCost);

        assertThat(purchasedLottoCount).isEqualTo(expectedLottoCount);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 6개 번호가 일치하면 1등 상금을 받는다")
    void isSixMatchesAwardFirstPrize() {
        Prize result = Prize.findMatchingPrize(6, false);
        assertEquals(Prize.SIX_MATCH, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 5개 번호와 보너스 번호가 일치하면 2등 상금을 받는다")
    void isFiveBonusMatchesAwardSecondPrize() {
        Prize result = Prize.findMatchingPrize(5, true);
        assertEquals(Prize.FIVE_BONUS_MATCH, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 5개 번호가 일치하면 3등 상금을 받는다")
    void isFiveMatchesAwardThirdPrize() {
        Prize result = Prize.findMatchingPrize(5, false);
        assertEquals(Prize.FIVE_MATCH, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 4개 번호가 일치하면 4등 상금을 받는다")
    void isFourMatchesAwardFourthPrize() {
        Prize result = Prize.findMatchingPrize(4, false);
        assertEquals(Prize.FOUR_MATCH, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 3개 번호가 일치하면 5등 상금을 받는다")
    void isThreeMatchesAwardFifthPrize() {
        Prize result = Prize.findMatchingPrize(3, false);
        assertEquals(Prize.THREE_MATCH, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 2개 번호가 일치하면 상금이 없다")
    void isTwoMatchesAwardNoPrize() {
        Prize result = Prize.findMatchingPrize(2, false);
        assertEquals(Prize.NONE, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 1개 번호만 일치하면 상금이 없다")
    void isOneMatchAwardNoPrize() {
        Prize result = Prize.findMatchingPrize(1, false);
        assertEquals(Prize.NONE, result);
    }

    @Test
    @DisplayName("도메인 로직 테스트: 당첨 내역에 따른 수익률이 옳게 계산되었는가?")
    void isReturnRateValueRightBasedOnPrize() {
        int purchasePrice = 5000;
        int totalPrize = 1500000;
        String expectedProfitRate = "30000.0";

        String profitRate = ProfitRate.calculateProfit(totalPrize, purchasePrice);

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
