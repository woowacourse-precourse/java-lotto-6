package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WinnerRevenueTest {

    @Test()
    void 수익률을_계산하기_전에_총_수익이_정상적으로_나오는지_검증() {
        List<Long> userCorrectWinningsCount = new ArrayList<>();
        List<Boolean> userCorrectBonuses = new ArrayList<>();

        userCorrectWinningsCount.add(4L);
        userCorrectBonuses.add(false);

        userCorrectWinningsCount.add(5L);
        userCorrectBonuses.add(true);

        userCorrectWinningsCount.add(4L);
        userCorrectBonuses.add(false);

        int winningFourTierPrice = WinningStatistics.FOUR.getWinningPrice();
        int winningThirdTierPrice = WinningStatistics.SECOND.getWinningPrice();
        int totalRevenue = winningFourTierPrice * 2 + winningThirdTierPrice;

        WinnerRevenue winnerRevenue = new WinnerRevenue(userCorrectWinningsCount, userCorrectBonuses);
        Assertions.assertThat(winnerRevenue.getTotalRevenue()).isEqualTo(totalRevenue);
    }

    @DisplayName("유저의 투입 금액이 8000원 이고, 5등이 당첨됐을 때 수익률이 62.5%가 나오는ㄴ지 검증한다.")
    @Test
    void 수익률을_계산하는_기능_검증() {
        List<Long> userCorrectWinningsCount = new ArrayList<>();
        List<Boolean> userCorrectBonuses = new ArrayList<>();

        userCorrectWinningsCount.add(3L);
        userCorrectBonuses.add(false);

        WinnerRevenue winnerRevenue = new WinnerRevenue(userCorrectWinningsCount, userCorrectBonuses);
        double rateOfRevenue = winnerRevenue.calculateRateOfRevenue(8000);
        Assertions.assertThat(rateOfRevenue).isEqualTo(62.5);
    }
}