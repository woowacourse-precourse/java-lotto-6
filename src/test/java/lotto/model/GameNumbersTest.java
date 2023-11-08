package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("7개의 번호 생성 시 당첨번호가 포함되었는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 전체번호_당첨번호_존재_확인(int number) {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        //when
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);

        //then
        assertTrue(gameNumbers.isContainWinningNumber(number));
    }

    @DisplayName("보너스 번호 추가 확인")
    @Test
    void 보너스번호_추가_확인() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        GameNumbers gameNumbers = new GameNumbers(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(7);

        //when
        gameNumbers.addBonusNumber(bonusNumber);

        //then
        assertThat(bonusNumber).isEqualTo(gameNumbers.getBonusNumber());
    }
}
