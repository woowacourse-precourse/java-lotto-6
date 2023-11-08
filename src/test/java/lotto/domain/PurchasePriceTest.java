package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {

    @DisplayName("구입 가격을 0으로 입력하면 예외가 발생한다.")
    @Test
    void validateZero() {
        assertThatThrownBy(() -> PurchasePrice.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 가격이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"100", "5300"})
    void validatePrice(String input) {
        assertThatThrownBy(() -> PurchasePrice.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 가격이 10만원을 넘으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"101000", "9223372036854770000"})
    void validateLimit(String input) {
        assertThatThrownBy(() -> PurchasePrice.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}