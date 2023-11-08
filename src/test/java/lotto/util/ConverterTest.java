package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @DisplayName("상금을 세자리마다 콤마 찍어서 변환하는 기능 테스트")
    @Test
    void insertCommaToPrize() {
        long number = 100000000;
        String numberWithComma = Converter.convertPrizeToDisplayFormat(number);
        assertEquals("100,000,000", numberWithComma);
    }

    @DisplayName("수익률을 세자리마다 콤마 찍어서 변환하는 기능 테스트")
    @Test
    void insertCommaToRate() {
        float rate = 1050.5f;
        String rateWithComma = Converter.convertReturnRateToDisplayFormat(rate);
        assertEquals("1,050.5", rateWithComma);
    }

    @DisplayName("수익률이 세자리 이하일 땐 콤마를 찍지 않는다")
    @Test
    void notInsertCommaToRateWhenLengthLessThanThree() {
        float rate = 62.5f;
        String rateWithComma = Converter.convertReturnRateToDisplayFormat(rate);
        assertEquals("62.5", rateWithComma);
    }
}
