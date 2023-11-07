package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import lotto.util.validator.WinnerLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerLottoValidatorTest {

    private final WinnerLottoValidator winnerLottoValidator = new WinnerLottoValidator() ;


    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(숫자가 아님)")
    @Test
    void validationNumericTest() {
        String input = "1,2,3,4,5,가";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(6개의 숫자가 아님)")
    @Test
    void validationInputLengthTest() {
        String input = "1,2,3,4,5,6,7";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(중복된 숫자)")
    @Test
    void validationHasDuplicateTest() {
        String input = "1,2,3,4,5,5";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(빈칸이 포함되어 있음)")
    @Test
    void validationHasBlankTest() {
        String input = "1,2,3,4, ,5";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(범위를 벗어남)")
    @Test
    void validationOutOfRangeTest() {
        String input = "1,2,3,4,5,50";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isFalse();

    }
    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(범위를 벗어남)")
    @Test
    void validationOutOfRangeTest2() {
        String input = "0,1,2,3,4,5";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력일 경우 True를 리턴")
    @Test
    void validationTest() {
        String input = "1,2,3,4,5,6";

        boolean result = winnerLottoValidator.validation(input);

        assertThat(result).isTrue();

    }

}
