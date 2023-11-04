package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.utils.StringChanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("당첨 번호 입력이 숫자가 아니면 예외를 발생시킨다.") // 이외 검증은 Lotto클래스에서
    @Test
    void inputNotNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers();
        String invalidUserInput = "1,2,3,4,a,b";
        List<String> invalidInput = makeInputList(invalidUserInput);
        assertThatThrownBy(() -> winningNumbers.setFirstRankLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void inputBonusNotNumber() {
        String invalidBonusInput = "a";
        bonusNumberTest(invalidBonusInput);
    }

    @DisplayName("보너스 번호 입력이 중복되면 예외를 발생시킨다.")
    @Test
    void inputBonusDuplicated() {
        String invalidBonusInput = "1";
        bonusNumberTest(invalidBonusInput);
    }

    @DisplayName("보너스 번호 입력이 범위를 벗어나면 예외를 발생시킨다.")
    @Test
    void inputBonusOutOfRange() {
        String invalidBonusInput = "46";
        bonusNumberTest(invalidBonusInput);
    }

    private void bonusNumberTest(String bonusInput) {
        WinningNumbers winningNumbers = new WinningNumbers();
        String userInput = "1, 2, 3, 4, 5, 6 ";
        makeWinningLotto(winningNumbers, userInput);
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(bonusInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void makeWinningLotto(WinningNumbers winningNumbers, String userInput) {
        List<String> validInput = makeInputList(userInput);
        winningNumbers.setFirstRankLotto(validInput);
    }

    private List<String> makeInputList(String userInput) {
        return new ArrayList<>(StringChanger.stringToTrimmedStringList(userInput));
    }


}
