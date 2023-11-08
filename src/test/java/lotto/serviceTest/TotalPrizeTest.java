package lotto.serviceTest;

import lotto.service.TotalPrize;

import lotto.utils.LottoRank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalPrizeTest {
    private TotalPrize totalPrize;

    @BeforeEach
    void generateTotalPrize() {
        totalPrize = new TotalPrize();
    }

    @DisplayName("로또 순위를 증가시키고, 그 횟수를 반환해야 한다.")
    @Test
    void 로또_순위_카운트_테스트() {
        totalPrize.increasePrize(LottoRank.FIFTH);
        totalPrize.increasePrize(LottoRank.FIFTH);
        totalPrize.increasePrize(LottoRank.FIFTH);
        assertThat(totalPrize.getPrizeCount(LottoRank.FIFTH)).isEqualTo(3);

        totalPrize.increasePrize(LottoRank.FIRST);
        assertThat(totalPrize.getPrizeCount(LottoRank.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또 당첨 금액을 정확히 출력해야 한다.")
    @Test
    void 로또_상금_합계_테스트() {
        int times = 5;
        long prize = times * LottoRank.THIRD.prize();
        for (int i = 0; i < times; i++) {
            totalPrize.increasePrize(LottoRank.THIRD);
        }
        assertThat(totalPrize.sumTotalPrizeAmount()).isEqualTo(prize);
    }
}
