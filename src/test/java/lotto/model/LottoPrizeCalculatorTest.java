package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.fixture.LottosFixture;
import lotto.fixture.WinningNumbersFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoPrizeCalculatorTest {

    private LottoPrizeCalculator lottoPrizeCalculator;

    @BeforeEach
    void init() {
        Lottos lottos = LottosFixture.createLottos(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbersFixture.createWinningNumbers("1,2,3,4,5,6", "7");
        lottoPrizeCalculator = new LottoPrizeCalculator(lottos, winningNumbers);
    }

    @Test
    void 당첨된_당첨금의_총액을_계산한다() {
        // when
        long totalPrize = lottoPrizeCalculator.calculateTotalPrize();

        // then
        assertThat(totalPrize).isEqualTo(2_000_000_000);
    }

    @Test
    void 구매한_로또의_당첨_통계를_반환한다() {
        // when
        Map<LottoPrize, Long> winningStatistics = lottoPrizeCalculator.getWinningStatistics();

        // then
        assertThat(winningStatistics).containsEntry(LottoPrize.FIRST_PRIZE, 1L);
    }
}
