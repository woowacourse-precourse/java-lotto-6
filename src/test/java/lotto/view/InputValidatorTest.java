package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("입력을 ,단위로 파싱해서 ArrayList 형태로 반환한다.")
    @Test
    void validateNumberParsing() {
        ArrayList<Integer> expectResult = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        String input = "1,2,3,4,5,6";

        ArrayList<Integer> actualResult = InputValidator.validateAndParseNumbersInput(input);

        assertThat(actualResult).isEqualTo(expectResult);
    }


    @DisplayName("입력에 숫자가 아닌 문자가 포함되어 있을 경우 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4000a", "5000  ", "d"})
    void inputWithNonNumericCharacters(String input) {
        assertThatThrownBy(() ->
                        InputValidator.validateAndParseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 숫자가 아닌 문자가 포함되어 있거나 숫자가 너무 큽니다.");
    }

    @DisplayName("입력이 정수 자료형의 최대 값 보다 클 경우 에러를 발생한다")
    @Test
    void inputGreaterThanMaxIntValue() {
        assertThatThrownBy(() ->
                        InputValidator.validateAndParseInput("2222222222"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 숫자가 아닌 문자가 포함되어 있거나 숫자가 너무 큽니다.");
    }
}