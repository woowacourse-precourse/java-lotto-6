package lotto.util;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void 입력_로또번호들_문자열_숫자로_변환_테스트() {
        // given
        String testInput = "1,2,3,4,5,6";
        String testInput2 = "7, 8, 9, 10, 11, 12";

        // when
        List<Integer> converted1 = Converter.convertStringToIntegers(testInput);
        List<Integer> converted2 = Converter.convertStringToIntegers(testInput2);

        // then
        assertEquals(6, converted1.size());
        assertEquals(6, converted2.size());

        assertThat(converted1).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(converted2).containsExactly(7, 8, 9, 10, 11, 12);
    }

    @Test
    void 입력_단일_로또_번호를_숫자로_변환_테스트() {
        // given
        String testNum = "12";
        String testNum2 = "8";
        String testNum3 = "aabb";
        String testNum4 = "1234";

        // when
        int converted1 = Converter.convertValidLottoNumber(testNum);
        int converted2 = Converter.convertValidLottoNumber(testNum2);

        // then
        assertEquals(12, converted1);
        assertEquals(8, converted2);
        assertThatThrownBy(() -> Converter.convertValidLottoNumber(testNum3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_A_NUMBER_TO_CONVERT.getMessage());

        assertThatThrownBy(() -> Converter.convertValidLottoNumber(testNum4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_WITHIN_SCOPE_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 입력_구매금액_문자열을_숫자로_변환_테스트() {
        // given
        String testInput1 = "14000";
        String testInput2 = "8000";
        String testInput3 = "1111";
        String testInput4 = "-2000";

        // when
        int converted1 = Converter.convertValidUserBuyAmount(testInput1);
        int converted2 = Converter.convertValidUserBuyAmount(testInput2);

        // then
        assertEquals(14000, converted1);
        assertEquals(8000, converted2);
        assertThatThrownBy(() -> Converter.convertValidUserBuyAmount(testInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BUY_AMOUNT_1000_WON_UNIT.getMessage());

        assertThatThrownBy(() -> Converter.convertValidUserBuyAmount(testInput4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());

    }

    @Test
    void 정수를_포맷문자열로_변환_테스트() {
        // given
        long testNum = 123456;
        long testNum2 = 123456789;

        // when
        String result1 = Converter.convertNumberFormatString(testNum);
        String result2 = Converter.convertNumberFormatString(testNum2);

        // then
        assertEquals("123,456", result1);
        assertEquals("123,456,789", result2);
    }

    @Test
    void 실수를_소수점_한자리까지_포맷문자열로_변환_테스트() {
        // given
        double testNum = 100.123;
        double testNum2 = 10000000.789;

        // when
        String result = Converter.convertNumberFormatString(testNum);
        String result2 = Converter.convertNumberFormatString(testNum2);

        // then
        assertEquals("100.1", result);
        assertEquals("10,000,000.8", result2);
    }
}