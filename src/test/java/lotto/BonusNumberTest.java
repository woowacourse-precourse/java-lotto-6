package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("숫자가 아닌 값을 입력할 때, 예외를 발생한다")
    @Test
    void 숫자가_아닌_입력값() {
        assertThatThrownBy(() -> new BonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45이외의 값을 입력하면 예외가 발생한다.")
    @Test
    void 당첨번호_범위_테스트() {
        assertThatThrownBy(() -> new BonusNumber("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호 사이의 중복이 생기면 예외가 발생한다.")
    @Test
    void 당첨번호_보너스번호_중복_테스트() {
        //given
        String[] userWinNumbersInput = {"1", "2", "3", "4", "5", "6"};
        String userBonusNumberInput = "5";

        //when
        WinNumbers winNumbers = new WinNumbers(userWinNumbersInput);
        BonusNumber bonusNumber = new BonusNumber(userBonusNumberInput);

        //then
        assertThatThrownBy(() -> bonusNumber.
                checkDuplicationFromWinNumbers(bonusNumber.getBonusNumber(), winNumbers.getWinNumbers()))
                .isInstanceOf(IllegalStateException.class);

    }
}
