package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("금액은 숫자만 가능하다.")
    @Test
    void isNumeric() {
        Assertions.assertThatThrownBy(() -> Money.of("하이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @DisplayName("최소 금액은 1,000원 이상 이여야 한다.")
    @Test
    void isOverThousand() {
        Assertions.assertThatThrownBy(() -> Money.of("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 금액은 1,000원 입니다.");
    }

    @DisplayName("금액은 1,000원 단위여야 한다.")
    @Test
    void isDivisibleByThousand() {
        Assertions.assertThatThrownBy(() -> Money.of("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1,000원 단위로 입력해 주세요.");
    }

}