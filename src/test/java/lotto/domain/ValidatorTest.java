package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("1,000원 단위의 유효한 구매 금액을 입력하면 통과한다.")
    @Test
    void testPurchaseAmount() {
        // given
        String purchaseAmount = "3000";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount)).doesNotThrowAnyException();

    }

    @DisplayName("구매 금액이 1,000원 단위의 금액이 아니면 예외가 발생한다.")
    @Test
    void testPurchaseAmountFail1000() {
        // given
        String purchaseAmount = "4200";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void testNonNumericPurchaseAmount() {
        // given
        String purchaseAmount = "wrong value";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되지 않은 1~ 45 사이의 6개의 로또 당첨 번호를 입력하면 통과한다.")
    @Test
    void testSixNumbers() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 입력 시 공백을 허용한다.")
    @Test
    void testSpaceRemoval() {
        // given
        String input = "1,    2, 3, 4, 5, 6";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).doesNotThrowAnyException();
    }

    @DisplayName("45가 넘는 로또 번호를 입력하면 예외가 발생한다.")
    @Test
    void testOver45() {
        // given
        String input = "1,2,3,4,5,49";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 로또 번호를 입력하면 예외가 발생한다.")
    @Test
    void testNonNumericLottoNumbers() {
        // given
        String input = "나도,로또,당첨,됐으면";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 사이의 보너스 번호를 입력하면 통과한다")
    @Test
    void testLottoNumber() {
        // given
        String input = "6";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateLottoNumber(input)).doesNotThrowAnyException();
    }

    @DisplayName("45가 넘는 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void testOver45LottoNumber() {
        // given
        String input = "100";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateLottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void testNonNumericLottoNumber() {
        // given
        String input = "당첨";

        // when
        // then
        Assertions.assertThatCode(() -> Validator.validateLottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}