package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyAmountExceptionTest {
    @DisplayName("1000원 단위로 나누어 떨어지는 금액은 예외가 발생하지 않는다.")
    @Test
    void testMoneyReader_ValidAmount() {
        int validAmount = 3000; // 1000원 단위로 나누어 떨어진다


        assertThatCode(() -> MoneyAmountException.money_reader(validAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("1000원 단위로 나누어 떨어지지 않는 금액은 NumberFormatException 예외가 발생한다.")
    @Test
    void testMoneyReader_InvalidAmount() {

        int invalidAmount = 2500; // 1000원 단위로 나누어 떨어지지 않는다


        assertThatThrownBy(() -> MoneyAmountException.money_reader(invalidAmount))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR]알맞는 값이 아닙니다 다시 입력 하세요");
    }
}