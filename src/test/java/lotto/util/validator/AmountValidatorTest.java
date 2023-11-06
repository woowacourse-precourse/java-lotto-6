package lotto.util.validator;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AmountValidatorTest {

    private final InputValidator<Integer> validator = new AmountValidator();

    @ParameterizedTest
    @ValueSource(ints = {500, 200, -1000})
    @DisplayName("금액이 로또 가격 미만일 때 IllegalArgumentException을 던져야 한다.")
    void testValidateAmountLessThanLottoPrice(int amount) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(amount),
                ErrorMessage.AMOUNT_SMALL_THAN_THOUSAND);
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 11001})
    @DisplayName("금액이 1000원 단위가 아닐 때 IllegalArgumentException을 던져야 한다.")
    void testValidateAmountNotMultipleOfThousand(int amount) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(amount),
                ErrorMessage.NOT_MULTIPLE_OF_THOUSAND);
    }
}
