package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessage.LOTTO_SIZE_ERROR;
import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoControllerTest {

    LottoController lottoController = new LottoController();

    @ParameterizedTest
    @ValueSource(strings = { "1 2 3 4 5", "1 2 3 4 5 6 7" })
    @DisplayName(value = "입력된 숫자가 6개가 아닐 경우 예외가 발생하는지 확인")
    void inputNumbersByInsufficientSize(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoController.inputNumbers(input))
                .withMessage(LOTTO_SIZE_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "a 2 ㅁ 4 5 6", "k 2 3 4 5 6" })
    @DisplayName(value = "숫자가 아닌 입력 값이 존재할 경우 예외가 발생하는지 확인")
    void inputNumbersByNonNumericInputs(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoController.inputNumbers(input))
                .withMessage(NON_NUMERIC_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1 2 2 4 5 6", "6 2 3 4 5 6" })
    @DisplayName(value = "중복된 숫자가 존재할 경우 예외가 발생하는지 확인")
    void inputNumbersByDuplicatedNumber(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoController.inputNumbers(input))
                .withMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1 2 3 4 5 60", "1 2 3 4 5 46" })
    @DisplayName(value = "입력된 숫자가 1부터 45사이의 숫자가 아닐 경우 예외가 발생하는지 확인")
    void inputNumbersByOutOfRangeNumber(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoController.inputNumbers(input))
                .withMessage(NUMBER_OUT_OF_RANGE.getMessage());
    }

}