package lotto.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertorTest {

    @DisplayName("문자열을 int로 반환한다.")
    @Test
    void convertStringToInt() {
        // given
        String input = "01000";

        // when
        Object result = Convertor.convertStringToInt(input);

        // then
        assertTrue(result instanceof Integer);
    }

    @DisplayName("문자열을 Long으로 반환한다.")
    @Test
    void convertStringToLong() {
        // given
        String input = "10000000000";

        // when
        Object result = Convertor.convertStringToLong(input);

        // then
        assertTrue(result instanceof Long);
    }

    @DisplayName("쉼표로 구분된 문자열을 List<Intger>로 반환한다.")
    @Test
    void convertStringToIntegerList() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Object result = Convertor.convertStringToIntegerList(input);

        // then
        assertTrue(result instanceof List);
        ((List<?>) result).stream()
                .forEach(item -> assertTrue(item instanceof Integer));
    }

    @DisplayName("쉼표로 문자열을 분리해 배열로 반환한다.")
    @Test
    void splitByComma() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        Object result = Convertor.splitByComma(input);

        // then
        assertTrue(result instanceof String[]);
    }
}