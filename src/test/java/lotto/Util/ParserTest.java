package lotto.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    @DisplayName("유효성 검사 예외발생 테스트")
    public void exceptionTest() {
        String[] invalidInputs = {null, "", "3,24,", "1,2,3,4,5,46" ,"1,1,2,3,4,5"};

        for (String input : invalidInputs) {
            assertThatThrownBy(() -> Parser.convertStringToNumbers(input)).isInstanceOf(
                IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("입력된 숫자를 리스트로 반환하는지 테스트")
    public void convertTest() {
        String input = "1,12,23,34,40,45";
        List<Integer> expectedResult = List.of(1,12,23,34,40,45);

        assertThat(Parser.convertStringToNumbers(input)).isEqualTo(expectedResult);
    }
}
