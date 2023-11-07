package lotto;

import static lotto.LottoConstants.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    @DisplayName("로또 구매 가격에 맞는 개수의 로또를 구매한다.")
    @Test
    void purchaseLotteries() {
        // given
        int purchaseAmount = 5000;

        // when
        Lotteries lotteries = new Lotteries(purchaseAmount);

        // then
        assertThat(lotteries.getLotteries().size()).isEqualTo(purchaseAmount / LOTTO_TICKET_PRICE);
    }

    @DisplayName("당첨 통계의 결과의 크기가 enum WinningRanking 의 개수와 같다.")
    @Test
    void getWinningStatistics() {
        // given
        int purchaseAmount = 5000;
        Lotteries lotteries = new Lotteries(purchaseAmount);
        Lotto winningNumbers = FixtureFactory.getLotto();
        int bonusBall = 7;

        // when
        Map<WinningRanking, Integer> winningStatistics = lotteries.getWinningStatistics(winningNumbers, bonusBall);

        // then
        assertThat(winningStatistics.size()).isEqualTo(WinningRanking.values().length);
    }
}
