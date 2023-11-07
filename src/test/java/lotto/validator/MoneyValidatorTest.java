package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @DisplayName("입력한 로또 구매 금액이 빈칸인 경우 예외를 발생시킨다.")
    @Test
    void validateLottoBuyMoneyByBlank(){
        assertThatThrownBy(() -> MoneyValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 로또 구매 금액이 정수가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateLottoBuyMoneyByNotInteger(){
        assertThatThrownBy(() -> MoneyValidator.validate("NotNumber"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 로또 구매 금액이 10만원을 초과한 경우 예외를 발생시킨다.")
    @Test
    void validateLottoBuyMoneyByOverMaxRange(){
        assertThatThrownBy(() -> MoneyValidator.validate("200000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 로또 구매 금액이 1000원 단위가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateLottoBuyMoneyByNotThousandUnit(){
        assertThatThrownBy(() -> MoneyValidator.validate("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
