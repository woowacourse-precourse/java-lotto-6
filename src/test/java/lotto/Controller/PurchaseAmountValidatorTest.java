package lotto.Controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import lotto.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PurchaseAmountValidator();
    }

    @Test
    public void testValidPurchaseAmount() {
        // 유효한 구매 금액 (1000의 배수) 테스트
        assertThatCode(() -> validator.validate("2000"))
                .doesNotThrowAnyException();
    }

    @Test
    public void testNotANumber() {
        // 숫자가 아닌 입력 테스트
        assertThatThrownBy(() -> validator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.NOT_A_NUMBER_EXCEPTION);
    }

    @Test
    public void testZeroInput() {
        // 0 입력 테스트
        assertThatThrownBy(() -> validator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ZERO_EXCEPTION_MESSAGE);
    }

    @Test
    public void testNonDivisibleBy1000() {
        // 1000의 배수가 아닌 입력 테스트
        assertThatThrownBy(() -> validator.validate("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE);
    }
}