package lotto.handler;

import lotto.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void beforeEach() {
        this.inputHandler = new InputHandler();
    }

    @DisplayName("로또 구입 금액 검증 통과 테스트")
    @Test
    void handlePurchaseAmount() {
        assertThat(inputHandler.handlePurchaseAmount("1000")).isEqualTo(1);
    }

    @DisplayName("로또 구입 금액 입력값이 아닐때 예외 발생")
    @Test
    void handleStringPurchaseAmountTest() {
        assertThatThrownBy(() -> inputHandler.handlePurchaseAmount("fail"))
                .isInstanceOf(ParseException.class);
    }

    @DisplayName("로또 구입 금액 입력값이 공백일때 예외 발생")
    @Test
    void handleBlankLPurchaseAmountTest() {
        assertThatThrownBy(() -> inputHandler.handlePurchaseAmount(""))
                .isInstanceOf(NullInputException.class);
    }

    @DisplayName("로또 구입 금액 입력값이 1000원으로 나누어지지 않을때 예외 발생")
    @Test
    void handleNegativePurchaseAmountTest() {
        assertThatThrownBy(() -> inputHandler.handlePurchaseAmount("1001"))
                .isInstanceOf(InvalidPurchaseAmountException.class);
    }

    @DisplayName("당첨 번호 검증 통과 테스트")
    @Test
    void handleWinningNumbersTest() {
        assertThat(inputHandler.handleWinningNumbers("1,2,3,4,5,6").size())
                .isEqualTo(6);
    }

    @DisplayName("당첨 번호 입력값이 공백일때 예외 발생")
    @Test
    void handleBlankWinningNumbersTest() {
        assertThatThrownBy(() -> inputHandler.handleWinningNumbers(""))
                .isInstanceOf(NullInputException.class);
    }

    @DisplayName("당첨 번호 입력값이 숫자가 아닐때 예외 발생")
    @Test
    void handleStringWinningNumbersTest() {
        assertThatThrownBy(() -> inputHandler.handleWinningNumbers("a,b,c,d,e,f,g"))
                .isInstanceOf(ParseException.class);
    }

    @DisplayName("당첨 번호 입력값이 유효한 값이 아닐때 예외 발생")
    @Test
    void handleInvalidWinningNumbersTest() {
        assertThatThrownBy(() -> inputHandler.handleWinningNumbers("-1,-2,-3,-4,-5,-6"))
                .isInstanceOf(InvalidNumberException.class);
    }

    @DisplayName("당첨 번호중 중복값이 있을때 예외 발생")
    @Test
    void handleDuplicateWinningNumbersTest() {
        assertThatThrownBy(() -> inputHandler.handleWinningNumbers("1, 1, 1, 1, 1, 1"))
                .isInstanceOf(InvalidWinningNumbersException.class);
    }

    @DisplayName("당첨 번호가 6개가 아닐때 예외 발생")
    @Test
    void handleNotSixWinningNumbersTest() {
        assertThatThrownBy(() -> inputHandler.handleWinningNumbers("1, 2, 3, 4, 5"))
                .isInstanceOf(InvalidWinningNumbersException.class);
    }

    @DisplayName("보너스 번호 검증 성공 테스트")
    @Test
    void handleBonusNumberSuccessTest() {
        assertThat(inputHandler.handleBonusNumber("10", List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(10);
    }

    @DisplayName("보너스 번호 입력값이 공백일때 예외 발생")
    @Test
    void handleBlankBonusNumberTest() {
        assertThatThrownBy(() -> inputHandler.handleBonusNumber("", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(NullInputException.class);
    }

    @DisplayName("보너스 번호 입력값이 숫자가 아닐때 예외 발생")
    @Test
    void handleStringBonusNumberTest() {
        assertThatThrownBy(() -> inputHandler.handleBonusNumber("hi", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(ParseException.class);
    }

    @DisplayName("보너스 번호 입력값이 유효한값이 아닐때 예외 발생")
    @Test
    void handleInvalidBonusNumberTest() {
        assertThatThrownBy(() -> inputHandler.handleBonusNumber("50", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(InvalidNumberException.class);
    }

    @DisplayName("보너스 번호 입력값이 당첨번호에 포함될때 예외 발생")
    @Test
    void handleBonusNumberInWinningNumberTest() {
        assertThatThrownBy(() -> inputHandler.handleBonusNumber("1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(InvalidBonusNumberException.class);
    }
}