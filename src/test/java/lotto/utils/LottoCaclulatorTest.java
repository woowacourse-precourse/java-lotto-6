package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

class LottoCaclulatorTest {

    @Test
    void calculateRateOfReturn는_당첨수에따른_수익률을_계산한다1() {
        //given
        HashMap<LottoRank, Integer> winningCount = new HashMap<>();
        winningCount.put(LottoRank.FIFTH, 1);
        int money = 8000;
        //when
        double rateOfReturn = LottoCaclulator.calculateRateOfReturn(winningCount, money);
        //then
        assertThat(rateOfReturn).isEqualTo(0.625f);
    }

    @Test
    void calculateRateOfReturn는_당첨수에따른_수익률을_계산한다2() {
        //given
        HashMap<LottoRank, Integer> winningCount = new HashMap<>();
        winningCount.put(LottoRank.FIFTH, 1);
        winningCount.put(LottoRank.FOURTH, 1);
        int money = 4000;
        //when
        double rateOfReturn = LottoCaclulator.calculateRateOfReturn(winningCount, money);
        //then
        assertThat(rateOfReturn).isEqualTo(13.75f);
    }

}