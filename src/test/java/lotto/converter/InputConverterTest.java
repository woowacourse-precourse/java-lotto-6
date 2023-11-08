package lotto.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {
    InputConverter converter = new InputConverter();

    @DisplayName("입력된 금액 문자열을 숫자로 변환한다.")
    @Test
    void convertToMoneyTest() {
        long numberLong = converter.convertToMoney("30000000000");
        assertThat(numberLong).isEqualTo(30_000_000_000L);
    }

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @Test
    void createEmptyInput() {
        assertThatThrownBy(() -> converter.convertToMoney(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createInputWithNonNumber() {
        assertThatThrownBy(() -> converter.convertToMoney("2thousands"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력값에 공백이 있을 경우 예외가 발생한다.")
    @Test
    void createInputWithBlank_Money() {
        assertThatThrownBy(() -> converter.convertToMoney("1 000 0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 당첨 번호 문자열을 쉼표로 구분된 숫자들로 변환한다.")
    @Test
    void convertToNumbersTest() {
        List<Integer> numbers = converter.convertToWinningNumbers("1,2,3,4,5,6");
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호 입력에서 쉼표 사이에 아무 값이 없으면 예외가 발생한다.")
    @Test
    void createEmptyInputBetweenComma() {
        assertThatThrownBy(() -> converter.convertToWinningNumbers("1,,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값에 쉼표를 제외하고 숫자가 아닌 문자가 있을 경우 예외가 발생한다.")
    @Test
    void createInputContainsNonNumber() {
        assertThatThrownBy(() -> converter.convertToWinningNumbers("1,2,3,4,5,F"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력값에 공백이 있을 경우 예외가 발생한다.")
    @Test
    void createInputContainsBlank() {
        assertThatThrownBy(() -> converter.convertToWinningNumbers("1, ,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 보너스 숫자 문자열을 숫자로 변환한다.")
    @Test
    void convertToMoneyOrBonusNumberTest() {
        int number = converter.convertToBonusNumber("45");
        assertThat(number).isEqualTo(45);
    }

    @DisplayName("보너스 숫자 입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createInputWithNonNumber_Bonus() {
        assertThatThrownBy(() -> converter.convertToBonusNumber("1st"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 입력값에 공백이 있을 경우 예외가 발생한다.")
    @Test
    void createInputWithBlank_Bonus() {
        assertThatThrownBy(() -> converter.convertToBonusNumber(" 43 "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}