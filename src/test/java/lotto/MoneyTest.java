package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void 금액_검증_부족() {
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 천보다 큰 금액을 입력해주세요.");
    }

    @Test
    void 금액_검증_큼() {
        assertThatThrownBy(() -> new Money(5000000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 100만을 넘는 금액은 입력 할 수 없습니다.");
    }

    @Test
    void 구매_가능한_로또() {
        assertThat(new Money(10000).availableCount()).isEqualTo(10);
    }

}
