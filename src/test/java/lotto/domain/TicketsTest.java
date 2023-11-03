package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    @DisplayName("입력한 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void constructorNonMumericTest() {
        assertThatThrownBy(() -> new Tickets("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 1000원으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void constructorDivideTest() {
        assertThatThrownBy(() -> new Tickets("13500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
