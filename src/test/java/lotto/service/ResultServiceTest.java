package lotto.service;

import lotto.domain.LottoResultCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultServiceTest {

    private LottoResultCount resultCount;
    private ResultService resultService;

    @BeforeEach
    void init() {
        resultCount = new LottoResultCount();
        resultService = new ResultService();
    }

    @Test
    @DisplayName("수익률이 0.0%인 경우")
    void testZeroProfitRate() {
        // Arrange
        resultService.createResultService(resultCount, 0);

        // Act
        Double profitRate = resultService.getLottoProfitRate();

        // Assert
        assertThat(profitRate).isZero();
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void testProfitRateCalculation() {
        // Arrange
        resultCount.addThreeCount();
        resultCount.addFourCount();
        resultCount.addFiveCount();
        resultCount.addFiveWithBonusCount();
        ResultService resultService = new ResultService();
        resultService.createResultService(resultCount, 5000); // 5000원을 구매했다고 가정

        // Act
        Double profitRate = resultService.getLottoProfitRate();

        // Assert
        assertThat(profitRate).isEqualTo(631.1); // 예상 수익은 400원 (5000 * 400%)
    }
}