package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("금액은 숫자만 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "천원", "1000won"})
    void isNumeric(String moneys) {
        Assertions.assertThatThrownBy(() -> Money.of(moneys))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @DisplayName("최소 금액은 1,000원 이상 이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0", "500"})
    void isOverThousand(String moneys) {
        Assertions.assertThatThrownBy(() -> Money.of(moneys))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 금액은 1,000원 입니다.");
    }

    @DisplayName("금액은 1,000원 단위여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1200", "1350", "1557"})
    void isDivisibleByThousand(String moneys) {
        Assertions.assertThatThrownBy(() -> Money.of(moneys))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1,000원 단위로 입력해 주세요.");
    }

}