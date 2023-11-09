package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Constants.NumberOfLottoCorrect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningStatisticTest {

    @Test
    void 당첨통계_만드는_기능() {
        // given
        WinningStatistic winningStatistic = WinningStatistic.newInstance();
        // when

        // then
        assertThat(winningStatistic).isInstanceOf(WinningStatistic.class);
    }

    @Test
    void 총_당첨금액을_구하는_기능() {
        // given
        WinningStatistic winningStatistic = WinningStatistic.newInstance();

        // when
        winningStatistic.increaseCount(NumberOfLottoCorrect.FIVE_MATCHES);
        winningStatistic.increaseCount(NumberOfLottoCorrect.FOUR_MATCHES);
        // then
        assertThat(winningStatistic.getTotalWinningAmount()).isEqualTo(1550000);
    }

    @Test
    void 당첨통계_메세지_기능() {
        // given
        WinningStatistic winningStatistic = WinningStatistic.newInstance();
        String message =
            "당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 1개\n"
                + "5개 일치 (1,500,000원) - 1개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";
        // when
        winningStatistic.increaseCount(NumberOfLottoCorrect.FIVE_MATCHES);
        winningStatistic.increaseCount(NumberOfLottoCorrect.FOUR_MATCHES);
        // then
        assertThat(winningStatistic.getStatisticMessage()).contains(message);
    }

}