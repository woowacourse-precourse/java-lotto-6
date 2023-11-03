package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerControllerTest {

    private PlayerController playerController = new PlayerController();

    @ParameterizedTest
    @DisplayName(value = "입력 값에 숫자 이외의 값이 있으면 예외가 발생하는지 확인")
    @ValueSource(strings = { "aaa", "1a1", "11a", "-11" })
    void purchaseLottoByNonNumericInput(String input) {
        assertThatThrownBy(() -> playerController.purchaseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_NUMERIC_ERROR.getMessage());
    }

}