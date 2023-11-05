package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.LottoPublishServiceImpl;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    LottoController lottoController;

    @BeforeEach
    void init() {
        lottoController = new LottoController(new LottoPublishServiceImpl());
    }

    @Test
    @DisplayName("\"\" 입력시 예외 발생")
    void InputNonToAmount() {

        // Given
        String inputPurchaseAmount = "";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.publishLotto(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
    }

    @Test
    @DisplayName("문자 입력시 예외 발생")
    void InputCharToAmount() {

        // Given
        String inputPurchaseAmount = "abc";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.publishLotto(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
    }

    @Test
    @DisplayName("공백 입력시 예외 발생")
    void InputSpaceToAmount() {

        // Given
        String inputPurchaseAmount = "   ";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.publishLotto(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
    }
}