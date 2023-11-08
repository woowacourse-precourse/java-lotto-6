package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 999, -123, })
    @DisplayName("입력받은 금액이 1000원 미만인 경우, 예외를 발생시킨다.")
    void validate_lessThanThousand(Integer amount) {
        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 이상만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1111, 1234, 10005})
    @DisplayName("입력받은 금액이 1000원 단위가 아닌 경우, 예외를 발생시킨다.")
    void validate_nonThousandUnit(Integer amount) {
        // then
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
    }


}