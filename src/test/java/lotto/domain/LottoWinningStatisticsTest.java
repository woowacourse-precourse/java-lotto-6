package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.LottoWinningTier;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {
    @Test
    @DisplayName("불가능한 금액을 입력할 시 예외가 발생한다.")
    void calculateStatisticsByImpossibleAmount() {
        assertThrows(IllegalArgumentException.class, () ->
                LottoWinningStatistics.calculateStatistics(-1_000, List.of(LottoWinningTier.FIRST_TIER)));
    }

}
