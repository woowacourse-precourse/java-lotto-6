package lotto.model;

import static lotto.error.ErrorMessage.NEGATIVE_PRICE;
import static lotto.error.ErrorMessage.NOT_DIGIT_PRICE;
import static lotto.error.ErrorMessage.NOT_THOUSAND_UNIT_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {

    @Test
    @DisplayName("구입 금액은 숫자가 아닌 값일 수 없다.")
    void invalidPrice_NotDigitValue() {
        // Given
        String value = "가나다";

        // When & Then
        assertThatThrownBy(() -> new PurchasePrice(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIGIT_PRICE.getMessage());
    }

    @Test
    @DisplayName("구입 금액은 음수일 수 없다.")
    void invalidPrice_NegativeNumber() {
        // Given
        String value = "-1";

        // When & Then
        assertThatThrownBy(() -> new PurchasePrice(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_PRICE.getMessage());
    }

    @Test
    @DisplayName("구입 금액은 천 단위여야 한다.")
    void invalidPrice_NotThousandUnit() {
        // Given
        String value = "8001";

        // When & Then
        assertThatThrownBy(() -> new PurchasePrice(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_THOUSAND_UNIT_PRICE.getMessage());
    }

    @Test
    @DisplayName("천 단위의 양수로 구입 금액을 만들 수 있다.")
    void validPrice_PositivieThousandUnitDigit() {
        // Given
        String value = "8000";

        // When
        PurchasePrice result = new PurchasePrice(value);

        // Then
        assertThat(result.getPrice())
                .isEqualTo(Long.parseLong(value));
    }

}