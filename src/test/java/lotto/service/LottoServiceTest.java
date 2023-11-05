package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import lotto.model.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        WinningStatistics winningStatistics = new WinningStatistics(new HashMap<>());
        winningStatistics.checkWinningResult(6, false);
        winningStatistics.checkWinningResult(5, true);
        winningStatistics.checkWinningResult(5, false);
        winningStatistics.checkWinningResult(4, false);
        winningStatistics.checkWinningResult(3, false);
        lottoService = new LottoService(null, winningStatistics);
    }

    @DisplayName("총당첨 금액과 구입 금액으로 총수익률을 계산하고, 소수점 둘째 자리에서 반올림한다.")
    @Test
    void calculateTotalYield() {
        int inputAmount = 7000;
        String totalYield = lottoService.calculateTotalYield(inputAmount);

        assertThat(totalYield).isEqualTo("29,022,214.3");
    }
}
