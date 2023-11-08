package lotto;

import static lotto.LotteryResultRenderer.calculateReturnRate;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultRendererTest {

    @DisplayName("매치된 숫자 종류 별로 집계가 되는지 테스트.")
    @Test
    void testWinnerCount() {
        List<List<Integer>> userNumbers = new ArrayList<>(List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(1, 2, 3, 10, 11, 22),
            List.of(1, 2, 3, 10, 30, 22),
            List.of(1, 2, 30, 10, 11, 22)
        ));

        List<Integer> winnerNumbers = List.of(1, 2, 3, 10, 11, 22);
        int bonusNumber = 30;

        WinnerStatsData result = LotteryResultRenderer.getLottoResult(userNumbers, winnerNumbers, bonusNumber);

        assertThat(result.getMatch5NumbersWithBonus()).isEqualTo(2);
        assertThat(result.getMatch6Numbers()).isEqualTo(1);
        assertThat(result.getMatch3Numbers()).isEqualTo(1);

    }


    @DisplayName("수익률 500% 검증 테스트.")
    @Test
    void testReturnRate() {
        List<List<Integer>> userNumbers = new ArrayList<>(List.of(
            List.of(1, 2, 3, 4, 5, 6)
        ));

        List<Integer> winnerNumbers = List.of(1, 2, 3, 10, 11, 22);
        int bonusNumber = 30;

        WinnerStatsData result = LotteryResultRenderer.getLottoResult(userNumbers, winnerNumbers, bonusNumber);

        double returnRate = calculateReturnRate(result, userNumbers.size() * 1000);
        assertThat(returnRate).isEqualTo(500.00);
    }

    @DisplayName("수익률 0% 검증 테스트.")
    @Test
    void testReturnRateZero() {
        List<List<Integer>> userNumbers = new ArrayList<>(List.of(
            List.of(1, 2, 3, 4, 5, 6)
        ));

        List<Integer> winnerNumbers = List.of(11, 12, 13, 14, 15, 16);
        int bonusNumber = 30;

        WinnerStatsData result = LotteryResultRenderer.getLottoResult(userNumbers, winnerNumbers, bonusNumber);

        double returnRate = calculateReturnRate(result, userNumbers.size() * 1000);
        assertThat(returnRate).isEqualTo(0);
    }

    @DisplayName("수익률 소수점 한 자리 검증 테스트.")
    @Test
    void testReturnRateDoubleWinner() {
        List<List<Integer>> userNumbers = new ArrayList<>(List.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12),
            List.of(7, 8, 9, 10, 11, 12)
        ));

        List<Integer> winnerNumbers = List.of(1, 2, 3, 21, 22, 23);
        int bonusNumber = 30;

        WinnerStatsData result = LotteryResultRenderer.getLottoResult(userNumbers, winnerNumbers, bonusNumber);

        double returnRate = calculateReturnRate(result, userNumbers.size() * 1000);
        assertThat(returnRate).isEqualTo(55.6);
    }


}
