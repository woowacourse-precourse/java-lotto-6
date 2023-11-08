package lotto.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class WinningResultConfigTest {
    @DisplayName("model_WinningResultConfig_ResultStatus_값_확인 ")
    @ParameterizedTest
    @CsvSource(value = {"THREE:3", "FOUR:4", "FIVE:5", "FIVE_AND_BONUS:5,보너스 볼", "SIX:6"}, delimiter = ':')
    @Order(1)
    void model_WinningResultConfig_getResultStatus(WinningResultConfig winningResultConfig, String resultStatus) {
        assertThat(winningResultConfig.getResultStatus()).contains(resultStatus);
    }

    @DisplayName("model_WinningResultConfig_RevenueStatus_값_확인 ")
    @ParameterizedTest
    @CsvSource(value = {"THREE:5000", "FOUR:50000", "FIVE:1500000", "FIVE_AND_BONUS:30000000", "SIX:2000000000"}, delimiter = ':')
    @Order(2)
    void model_WinningResultConfig_getRevenueStatus(WinningResultConfig winningResultConfig, int revenueStatus) {
        assertThat(winningResultConfig.getRevenueStatus()).isEqualTo(revenueStatus);
    }

    @DisplayName("model_WinningResultConfig_객체_전달_하기")
    @Test
    @Order(3)
    void model_WinningResultConfig_return_object() {
        List<Integer> equalCounts = Arrays.asList(4 ,5, 5, 6);
        List<String> bonus = Arrays.asList("", "", "보너스 볼", "");

        for (int equalCount : equalCounts) {
            assertThat(WinningResultConfig.findWinningResultConfig(equalCount, bonus.get(equalCounts.indexOf(equalCount))).getResultStatus())
                    .contains(Integer.toString(equalCount))
                    .contains(bonus.get(equalCounts.indexOf(equalCount)));
        }
    }

}