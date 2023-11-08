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
}
