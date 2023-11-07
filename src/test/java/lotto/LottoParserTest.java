package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoParserTest {
    @DisplayName("숫자로 작성된 문자열을 int 로 변환된다.")
    @Test
    public void testValidNumberInput() {
        String validNumber = "1234";
        int result = LottoParser.readLineToNumber(validNumber);
        assertEquals(1234, result);
    }

    @DisplayName("숫자 이외의 문자열은 IllegalArgumentException 으로 예외처리 된다.")
    @Test
    public void testInvalidNumberInput() {
        String invalidNumber = "willFailed";

        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoParser.readLineToNumber(invalidNumber)
        );
    }

    @DisplayName("숫자와 구분자로 작성된 문자열을 List<Integer> 로 반환한다.")
    @Test
    void testValidNumbersInput() {
        String validReadLine = "1,2,3,4,5,6";

        List<Integer> numbers = LottoParser.readLineToNumbers(validReadLine);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 문자와 구분자로 작성된 문자열은 IllegalArgumentException 으로 예외처리 한다.")
    @Test
    void testInvalidNumbersInput() {
        String validReadLine = "a,b,c,d,e,f";
        assertThatIllegalArgumentException().isThrownBy(() ->
                LottoParser.readLineToNumbers(validReadLine)
        );
    }
}
