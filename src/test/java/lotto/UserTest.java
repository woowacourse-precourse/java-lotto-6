package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constans.ErrorMessage;
import lotto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐경우 예외발생")
    void inputWantBuyAmountFail() {
        // given
        User user = new User();
        String wantBuyInput = "500";

        // when
        // then
        assertThatThrownBy(() -> user.inputWantBuyAmount(wantBuyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WANT_BUY_AMOUNT_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 10만원을 초과할 경우 예외발생")
    void inputWantBuyAmountOverRange() {
        // given
        User user = new User();
        String wantBuyInput = "1000000";

        // when
        // then
        assertThatThrownBy(() -> user.inputWantBuyAmount(wantBuyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WANT_BUY_AMOUNT_OVER_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위일 경우 int 값으로 반환")
    void inputWantBuyAmount() {
        // given
        User user = new User();
        String wantBuyInput = "5000";

        // when
        int inputWantBuyAmount = user.inputWantBuyAmount(wantBuyInput);

        // then
        Assertions.assertEquals(inputWantBuyAmount, Integer.parseInt(wantBuyInput));

    }

    @Test
    @DisplayName("당첨번호가 1~45 범위가 아닐경우 예외 발생")
    void inputWinningNumberOverRange() {
        // given
        User user = new User();
        String winningNumber = "1,2,3,4,5,50";

        // when
        // then
        assertThatThrownBy(() -> user.inputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("당첨번호가 6자리보다 적을경우 예외 발생")
    void inputWinningNumberUnderSize() {
        // given
        User user = new User();
        String winningNumber = "1,2,3,4,5";

        // when
        // then
        assertThatThrownBy(() -> user.inputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("당첨번호가 6자리보다 많을경우 예외 발생")
    void inputWinningNumberOverSize() {
        // given
        User user = new User();
        String winningNumber = "1,2,3,4,5,6,7";

        // when
        // then
        assertThatThrownBy(() -> user.inputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("당첨번호에 숫자 외의 문자 입력시 예외 발생")
    void inputWinningNumberNotNumber() {
        // given
        User user = new User();
        String winningNumber = "1,2,3,4,a";

        // when
        // then
        assertThatThrownBy(() -> user.inputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨번호에 중복된 숫자 입력시 예외 발생")
    void inputWinningNumberIsDuplicated() {
        // given
        User user = new User();
        String winningNumber = "1,2,3,4,5,1";

        // when
        // then
        assertThatThrownBy(() -> user.inputWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_DUPLICATED_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("올바른 당첨번호 입력시 리스트로 반환")
    void inputWinningNumber() {
        // given
        User user = new User();
        String winningNumberInput = "1,2,3,4,5,6";

        // when
        List<Integer> winningNumber = user.inputWinningNumber(winningNumberInput);

        // then
        Assertions.assertEquals(winningNumber.size(), 6);
        for (int i = 0; i < 6; i++) {
            Assertions.assertEquals(winningNumber.get(i), i + 1);
        }

    }

    @Test
    @DisplayName("보너스 번호에 숫자 외의 문자 입력시 예외발생")
    void bonusNumberNotNumber() {
        // given
        User user = new User();
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        String bonusNumberInput = "a";

        // when
        // then
        assertThatThrownBy(() -> user.inputBonusNumber(bonusNumberInput,winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.IS_NOT_NUMBER.getMessage());

    }

    @Test
    @DisplayName("보너스 번호에 1~45 외의 숫자 입력시 예외발생")
    void bonusNumberOverRange() {
        // given
        User user = new User();
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        String bonusNumberInput = "46";

        // when
        // then
        assertThatThrownBy(() -> user.inputBonusNumber(bonusNumberInput, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());

    }

    @Test
    @DisplayName("보너스 번호에 당첨번호와 중복된 수 입력시 예외발생")
    void bonusNumberContainWinningNumber() {
        // given
        User user = new User();
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        String bonusNumberInput = "1";

        // when
        // then
        assertThatThrownBy(() -> user.inputBonusNumber(bonusNumberInput,winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IS_CONTAIN_WINNING_NUMBER.getMessage());

    }

    @Test
    @DisplayName("조건에 맞는 보너스 번호 입력시 Int 값 반환")
    void bonusNumberInput() {
        // given
        User user = new User();
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        String bonusNumberInput = "10";

        // when
        int bonusNumber = user.inputBonusNumber(bonusNumberInput, winningNumber);

        // then
        Assertions.assertEquals(bonusNumber,Integer.parseInt(bonusNumberInput));

    }

}
