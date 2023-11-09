package lotto.model;

import static lotto.Message.ErrorMessage.OBJECT_IS_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class RevenueTest {
    @DisplayName("model_Revenue_null_들어왔을_때_예외_처리")
    @Test
    void model_Revenue_null_input() {
        assertThatThrownBy(() -> new Revenue(null, 8000))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining(OBJECT_IS_NULL.getMessage());
    }
    @DisplayName("model_Revenue_총_수익룰_구하기")
    @Test
    void model_Revenue_calculate_total_revenue() {
        List<List<Integer>> winningResultSources = Arrays.asList(
                Arrays.asList(5000, 3),
                Arrays.asList(50000, 1),
                Arrays.asList(1500000, 2),
                Arrays.asList(30000000, 0),
                Arrays.asList(2000000000, 0)
        );

        Revenue revenue = new Revenue(winningResultSources, 8000);

        assertThat(revenue.getRevenue()).isEqualTo(38312.5);
    }
}
