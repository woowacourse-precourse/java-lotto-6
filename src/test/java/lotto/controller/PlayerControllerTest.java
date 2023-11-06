package lotto.controller;

import static lotto.constant.ExceptionMessage.INSUFFICIENT_PRICE_TO_BUY;
import static lotto.constant.ExceptionMessage.NON_NUMERIC_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerControllerTest {

    AppConfig appConfig = new AppConfig();
    private PlayerController playerController = appConfig.playerController();

    @ParameterizedTest
    @DisplayName(value = "입력 값에 숫자 이외의 값이 있으면 예외가 발생하는지 확인")
    @ValueSource(strings = {"aaa", "1a1", "11a", "-11"})
    void purchaseLottoByNonNumericInput(String input) {
        assertThatThrownBy(() -> playerController.purchaseLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_NUMERIC_ERROR.getMessage());
    }

    @Test
    @DisplayName(value = "입력된 금액이 로또 구입에 필요한 금액보다 적을 시 예외가 발생하는지 확인")
    void purchaseLottoByInsufficientAmount() {
        assertThatThrownBy(() -> playerController.purchaseLotto("800"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INSUFFICIENT_PRICE_TO_BUY.getMessage());
    }

}