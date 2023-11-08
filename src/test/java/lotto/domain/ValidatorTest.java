package lotto.domain;


import static lotto.error.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void 초기화() {
        validator = new Validator();
    }

    @Test
    void 구매_금액_검증이_가능하다() {
        assertAll(
                () -> assertThatThrownBy(() -> validator.validatePurchaseAmount(-1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NEGATIVE_PURCHASE_AMOUNT),
                () -> assertThatThrownBy(() -> validator.validatePurchaseAmount(1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_DIVIDED_PURCHASE_AMOUNT),
                () -> assertThatCode(() -> validator.validatePurchaseAmount(1000))
                        .doesNotThrowAnyException()
        );
    }

    @Test
    void 당첨_숫자_검증이_가능하다() {
        assertAll(
                () -> assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_WINNING_NUMBER_LENGTH),
                () -> assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WINNING_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 6, 6)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_WINNING_NUMBER),
                () -> assertThatCode(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 6)))
                        .doesNotThrowAnyException()
        );
    }

    @Test
    void 보너스_숫자_검증이_가능하다() {
        assertAll(
                () -> assertThatThrownBy(() -> validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_BONUS_NUMBER),
                () -> assertThatCode(() -> validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 7))
                        .doesNotThrowAnyException()
        );
    }
}