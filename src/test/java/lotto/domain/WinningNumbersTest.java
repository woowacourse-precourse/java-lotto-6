package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    @DisplayName("당첨 금액 객체 입력값대로 생성되는지 테스트")
    @Test
    void validateWinningNumberCreate() {
        String test = "1,2,3,4,5,6";
        List<Integer> expectedResult  = List.of(1,2,3,4,5,6);

        WinningNumbers winningNumbers = new WinningNumbers(test);
        List<Integer> actualResult = winningNumbers.getWinningNumbers();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("보너스 점수 정상적으로 저장되는지 테스트")
    @Test
    void validateBonusNumberStore() {
        String test = "1,2,3,4,5,6";
        int expectedResult = 44;
        WinningNumbers winningNumbers = new WinningNumbers(test);
        winningNumbers.setBonusNumber(expectedResult);
        int actualResult = winningNumbers.getBonusNumber();
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
