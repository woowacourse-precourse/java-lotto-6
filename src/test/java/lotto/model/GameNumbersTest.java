package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameNumbersTest {

    @DisplayName("당첨번호와 중복된 보너스 번호가 들어오면 예외가 발생한다.")
    @Test
    void 보너스번호_중복_예외_처리() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(4);

        //when, then
        assertThatThrownBy(() -> gameNumbers.addBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.getErrorMessage());
    }

}
