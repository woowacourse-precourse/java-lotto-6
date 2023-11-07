package lotto.config;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class WinningResultConfigTest {
    @DisplayName("model_WinningResultConfig_객체_전달_하기")
    @Test
    public void model_WinningResultConfig_return_object() {
        List<Integer> equalCounts = Arrays.asList(4 ,5, 5, 6);
        List<String> bonus = Arrays.asList("", "", "보너스 볼", "");

        for (int equalCount : equalCounts) {
            assertThat(WinningResultConfig.findWinningResultConfig(equalCount, bonus.get(equalCounts.indexOf(equalCount))).getResultStatus())
                    .contains(Integer.toString(equalCount))
                    .contains(bonus.get(equalCounts.indexOf(equalCount)));
        }
    }
}