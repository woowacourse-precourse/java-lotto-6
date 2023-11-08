package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.util.format.LottoFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("형식 지정 유틸리티")
public class LottoFormatTest {
    @ParameterizedTest(name = "원본 : {0}, 변환 : {1}")
    @CsvSource(value = {"100:100", "1000:1,000", "10000:10,000", "100000:100,000",
            "1000000:1,000,000"}, delimiter = ':')
    @DisplayName("가격 형식은 세 자리수 마다 콤마를 넣는다.")
    void Should_Thousands_Comma_When_Price_Format(final int price, final String expected) {
        //when
        final String actual = LottoFormat.PRICE.getFormat().format(price);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "원본 : {0}, 변환 : {1}")
    @CsvSource(value = {"0.625,62.5%", "0.001, 0.1%", "0.9,90.0%", "0.5752,57.5%", "0.4356,43.6%"})
    @DisplayName("수익률은 두번째 소수점에서 반올림하는 퍼센트 형식으로 변환한다.")
    void Should_Percentage_Rounded_At_Two_Point_When_Earning_Rate_Format(
            final double earningRate,
            final String expected
    ) {
        //when
        final String actual = LottoFormat.EARNING_RATE.getFormat().format(earningRate);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
