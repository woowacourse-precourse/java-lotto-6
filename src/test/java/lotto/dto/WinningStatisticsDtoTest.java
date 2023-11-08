package lotto.dto;

import static lotto.domain.WinningRank.FIFTH;
import static lotto.domain.WinningRank.FOURTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

import java.util.Map;
import lotto.domain.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsDtoTest {

    @Test
    @DisplayName("당첨 정보에 따라 수익률을 계산할 수 있다")
    void getRateOfReturnPercentageTest() {
        Map<WinningRank, Integer> countOfRank = Map.of(FOURTH, 5, FIFTH, 3,
                WinningRank.NOTHING, 2);
        int lottoPrice = 1000;
        WinningStatisticsDto statisticsDto = new WinningStatisticsDto(countOfRank, lottoPrice);
        double expected = (double) (FOURTH.getPrice() * 5 + FIFTH.getPrice() * 3) / (lottoPrice * 10) * 100;

        double actual = statisticsDto.getRateOfReturnPercentage();

        assertThat(actual).isEqualTo(expected, offset(0.001));
    }
}
