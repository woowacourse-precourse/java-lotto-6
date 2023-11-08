package lotto.domain;


import static lotto.error.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

    @DisplayName("구매 금액 검증이 가능하다.")
    @Test
    void validatePurchaseAmountTest() {
        assertAll(
                () -> assertThatThrownBy(() -> validator.validatePurchaseAmount("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NEGATIVE_PURCHASE_AMOUNT),
                () -> assertThatThrownBy(() -> validator.validatePurchaseAmount("1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_DIVIDED_PURCHASE_AMOUNT),
                () -> assertThatCode(() -> validator.validatePurchaseAmount("1000"))
                        .doesNotThrowAnyException()
        );
    }

    @DisplayName("당첨 숫자 검증이 가능하다.")
    @Test
    void validateWinningNumbersTest() {
        assertAll(
                () -> assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,5,6,7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_WINNING_NUMBER_LENGTH),
                () -> assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,5,46"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WINNING_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,6,6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_WINNING_NUMBER),
                () -> assertThatCode(() -> validator.validateWinningNumbers("1,2,3,4,5,6"))
                        .doesNotThrowAnyException()
        );
    }

    @DisplayName("보너스 숫자 검증이 가능하다.")
    @Test
    void validateBonusNumberTest() {
        assertAll(
                () -> assertThatThrownBy(() -> validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "46"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_BONUS_NUMBER),
                () -> assertThatCode(() -> validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "7"))
                        .doesNotThrowAnyException()
        );
    }
}