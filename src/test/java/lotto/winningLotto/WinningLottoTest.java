package lotto.winningLotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import lotto.domain.enumerate.NumberType;
import lotto.domain.validator.WinningNumberValidator;
import lotto.message.ConsoleMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {


    @DisplayName("당첨 번호는 숫자만 가능하다.")
    @Test
    void createLottoWithAlphabet() {
        String winningNum = "1,3,4,5,a,6";
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 6자리 수만 가능하다.")
    @Test
    void createLottoOver7Numbers() {
        String winningNum = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNum))
                .hasMessage(ConsoleMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호는 1-45 수만 가능 하다. - 46이상")
    @Test
    void createLottoWithMaxNum() {
        String winningNum = "111,222,333,444,5555,666";
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNum))
                .hasMessage(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호는 1-45 수만 가능 하다. - 0이하")
    @Test
    void createLottoWithMinNum() {
        String winningNum = "0,1,2,3,4,5";
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNum))
                .hasMessage(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }


    @DisplayName("당첨 번호는 중복될 수 없다.")
    @Test
    void createLottoByDuplicate() {
        String winningNum = "1,2,3,4,5,5";
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumber(winningNum))
                .hasMessage(ConsoleMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호는 1-45자리 숫자 여야 한다.")
    @Test
    void createBonusNumber() {
        assertThatThrownBy(() -> WinningNumber.of(46, NumberType.BONUS))
                .hasMessage(ConsoleMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoWithBonusByDuplicatedNumber() {
        List<Integer> winningNumWithoutBonus = List.of(1, 2, 3, 4, 5);
        List<WinningNumber> winningNumbers =
                winningNumWithoutBonus.stream().map(num -> WinningNumber.of(num, NumberType.ORIGINAL)).toList();

        WinningNumber bonusNumber = WinningNumber.of(5, NumberType.BONUS);

        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
