package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("유효한 로또 번호로 생성되어야 함")
    public void testValidLottoNumberCreation(int number) {
        assertDoesNotThrow(() -> new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("유효하지 않은 로또 번호로 생성 시 예외가 발생해야 함")
    public void testInvalidLottoNumberCreation(int number) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new LottoNumber(number));
        assertEquals("[ERROR] 로또 입력 값은 1이상 45이하의 값만 가능합니다.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 20})
    @DisplayName("로또 번호의 동등성 비교")
    public void testLottoNumberEquality(int number) {
        LottoNumber number1 = new LottoNumber(number);
        LottoNumber number2 = new LottoNumber(number);
        LottoNumber differentNumber = new LottoNumber(number + 5);

        assertEquals(number1, number2);
        assertNotEquals(number1, differentNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 20})
    @DisplayName("로또 번호의 비교 (정렬)")
    public void testLottoNumberComparison(int number) {
        LottoNumber number1 = new LottoNumber(number - 5);
        LottoNumber number2 = new LottoNumber(number);
        LottoNumber number3 = new LottoNumber(number);

        assertTrue(number1.compareTo(number2) < 0);
        assertEquals(0, number2.compareTo(number3));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 30})
    @DisplayName("로또 번호의 문자열 표현")
    public void testLottoNumberToString(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertEquals(String.valueOf(number), lottoNumber.toString());
    }
}