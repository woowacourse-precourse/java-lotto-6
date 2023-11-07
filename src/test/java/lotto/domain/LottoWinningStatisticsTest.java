package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Amount;
import domain.LottoWinningStatistics;
import domain.LottoWinningTier;
import dto.LottoStatisticsResult;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {
    @Test
    @DisplayName("불가능한 금액을 입력할 시 예외가 발생한다.")
    void calculateStatisticsByImpossibleAmount() {
        assertThrows(IllegalArgumentException.class, () ->
                LottoWinningStatistics.calculateStatistics(new Amount(-1_000),
                        List.of(Optional.of(LottoWinningTier.FIRST_TIER))));
    }

    @Test
    @DisplayName("통계 정상 반환")
    void calculateStatistics() {
        LottoStatisticsResult lottoStatisticsResult = assertDoesNotThrow(
                () -> LottoWinningStatistics.calculateStatistics(new Amount(3_000),
                        List.of(
                                Optional.of(LottoWinningTier.FIRST_TIER),
                                Optional.of(LottoWinningTier.FIRST_TIER),
                                Optional.of(LottoWinningTier.FIRST_TIER)
                        )));

        assertThat(lottoStatisticsResult.getPercentOfTotalWinningAmount()).isEqualTo(2_000_000);
    }

}
