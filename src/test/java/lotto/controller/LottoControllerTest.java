package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.LottoPublishServiceImpl;
import lotto.service.WinningServiceImpl;
import lotto.service.YieldRateServiceImpl;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    LottoController lottoController;

    @BeforeEach
    void init() {
        lottoController = new LottoController(
                new LottoPublishServiceImpl(),
                new WinningServiceImpl(),
                new YieldRateServiceImpl()
        );
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
                .hasMessage(ExceptionMessage.ERROR_TYPE);
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
                .hasMessage(ExceptionMessage.ERROR_TYPE);
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
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }

    @Test
    @DisplayName("당첨 번호 입력 시 맨앞 공백 예외 발생")
    void winningNumberFirstSpace() {
        // Given
        String winningNumbers = ",2,3,4,5,6";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_TYPE);
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
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }

    @Test
    @DisplayName("당첨 번호 입력 시 맨 뒤 공백 예외 발생")
    void winningNumberEndSpace() {
        // Given
        String winningNumbers = "1,2,3,,5,";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }

    @Test
    @DisplayName("당첨 번호 문자 입력 예외 발생")
    void winningNumberChar() {
        // Given
        String winningNumbers = "1,2,sdf,,5,6";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }

    @Test
    @DisplayName("보너스 번호 공백 입력 시 예외 발생")
    void bonusNumberSpace() {
        // Given
        String bonusNumber = "";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }

    @Test
    @DisplayName("둘 이상의 번호 입력 시 예외 발생")
    void bonusNumberCountOver() {
        // Given
        String bonusNumber = "3 32";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 시 예외 발생")
    void bonusNumberTypeNotNumber() {
        // Given
        String bonusNumber = "sdfe";

        // When
        // Then
        assertThatThrownBy(() -> lottoController.createBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_TYPE);
    }
}