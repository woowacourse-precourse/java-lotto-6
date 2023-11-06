package lotto.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.in;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    @DisplayName("null 빈값 유효성 검사 테스트")
    public void exceptionTest() {
        String[] invalidInputs = {null, ""};

        for (String input : invalidInputs) {
            assertThatThrownBy(() -> Parser.convertStringToNumbers(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Parser.NULL_EMPTY_MESSAGE);
        }
    }

    @Test
    @DisplayName("쉼표로 구분된 6개의 숫자 유효성 검사 테스트")
    public void sixSizeTest() {
        String[] invalidInputs = {"1,2,3,4,5", "1,2,3,", "일,이,삼,사,오,육"};

        for (String input : invalidInputs) {
            assertThatThrownBy(() -> Parser.convertStringToNumbers(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Parser.INVALID_FORM_MESSAGE);
        }
    }

    @Test
    @DisplayName("중복 숫자 유효성검사 테스트")
    public void duplicateTest() {
        String duplicatedInput = "1,1,2,3,4,5";

        assertThatThrownBy(() -> Parser.convertStringToNumbers(duplicatedInput)).isInstanceOf(
        IllegalArgumentException.class).hasMessage(Parser.DUPLICATE_MESSAGE);
    }

    @Test
    @DisplayName("입력된 숫자를 리스트로 반환하는지 테스트")
    public void convertTest() {
        String input = "1,12,23,34,40,45";
        List<Integer> expectedResult = List.of(1,12,23,34,40,45);

        assertThat(Parser.convertStringToNumbers(input)).isEqualTo(expectedResult);
    }
}
