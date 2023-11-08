package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BudgetTest {

    @DisplayName("[Exception] 1000원 단위 이외의 금액을 입력하면 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 31, 200001})
    void budgetTest(int money) {
        assertThatThrownBy(()-> new Budget(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
