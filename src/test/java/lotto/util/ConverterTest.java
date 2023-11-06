package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.exception.NonNumericInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @DisplayName("입력받은 String을 DELIMITER로 구분하여 List<Integer> 형태로 변환한다.")
    @Test
    public void convertStringToIntegerListByDelimiter_test() {
        // given
        String input = "1,2,3,4,5";

        // when
        List<Integer> result = Converter.convertStringToIntegerListByDelimiter(input);

        // then
        assertNotNull(result);
        assertEquals(5, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
        assertEquals(4, result.get(3));
        assertEquals(5, result.get(4));
    }

    @DisplayName("입력받은 String에 문자가 포함되어 있는 경우 예외가 발생한다.")
    @Test
    public void testConvertStringToIntegerListByDelimiterWithNonNumericInput() {
        // when
        String input = "1,2,3,abc,5";

        // then
        assertThrows(NonNumericInputException.class, () -> {
            Converter.convertStringToIntegerListByDelimiter(input);
        });
    }
}
