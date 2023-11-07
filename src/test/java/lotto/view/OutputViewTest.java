package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final OutputView outputView = new OutputView();

    @DisplayName("로또 개수와 총 상금을 가지고 수익률을 계산한다")
    @Test
    void calculateRateOfReturn() {
        double rateOfReturn = outputView.calculateRateOfReturn(3, 1500);

        Assertions.assertThat(rateOfReturn).isEqualTo(50.0);
    }
}
