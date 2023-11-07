package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void testPurchaseAmount() {
        // given
        String purchaseAmount = "3000";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount)).doesNotThrowAnyException();

    }

    @Test
    void testPurchaseAmountFail1000() {
        // given
        String purchaseAmount = "4200";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testNonNumericPurchaseAmount() {
        // given
        String purchaseAmount = "wrong value";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testSixNumbers() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).doesNotThrowAnyException();
    }

    @Test
    void testSpaceRemoval() {
        // given
        String input = "1,    2, 3, 4, 5, 6";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).doesNotThrowAnyException();
    }

    @Test
    void testOver45() {
        // given
        String input = "1,2,3,4,5,49";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testNonNumericLottoNumbers() {
        // given
        String input = "나도,로또,당첨,됐으면";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testLottoNumber() {
        // given
        String input = "6";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateLottoNumber(input)).doesNotThrowAnyException();
    }

    @Test
    void testOver45LottoNumber() {
        // given
        String input = "100";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateLottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testNonNumericLottoNumber() {
        // given
        String input = "당첨";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateLottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}