package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.validator.UserMoneyInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserMoneyInputValidatorTest {
    @DisplayName("구입 금액이 비어있는 입력값일 때 예외가 발생한다.")
    @Test
    void insertUserMoneyWithBlankValue() {
        assertThatThrownBy(() -> new UserMoneyInputValidator().validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자형식이 아닌 입력값일 때 예외가 발생한다.")
    @Test
    void insertUserMoneyWithNonNumericValue() {
        assertThatThrownBy(() -> new UserMoneyInputValidator().validate("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 로또 금액(1000)의 배수가 아닌 입력값일 때 예외가 발생한다.")
    @Test
    void insertUserMoneyWithNotDivisibleWithLottoPrice() {
        assertThatThrownBy(() -> new UserMoneyInputValidator().validate("1111"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}