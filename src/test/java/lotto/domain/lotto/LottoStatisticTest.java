package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.amount.PurchaseAmount;
import lotto.domain.amount.TotalAmount;
import lotto.dto.LottoStatisticResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticTest {

    private LottoStatistic lottoStatistic;
    private Lottos lottos;
    private WinningLotto winningLotto;
    private LottoStatisticResponse response;

    @BeforeEach
    void setUp() {
        lottoStatistic = LottoStatistic.initial();

        lottos = Lottos.from(
            List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), Lotto.from(List.of(1, 2, 3, 4, 5, 7))));
        winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 9, 10), BonusNumber.from(7));

        lottoStatistic.calculateWinningStatistics(lottos, winningLotto);
        lottoStatistic.calculateEarningRate(PurchaseAmount.from(2000));
        response = lottoStatistic.createStatisticResponse();
    }

    @DisplayName("당첨 통계 계산을 확인한다.")
    @Test
    void calculateWinningStatistics() {
        Map<LottoPrize, Integer> winningCount = response.getWinningCount();

        assertThat(1).isEqualTo(winningCount.get(LottoPrize.FOURTH));
        assertThat(1).isEqualTo(winningCount.get(LottoPrize.SECOND));
    }

    @DisplayName("수익률 계산을 확인한다.")
    @Test
    void calculateEarningRate() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(2000);
        TotalAmount totalAmount = TotalAmount.from(
            LottoPrize.SECOND.prizeAmount() + LottoPrize.FOURTH.prizeAmount());

        double expectedEarningRate = totalAmount.dividedBy(purchaseAmount) * 100;
        assertThat(expectedEarningRate).isEqualTo(response.getEarningRate());
    }
}
