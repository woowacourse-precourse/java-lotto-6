package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.validator.PurchaseValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseTest {
    PurchaseValidator purchaseValidator = new PurchaseValidator();

    @DisplayName("0 또는 음수를 입력할경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -12, -1000})
    void check_validatePositive(int value) {
        assertThatThrownBy(() -> purchaseValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 큰 숫자로 입력해야 합니다.");
    }

    @DisplayName("1000 단위가 아닌 숫자를 입력할경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1010})
    void check_validateUnit(int value) {
        assertThatThrownBy(() -> purchaseValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위의 숫자로 입력해야 합니다.");
    }
}
