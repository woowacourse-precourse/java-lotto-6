package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void 금액이_양수가_아니라면_예외를_발생시킨다(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 0보다 큰 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1000, 10000})
    void 금액은_양수여야_한다(int money) {
        assertThatCode(() -> new Money(money))
                .doesNotThrowAnyException();
    }
}
