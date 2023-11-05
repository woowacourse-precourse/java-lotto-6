package lotto;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoParserTest {
    @DisplayName("숫자로 작성된 문자열을 int타입으로 변환된다.")
    @Test
    public void testValidNumberInput() {
        String validNumber = "1234";
        int result = LottoParser.readLineToNumber(validNumber);
        assertEquals(1234, result);
    }

    @DisplayName("숫자 이외의 문자열은 IllegalArgumentException으로 예외처리 된다.")
    @Test
    public void testInvalidNumberInput() {
        String invalidNumber = "willFailed";

        try {
            LottoParser.readLineToNumber(invalidNumber);
            fail("IllegalArgumentException이 발생하지 않는다");
        } catch (IllegalArgumentException e) {
            assertEquals(
                    LottoErrorMessageConstants.PURCHASE_PRICE_NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage(),
                    e.getMessage()
            );
        }
    }
}
