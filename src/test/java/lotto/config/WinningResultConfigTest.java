package lotto.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class WinningResultConfigTest {
    @DisplayName("model_WinningResultConfig_객체_전달_하기")
    @Test
    public void model_WinningResultConfig_return_object() {
        List<Long> equalCounts = Arrays.asList(4L ,5L, 5L, 6L);
        List<String> bonus = Arrays.asList("", "", "보너스 볼", "");

        for (Long equalCount : equalCounts) {
            assertThat(WinningResultConfig.compareResult(equalCount, bonus.get(equalCounts.indexOf(equalCount))).getResultStatus())
                    .contains(equalCount.toString())
                    .contains(bonus.get(equalCounts.indexOf(equalCount)));
        }
    }
}