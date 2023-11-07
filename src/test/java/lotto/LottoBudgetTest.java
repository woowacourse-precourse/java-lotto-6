package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBudgetTest {
    
    @DisplayName("구입 금액이 0자이면 예외가 발생한다.")
    @Test
    void inputBudgetTextEmpty() {
        assertThatThrownBy(() -> new LottoBudget(""))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("구입 금액에 수가 아닌 입력을 하면 예외가 발생한다.")
    @Test
    void inputBudgetTextNotNumber() {
        assertThatThrownBy(() -> new LottoBudget("안녕하세요"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("구입 금액에 양수가 아닌 입력을 하면 예외가 발생한다.")
    @Test
    void inputBudgetNegative() {
        assertThatThrownBy(() -> new LottoBudget("-1000"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("구입 금액이 로또 한장의 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputBudgetIndivisible() {
        assertThatThrownBy(() -> new LottoBudget("5721"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
}
