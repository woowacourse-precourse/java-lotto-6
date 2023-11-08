package lotto.domain;


import static lotto.error.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
}