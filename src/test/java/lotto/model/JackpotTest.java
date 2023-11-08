package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("당첨 번호에 중복된 숫자가 있다면 Exception 발생한다.")
    @Test
    void validateDuplicateNumbers() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,5";
        String inputBonusNumber = "6";

        // when // then
        assertThatThrownBy(() -> new Jackpot(inputWinningNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호에 중복된 숫자가 들어갈 수 없습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 Exception 발생한다.")
    @Test
    void validateDuplicateBonusNumber() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "1";

        // when // then
        assertThatThrownBy(() -> new Jackpot(inputWinningNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("당첨 번호가 1 보다 작은 숫자인 경우 Exception 발생한다. ")
    @Test
    void validateNumberInRange1() {
        // given

        // when // then
        assertThatThrownBy(() -> new Jackpot("0,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호/보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 45 보다 큰 숫자인 경우 Exception 발생한다. ")
    @Test
    void validateNumberInRange2() {
        // given

        // when // then
        assertThatThrownBy(() -> new Jackpot("1,2,3,4,5,46", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호/보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1 보다 작은 숫자인 경우 Exception 발생한다. ")
    @Test
    void validateNumberInRange3() {
        // given

        // when // then
        assertThatThrownBy(() -> new Jackpot("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호/보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 45 보다 큰 숫자인 경우 Exception 발생한다. ")
    @Test
    void validateNumberInRange4() {
        // given

        // when // then
        assertThatThrownBy(() -> new Jackpot("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호/보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
    }
}