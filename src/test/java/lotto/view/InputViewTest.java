package lotto.view;

import lotto.view.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class InputViewTest {
    private final String ERROR_PHRASES = "[ERROR]";
    @DisplayName("로또 구매 입력값이 없을 경우 예외 처리")
    @Test
    void emptyMoneyInput() {
        //given
        InputView inputView = new InputView();

        //when
        String moneyInput = "";

        //then
        assertThatThrownBy(() -> inputView.validateCustomerMoneyInput(moneyInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_MONEY.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("로또 구매 입력값이 숫자가 아닐 경우 예외 처리")
    @Test
    void validateDigitMoneyInput() {
        //given
        InputView inputView = new InputView();

        //when
        String englishInMoney = "100a";
        String koreanInMoney = "100ㅁ";
        String specialSignInMoney = "100%";

        //then
        assertThatThrownBy(() -> inputView.validateCustomerMoneyInput(englishInMoney))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_MONEY.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);

        assertThatThrownBy(() -> inputView.validateCustomerMoneyInput(koreanInMoney))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_MONEY.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);

        assertThatThrownBy(() -> inputView.validateCustomerMoneyInput(specialSignInMoney))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_MONEY.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("올바른 로또 구매 입력값 처리")
    @Test
    void parseMoneyInput() {
        //given
        InputView inputView = new InputView();

        //when
        String moneyInput = "1000";
        long money = inputView.validateCustomerMoneyInput(moneyInput);

        //then
        long expectedMoney = 1000;
        assertThat(money).isEqualTo(expectedMoney);
    }

    @DisplayName("당첨 번호 입력값이 없을 경우 예외 처리")
    @Test
    void emptyWinningNumbers() {
        //given
        InputView inputView = new InputView();

        //when
        String winningNumberInput = "";

        //then
        assertThatThrownBy(() -> inputView.validateWinningNumberInput(winningNumberInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_WINNING_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("당첨 번호 입력값이 숫자가 아닌 경우 예외 처리")
    @Test
    void winningNumberNotDigit() {
        //given
        InputView inputView = new InputView();

        //when
        String winningNumbersInput = "1,2,3,4,5,a";

        //then
        assertThatThrownBy(() -> inputView.validateWinningNumberInput(winningNumbersInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_WINNING_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("올바른 당첨 번호 처리")
    @Test
    void parseWinningNumber() {
        //given
        InputView inputView = new InputView();

        //when
        String winningNumberInput = "1,2,3,4,5,6";
        List<Integer> winningNumber= inputView.validateWinningNumberInput(winningNumberInput);

        //then
        List<Integer> expectedWinningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber.size()).isEqualTo(6);
        assertThat(winningNumber).isEqualTo(expectedWinningNumber);
    }

    @DisplayName("보너스 번호 입력값이 없을 경우 예외 처리")
    @Test
    void emptyBonusNumberInput(){
        //given
        InputView inputView = new InputView();

        //when
        String bonusNumberInput = "";

        //then
        assertThatThrownBy(() -> inputView.validateBonusNumberInput(bonusNumberInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_BONUS_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("보너스 번호 입력값이 숫자가 아닐 경우 예외 처리")
    @Test
    void validateDigitBonusNumber() {
        //given
        InputView inputView = new InputView();

        //when
        String englishInBonusNumber = "a";
        String koreanInBonusNumber = "ㅁ";
        String specialSignInBonusNumber = "%";

        //then
        assertThatThrownBy(() -> inputView.validateBonusNumberInput(englishInBonusNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_BONUS_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);

        assertThatThrownBy(() -> inputView.validateBonusNumberInput(koreanInBonusNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_BONUS_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);

        assertThatThrownBy(() -> inputView.validateBonusNumberInput(specialSignInBonusNumber))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ErrorMessage.NOT_DIGIT_BONUS_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("올바른 보너스 번호 입력값 처리")
    @Test
    void parseBonusNumber() {
        //given
        InputView inputView = new InputView();

        //when
        String bonusNumberInput = "45";
        int bonusNumber = inputView.validateBonusNumberInput(bonusNumberInput);

        //then
        int expectedBonusNumber = 45;
        assertThat(bonusNumber).isEqualTo(expectedBonusNumber);
    }
}
