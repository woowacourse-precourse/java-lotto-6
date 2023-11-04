package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ExceptionMessage.LOTTO_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoControllerTest {

    LottoController lottoController = new LottoController();

    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7" })
    @DisplayName(value = "입력된 숫자가 6개가 아닐 경우 예외가 발생하는지 확인")
    void inputNumbers(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoController.inputNumbers(input))
                .withMessage(LOTTO_SIZE_ERROR.getMessage());
    }

}