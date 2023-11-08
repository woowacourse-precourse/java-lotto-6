package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    @DisplayName("문자열에서 정수로 변환하는 과정에서 입력값이 숫자가 아닌 경우 예외를 던진다.")
    void parsingStringToIntWithInvalidInput() {
        // given
        String invalidInput = "abc";

        // when & then
        assertThatThrownBy(() -> Parser.stringToInteger(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구분자를 기준으로 입력값을 분리하고 정수형 리스트로 반환한다.")
    void parsingStringToIntegerListWithValidInput() {
        // given
        String validInput = "1,2,3,4,5";
        String separator = ",";
        List<Integer> expected = List.of(1, 2, 3, 4, 5);

        // when & then
        List<Integer> result = Parser.stringToIntegerListWithSplittingBySeparator(validInput, separator);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("공백이 포함된 입력값에 대해서 입력값을 분리하고 정수형 리스트로 반환한다.")
    void parsingStringToIntegerListWithSpaceInput() {
        // given
        String validInput = " 1, 2, 3 , 4 , 5 ";
        String separator = ",";
        List<Integer> expected = List.of(1, 2, 3, 4, 5);

        // when
        List<Integer> result = Parser.stringToIntegerListWithSplittingBySeparator(validInput, separator);

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("숫자가 아닌 여러개의 입력값에 대해서 ")
    void parsingStringToIntegerListWithNotIntegerInput() {
        // given
        String notIntegerInput = "a,b,c,d";
        String separator = ",";

        // when & then
        assertThatThrownBy(() -> Parser.stringToIntegerListWithSplittingBySeparator(notIntegerInput, separator))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
