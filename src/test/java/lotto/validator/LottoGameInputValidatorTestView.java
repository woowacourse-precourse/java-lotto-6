package lotto.validator;

import lotto.message.ErrorMessage;
import lotto.view.input.validator.LottoGameInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameInputValidatorTestView {

    private LottoGameInputValidator validator = new LottoGameInputValidator();

    @ParameterizedTest(name = "{index}: 숫자가 아닌 입력으로 {0}이 들어오면 예외가 발생한다.")
    @DisplayName("숫자가 아닌 다른 입력이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"asda", "안녕하세요", "中國語", "ひらがな"})
    public void parseLongException(String input) {
        // when // then
        assertThatThrownBy(() -> validator.parseLong(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
    @DisplayName("Lotto의 금액이 0보다 크지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"0","-1000","-1500"})
    public void validatePositiveNumberException(String input) {
        //given
        long number = Long.parseLong(input);
        // when // then
        assertThatThrownBy(() -> validator.validatePositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
    @DisplayName("Lotto의 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ValueSource(longs = {1200, 3800200, 948300, 300})
    public void requestLottoPurchaseAmountException(long number) {
        // when // then
        assertThatThrownBy(() -> validator.validateTicketPurchase(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
    }

}