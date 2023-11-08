package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest  {
    @DisplayName("생성자 매개변수 음수가 음수면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeNumber() {
        assertThatThrownBy(() -> new Money("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성자 매개변수 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNotMultiple1000() {
        assertThatThrownBy(() -> new Money("5001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
