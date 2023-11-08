package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("돈이 1000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByChanges() {
        assertThatThrownBy(() -> Money.from("10500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 입력되지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByEmpty() {
        assertThatThrownBy(() -> Money.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 숫자가 아니먄 예외가 발생한다.")
    @Test
    void createMoneyByString() {
        assertThatThrownBy(() -> Money.from("돈"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}