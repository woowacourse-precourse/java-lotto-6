package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.utils.LottoCaclulator;
import org.junit.jupiter.api.Test;

class LottoCaclulatorTest {

    @Test
    void calculateRateOfReturn는_당첨수에따른_수익률을_계산한다1() {
        //given
        List<Integer> matchNumbers = List.of(1, 0, 0, 0, 0);
        int money = 8000;
        //when
        double rateOfReturn = LottoCaclulator.calculateRateOfReturn(matchNumbers, money);
        //then
        assertThat(rateOfReturn).isEqualTo(0.625f);
    }

    @Test
    void calculateRateOfReturn는_당첨수에따른_수익률을_계산한다2() {
        //given
        List<Integer> matchNumbers = List.of(1, 1, 0, 0, 0);
        int money = 4000;
        //when
        double rateOfReturn = LottoCaclulator.calculateRateOfReturn(matchNumbers, money);
        //then
        assertThat(rateOfReturn).isEqualTo(13.75f);
    }

}