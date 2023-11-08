package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("구입금액이 공백이라면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByEmptyOrBlank() {
        assertThat(Validator.verifyPurchaseAmount("")).isFalse();
    }

    @DisplayName("구입금액에 문자가 포함되어있다면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByCharacter() {
        assertThat(Validator.verifyPurchaseAmount("a")).isFalse();
    }

    @DisplayName("구입금액이 1000원 미만이라면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByUnderThousand() {
        assertThat(Validator.verifyPurchaseAmount("999")).isFalse();
    }

    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않으면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByIndivisibleToThousand() {
        assertThat(Validator.verifyPurchaseAmount("1234")).isFalse();
    }
}
