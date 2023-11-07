package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void 금액_검증_부족() {
        assertThatThrownBy(() -> new Money(999)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 천보다 큰 금액을 입력해주세요.");
    }

    @Test
    void 금액_검증_큼() {
        assertThatThrownBy(() -> new Money(5000000)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 100만을 넘는 금액은 입력 할 수 없습니다.");
    }

}
