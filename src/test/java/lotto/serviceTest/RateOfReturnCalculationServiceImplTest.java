package lotto.serviceTest;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.WinningStatus;
import lotto.service.RateOfReturnCalculationService;
import lotto.service.RateOfReturnCalculationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateOfReturnCalculationServiceImplTest {
    @DisplayName("의도한 수익률이 나오는지 테스트")
    @Test
    public void testCalculateRateOfReturn() {
        Map<WinningStatus, Integer> winningStatistics = new HashMap<>();
        winningStatistics.put(WinningStatus.FIRST, 0);
        winningStatistics.put(WinningStatus.SECOND, 0);
        winningStatistics.put(WinningStatus.THIRD, 0);
        winningStatistics.put(WinningStatus.FOURTH, 0);
        winningStatistics.put(WinningStatus.FIFTH, 1);

        RateOfReturnCalculationService rateOfReturnCalculationService = new RateOfReturnCalculationServiceImpl();

        double rateOfReturn = rateOfReturnCalculationService.calculateRateOfReturn(8000, winningStatistics);

        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
