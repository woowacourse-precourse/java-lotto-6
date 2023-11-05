package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {
    @DisplayName("입력된 당첨 번호 문자열을 쉼표로 구분된 숫자들로 변환한다.")
    @Test
    void convertToNumbersTest() {
        InputConverter converter = new InputConverter();
        List<Integer> numbers = converter.convertToWinningNumbers("1,2,3,4,5,6");
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호 입력값에 쉼표를 제외하고 숫자가 아닌 문자가 있을 경우 예외가 발생한다.")
    @Test
    void createInputContainsNonNumber() {
        InputConverter converter = new InputConverter();
        assertThatThrownBy(() -> converter.convertToWinningNumbers("1,2,3,4,5,F"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값에 공백이 있을 경우 예외가 발생한다.")
    @Test
    void createInputContainsBlank() {
        InputConverter converter = new InputConverter();
        assertThatThrownBy(() -> converter.convertToWinningNumbers("1, ,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액 또는 보너스 숫자 문자열을 숫자로 변환한다.")
    @Test
    void convertToMoneyOrBonusNumberTest() {
        InputConverter converter = new InputConverter();
        int number = converter.convertToMoneyOrBonusNumber("45");
        assertThat(number).isEqualTo(45);
    }

    @DisplayName("금액 또는 보너스 숫자 입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createInputWithNonNumber() {
        InputConverter converter = new InputConverter();
        assertThatThrownBy(() -> converter.convertToMoneyOrBonusNumber("1st"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 또는 보너스 숫자 입력값에 공백이 있을 경우 예외가 발생한다.")
    @Test
    void createInputWithBlank() {
        InputConverter converter = new InputConverter();
        assertThatThrownBy(() -> converter.convertToMoneyOrBonusNumber("1 000 0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}