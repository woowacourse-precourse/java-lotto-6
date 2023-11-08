package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ArgumentIsZeroException;
import lotto.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class MoneyTest {

    private static final int zero = 0, negative = -10, indivisibleByUnit = 1001, validMoney = 10000;

    @DisplayName("구입 금액이 0이면 예외가 발생한다.")
    @Test
    void createMoneyByZero() {
        assertThatThrownBy(() -> new Money(zero))
                .isInstanceOf(ArgumentIsZeroException.class);
    }
    @DisplayName("구입 금액이 요구사항의 단위에 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByValueNotDivisibleByUnit() {
        assertThatThrownBy(() -> new BonusNumber(negative))
                .isInstanceOf(NumberOutOfRangeException.class);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(indivisibleByUnit));
    }

    @DisplayName("성공적으로 머니 인스턴스를 생성한다.")
    @Test
    void createMoneySuccessfully() {
        Assertions.assertAll(() -> new Money(validMoney));
    }
}
