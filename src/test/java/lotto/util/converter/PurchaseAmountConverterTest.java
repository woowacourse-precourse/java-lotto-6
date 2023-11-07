package lotto.util.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseAmountConverter class의 convert 메서드 테스트")
public class PurchaseAmountConverterTest {

    @Test
    void 입력값이_정수일_때_문자열을_정수로_변환() {
        //given
        String validInput = "1000";
        int expected = 1000;

        //when
        int result = PurchaseAmountConverter.convert(validInput);

        //then
        assertEquals(expected, result);
    }

    @Test
    void 입력값이_정수가_아닐_때_예외_발생() {
        //given
        String invalidInput = "abc";

        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> PurchaseAmountConverter.convert(invalidInput));
    }
}
