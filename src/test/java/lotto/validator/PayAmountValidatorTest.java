package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PayAmountValidatorTest {
    Validator payAmountValidator = new PayAmountValidator();

    @DisplayName("구매 금액으로 Null 및 공백 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void testWhenPayAmountIsNullOrBlank(String payAmount) {
        IllegalArgumentException payAmountException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> payAmountValidator.validate(payAmount));
        assertThat(payAmountException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("구매 금액으로 숫자가 아닌 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"오천원", "five", "$", "5$"})
    void testWhenPayAmountIsNotNumeric(String payAmount) {
        IllegalArgumentException payAmountException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> payAmountValidator.validate(payAmount));
        assertThat(payAmountException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("구매 금액으로 10자리를 초과하는 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000000000000000000000000000000000000000000000","1234567891234567989000"})
    void testWhenPayAmountDigitOverTen(String payAmount) {
        IllegalArgumentException payAmountException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> payAmountValidator.validate(payAmount));
        assertThat(payAmountException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("구매 금액으로 1,000원으로 나누어 떨어지지 않는 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "1300", "39900", "123456789"})
    void testWhenPayAmountCannotDivideOneThousand(String payAmount) {
        IllegalArgumentException payAmountException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> payAmountValidator.validate(payAmount));
        assertThat(payAmountException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("구매 금액으로 20억을 넘는 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2000001000","5000000000"})
    void testWhenPayAmountIsOverTwoBillion(String payAmount) {
        IllegalArgumentException payAmountException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> payAmountValidator.validate(payAmount));
        assertThat(payAmountException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("적절한 구매 금액 입력 시 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "20000", "35000", "1999999000"})
    void testWhenPurchaseAmountIsValid(String payAmount) {
        Assertions.assertDoesNotThrow(() -> payAmountValidator.validate(payAmount));
    }
}
