package lotto.service.validation;

import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoValidatorTest {

    @CsvSource(value = {"-1", "0", "1234", "' '", "abcd"})
    @ParameterizedTest
    void 로또_구입_금액이_1000의_배수가_아니면_예외가_발생한다(String purchaseAmount) {
        //Arrange
        LottoValidator validator = new LottoValidator();

        //Act //Assert
        assertThatThrownBy(() -> validator.verifyPurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
}