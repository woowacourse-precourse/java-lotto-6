package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.WinningNumber;
import lotto.service.LottoPublishServiceImpl;
import lotto.service.WinningServiceImpl;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    LottoController lottoController;

    @BeforeEach
    void init() {
        lottoController = new LottoController(new LottoPublishServiceImpl(), new WinningServiceImpl());
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

//            - 중간에 2,,4 와 같은 입력
//      - 마지막에 5, 와 같은 입력
//    - [X] 문자 입력 시 예외 발생
    @Test
    @DisplayName("당첨 번호 입력 시 맨앞 공백 예외 발생")
    void winningNumberFirstSpace() {
        // Given
        String winningNumbers = ",2,3,4,5,6";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
    }

    @Test
    @DisplayName("당첨 번호 입력 시 중간 공백 예외 발생")
    void winningNumberBetweenSpace() {
        // Given
        String winningNumbers = "1,2,3,,5,6";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_BUY_AMOUNT_TYPE);
    }
}