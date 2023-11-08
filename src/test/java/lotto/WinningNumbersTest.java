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
        List<String> invalidInput = makeInputList("1,2,3,4,a,b");
        assertThatThrownBy(() -> new WinningNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void inputBonusNotNumber() {
        String invalidBonusInput = "a";
        invalidBonusNumberTest(invalidBonusInput);
    }

    @DisplayName("보너스 번호 입력이 당첨 번호와 중복되면 예외를 발생시킨다.")
    @Test
    void inputBonusDuplicated() {
        String invalidBonusInput = "1";
        invalidBonusNumberTest(invalidBonusInput);
    }

    @DisplayName("보너스 번호 입력이 범위를 벗어나면 예외를 발생시킨다.")
    @Test
    void inputBonusOutOfRange() {
        String invalidBonusInput = "46";
        invalidBonusNumberTest(invalidBonusInput);

        invalidBonusInput = "0";
        invalidBonusNumberTest(invalidBonusInput);
    }

    private void invalidBonusNumberTest(String invalidBonusInput) {
        List<String> validInput = makeInputList("1,2,3,4,5,6");
        WinningNumbers winningNumbers = new WinningNumbers(validInput);
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(invalidBonusInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    private List<String> makeInputList(String userInput) {
        return new ArrayList<>(StringChanger.toTrimmedStringList(userInput));
    }


}
