package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoCaclulatorTest {

    @Test
    void calculateRateOfReturn는_당첨수에따른_수익률을_계산한다1() {
        //given
        List<MatchNumber> matchNumbers = List.of(
                MatchNumber.FIFTH,
                MatchNumber.NOTHING,
                MatchNumber.NOTHING,
                MatchNumber.NOTHING,
                MatchNumber.NOTHING,
                MatchNumber.NOTHING);
        int money = 8000;
        //when
        float rateOfReturn = LottoCaclulator.calculateRateOfReturn(matchNumbers, money);
        //then
        assertThat(rateOfReturn).isEqualTo(0.625f);
    }

    @Test
    void calculateRateOfReturn는_당첨수에따른_수익률을_계산한다2() {
        //given
        List<MatchNumber> matchNumbers = List.of(
                MatchNumber.NOTHING,
                MatchNumber.FIFTH,
                MatchNumber.FOURTH,
                MatchNumber.NOTHING,
                MatchNumber.NOTHING,
                MatchNumber.NOTHING);
        int money = 4000;
        //when
        float rateOfReturn = LottoCaclulator.calculateRateOfReturn(matchNumbers, money);
        //then
        assertThat(rateOfReturn).isEqualTo(13.75f);
    }

}