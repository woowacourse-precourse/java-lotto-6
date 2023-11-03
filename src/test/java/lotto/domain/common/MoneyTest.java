package lotto.domain.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Money money = Money.from(1000);
        Money other = Money.from(1000);

        assertThat(money).isEqualTo(other);
    }

    @DisplayName("돈은 양수여야 한다.")
    @Test
    void checkPositiveMoney() {
        assertThatThrownBy(() -> Money.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 양수여야 합니다.");
    }
}
