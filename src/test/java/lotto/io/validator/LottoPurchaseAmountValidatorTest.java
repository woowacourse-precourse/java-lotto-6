package lotto.io.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_BE_NUMERIC;
import static lotto.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static lotto.exception.ExceptionMessage.InputException.PURCHASE_AMOUNT_MUST_BE_POSITIVE;
import static lotto.exception.ExceptionMessage.InputException.PURCHASE_AMOUNT_MUST_MEET_SPECIFIC_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoPurchaseAmountValidatorTest {
    @Test
    @DisplayName("로또 구입금액에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validate("8000 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("로또 구입금액이 숫자가 아니면 예외가 발생한다")
    void throwExceptionByInputIsNotNumeric() {
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validate("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_BE_NUMERIC.message);
    }

    @Test
    @DisplayName("로또 구입금액이 음수면 예외가 발생한다")
    void throwExceptionByPurchaseAmountIsNegative() {
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validate("-8000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_MUST_BE_POSITIVE.message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"800", "7800", "10900"})
    @DisplayName("로또 구입금액이 1000원 단위가 아니면 예외가 발생한다")
    void throwExceptionByPurchaseAmountNotMeetSpecificUnit(final String userInput) {
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validate(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_MUST_MEET_SPECIFIC_UNIT.message);
    }

    @Test
    @DisplayName("로또 구입금액 검증에 성공한다")
    void success() {
        assertDoesNotThrow(() -> LottoPurchaseAmountValidator.validate("8000"));
    }
}
