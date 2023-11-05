package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.service.ResultService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultServiceTest {
    @DisplayName("등수별 당첨 로또 개수 도출 확인")
    @Test
    void 로또_등수별_집계_확인() {
        String amountInput = "3000";
        List<Lotto> userLotteries = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                        new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 2등
                )
        );
        ResultService resultService = setService(userLotteries, amountInput);

        assertThat(resultService.getCountOf(Rank.SIX_MATCH)).isEqualTo(2);
        assertThat(resultService.getCountOf(Rank.FIVE_AND_BONUS_MATCH)).isEqualTo(1);
    }

    @DisplayName("수익률 계산 확인")
    @Test
    void 수익률_계산_확인() {
        String amountInput = "3000";
        List<Lotto> userLotteries = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                        new Lotto(List.of(1, 2, 3, 4, 5, 7))  // 2등
                )
        );
        ResultService resultService = setService(userLotteries, amountInput);
        double profitRounded = Math.round(resultService.getProfitRatio() * 10) / 10.0;
        assertThat(profitRounded).isEqualTo(134_333_333.3);
    }

    private ResultService setService(List<Lotto> userLotteries, String amountInput) {
        String firstRankNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";

        ResultService resultService = new ResultService();
        resultService.setAmount(amountInput);
        resultService.setFirstRankNumbers(firstRankNumbersInput);
        resultService.setBonusNumber(bonusNumberInput);
        for (Lotto lotto : userLotteries) {
            resultService.deterMineScore(lotto);
        }

        return resultService;
    }
}
