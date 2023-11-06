package lotto.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrintFormatConverterTest {

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @CsvSource(value = {
            "5000:5,000원", "50000:50,000원", "1500000:1,500,000원",
            "30000000:30,000,000원", "2000000000:2,000,000,000원"
    }, delimiter = ':')
    @DisplayName("숫자 형식 변환기: 당첨 금액을 출력 형식에 맞게 변환")
    void givenReward_whenConvertToRewardFormat_thenReturnFormattedReward(int reward, String expected) {
        // when
        String result = PrintFormatConverter.convertToRewardFormat(reward);

        // then
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @CsvSource(value = {"0:0.0", "51.5:51.5", "1000:1,000.0", "1000000.0:1,000,000.0"}, delimiter = ':')
    @DisplayName("숫자 형식 변환기: 총 수익률을 출력 형식에 맞게 변환")
    void givenYield_whenConvertToYieldFormat_thenReturnFormattedYield(double yield, String expected) {
        // when
        String result = PrintFormatConverter.convertToYieldFormat(yield);

        // then
        assertEquals(expected, result);
    }

}
