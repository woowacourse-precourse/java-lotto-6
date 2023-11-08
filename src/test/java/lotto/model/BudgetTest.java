package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BudgetTest {
    @DisplayName("정수가 아닌 값으로 예산을 생성하면 예외가 발생한다.")
    @Test
    void createBudgetNotInteger() {
        assertThatThrownBy(() -> new Budget("asdf"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("양의 정수가 아닌 값으로 예산을 생성하면 예외가 발생한다.")
    @Test
    void createNotPositiveInteger() {
        assertThatThrownBy(() -> new Budget("-1110"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 1000으로 나누어 떨어지지 않는 예산을 생성하면 예외가 발생한다.")
    @Test
    void createNotModuloResultZero() {
        assertThatThrownBy(() -> new Budget("1110"))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("예산값과 로또 개수를 리턴한다.")
    @Test
    void getLottoAmount() {
        Budget budget = new Budget("3000");
        assertThat(budget.getBudget()).isEqualTo(3000);
        assertThat(budget.getLottoAmount()).isEqualTo(3);
    }
}
