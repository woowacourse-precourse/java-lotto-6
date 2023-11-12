package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("1000원 단위가 아닌 수가 입력되면 예외 발생")
    @Test
    void 잘못된_단위_입력_예외_테스트() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
