package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("총 수익률 객체에 대해")
class TotalRateTest {

    @Test
    @DisplayName("총 수익률을 계산한다.")
    void Given_CreateTotalRate_When_LottoPrice8000AndWinningSum5000_Then_GetRate() {
        //given
        TotalRate totalRate = new TotalRate();

        //when
        totalRate.calculateRate(8000, 5000);
        Double rate = totalRate.getRate();

        //then
        assertThat(rate).isEqualTo(62.5);
    }

}
