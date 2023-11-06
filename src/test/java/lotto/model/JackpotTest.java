package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class JackpotTest {

    @DisplayName("당첨 번호와 보너스 번호를 통해 Jackpot 객체를 생성한다.")
    @Test
    void createJackpot() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "45";

        // when
        Jackpot jackpot = new Jackpot(inputWinningNumbers, inputBonusNumber);

        // then
        assertThat(jackpot)
                .extracting("winningNumbers", "bonusNumber")
                .contains(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
    }

    @DisplayName("당첨 번호가 6개로 이루어져있지 않으면 Exception 발생한다.")
    @Test
    void validateWinningNumbersSize() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6,7";
        String inputBonusNumber = "45";

        // when // then
        assertThatThrownBy(() -> new Jackpot(inputWinningNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개로 이루어져야 합니다.");
    }

    @DisplayName("당첨 번호가 숫자로 이루어져있지 않으면 Exception 발생한다.")
    @Test
    void validateNumericByWinningNumbers() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,a";
        String inputBonusNumber = "45";

        // when // then
        assertThatThrownBy(() -> new Jackpot(inputWinningNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아니라면 Exception 발생한다.")
    @Test
    void validateNumericByBonusNumber() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "a";

        // when // then
        assertThatThrownBy(() -> new Jackpot(inputWinningNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
    }
}