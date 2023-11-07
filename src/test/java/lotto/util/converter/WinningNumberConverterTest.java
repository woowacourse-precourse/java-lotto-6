package lotto.util.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("WinningNumberConverter class의 convert 메서드 테스트")
public class WinningNumberConverterTest {

    static Stream<Arguments> inValidParameters() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6,"),
                Arguments.of("1,,3,4,5,6"),
                Arguments.of(",2,3,4,5,6"),
                Arguments.of("1,a,b,c,5,6")
        );
    }

    @Test
    void 입력문자열을_정수_리스트로_변환() {
        //given
        String validInput = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> result = WinningNumberConverter.convert(validInput);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("inValidParameters")
    void 입력값이_정수가_아닐_때_예외_발생(String invalidInput) {
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumberConverter.convert(invalidInput));
    }
}
