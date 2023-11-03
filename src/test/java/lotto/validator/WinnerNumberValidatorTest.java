package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerNumberValidatorTest {

    @DisplayName("당첨번호 입력값에 문자가 포함되어있으면 예외처리한다")
    @Test
    void inputContainsCharacter() {
        assertThatThrownBy(() -> {
            String inputNumbers = "1,2,c,4,5,6";
            WinnerNumberValidator.validate(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 자연수가 아닌 숫자가 포함되어있으면 예외처리한다")
    @Test
    void inputContainsFloat() {
        assertThatThrownBy(() -> {
            String inputNumbers = "1,2,3,4,5,-6";
            WinnerNumberValidator.validate(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값의 길이가 6자리가 아니면 예외처리한다")
    @Test
    void wrongNumbersLength() {
        assertThatThrownBy(() -> {
            String inputNumbers = "1,2,3,4,5";
            WinnerNumberValidator.validate(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 중복된 숫자가 있으면 예외처리한다")
    @Test
    void inputHasDuplicatedNumber() {
        assertThatThrownBy(() -> {
            String inputNumbers = "1,2,3,4,5,5";
            WinnerNumberValidator.validate(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 로또번호 범위에 벗어난 숫자가 있으면 예외처리한다")
    @Test
    void inputNumbersNotInRange() {
        assertThatThrownBy(() -> {
            String inputNumbers = "1,2,3,4,5,46";
            WinnerNumberValidator.validate(inputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
