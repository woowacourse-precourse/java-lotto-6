package lotto.util.converter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BonusNumberConverter class의 convert 메서드 테스트")
public class BonusNumberConverterTest {
    @Test
    void 입력값이_정수일_때_문자열을_정수로_변환() {
        //given
        String validInput = "10";
        int expected = 10;

        //when
        int result = BonusNumberConverter.convertAndValidate(validInput);

        //then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "46"})
    void 입력값이_유효하지_않을_때_예외_발생(String invalidInput) {
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> BonusNumberConverter.convertAndValidate(invalidInput));
    }
}
