package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    final int ERROR_NUMBER = -1;
    Validate validate = new Validate();

    // InputPrice
    @DisplayName("입력받은 값이 숫자가 아닌경우")
    @Test
    void validateInputPrice_예외_테스트_Not_Number() {
        final String INPUT = "삼천원";

        assertThat(validate.validateInputPrice(INPUT)).isEqualTo(ERROR_NUMBER);
    }

    @DisplayName("입력 받은 값이 1000에 나누어 떨어지지 않는 경우")
    @Test
    void validateInputPrice_예외_테스트_Can_Not_Divide() {
        final String INPUT = "1300";

        assertThat(validate.validateInputPrice(INPUT)).isEqualTo(ERROR_NUMBER);
    }

    @DisplayName("입력 받은 값이 정상일 경우")
    @Test
    void validateInputPrice_메서드_정상_작동() {
        final String INPUT = "10000";
        final long RESULT = 10000;

        assertThat(validate.validateInputPrice(INPUT)).isEqualTo(RESULT);
    }

    // WinnerNumbers
    @DisplayName("입력 값에 문자가 들어왔을 경우")
    @Test
    void validateWinnerNumbers_예외_테스트_Not_Number() {
        final String INPUT = "1,2,3,4,오,6";

        assertThat(validate.validateWinnerNumbers(INPUT)).contains(ERROR_NUMBER);
    }

    @DisplayName("입력 값에 범위 밖의 숫자를 입력한 경우")
    @Test
    void validateWinnerNumbers_예외_테스트_Incorrect_Range_Number() {
        final String INPUT = "1,2,3,46,5,6";

        assertThat(validate.validateWinnerNumbers(INPUT)).contains(ERROR_NUMBER);
    }

    @DisplayName("입력 값에 중복된 숫자를 입력한 경우")
    @Test
    void validateWinnerNumbers_예외_테스트_Check_Duplicated() {
        final String INPUT = "1,2,2,4,5,6";

        assertThat(validate.validateWinnerNumbers(INPUT)).contains(ERROR_NUMBER);
    }

    @DisplayName("메서드 정상 작동")
    @Test
    void validateWinnerNumbers_메서드_정상_작동() {
        final String INPUT = "10,15, 21,29,30,42";
        List<Integer> result = List.of(10,15,21,29,30,42);

        assertThat(validate.validateWinnerNumbers(INPUT)).isEqualTo(result);
    }

    // BonusNumber
    @Test
    void validateBonusNumber_메서드_정상_작동() {
        String input = "21";
        List<Integer> list = List.of(1,4,10,15,25,40);
        int result = 21;

        assertThat(validate.validateBonusNumber(input, list)).isEqualTo(result);
    }
}
