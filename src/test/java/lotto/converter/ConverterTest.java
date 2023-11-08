package lotto.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConverterTest {

    @Test
    @DisplayName("정렬 번호 컨버터: 정렬되지 않은 List<Integer>를 정렬해서 반환")
    void givenUnsortedNumbers_whenConvert_thenReturnSortedNumbers() {
        // given
        List<Integer> unsortedNumbers = List.of(6, 5, 4, 3, 2, 1);
        SortNumbersConverter sortNumbersConverter = new SortNumbersConverter();

        // when & then
        assertThat(sortNumbersConverter.convert(unsortedNumbers)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @CsvSource(value = {
            "5000:5,000원", "50000:50,000원", "1500000:1,500,000원",
            "30000000:30,000,000원", "2000000000:2,000,000,000원"
    }, delimiter = ':')
    @DisplayName("당첨 금액 컨버터: 당첨 금액을 출력 형식에 맞게 변환")
    void givenReward_whenConvert_thenReturnFormattedReward(int reward, String expected) {
        // given
        RewardFormatConverter rewardFormatConverter = new RewardFormatConverter();

        // when & then
        assertThat(rewardFormatConverter.convert(reward)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @CsvSource(value = {"0:0.0%", "51.5:51.5%", "1000:1,000.0%", "1000000.0:1,000,000.0%"}, delimiter = ':')
    @DisplayName("수익률 컨버터: 총 수익률을 출력 형식에 맞게 변환")
    void givenYield_whenConvert_thenReturnFormattedYield(double yield, String expected) {
        // given
        YieldFormatConverter yieldFormatConverter = new YieldFormatConverter();

        // when & then
        assertThat(yieldFormatConverter.convert(yield)).isEqualTo(expected);
    }

}
