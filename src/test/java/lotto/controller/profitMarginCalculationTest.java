package lotto.controller;

import lotto.lottoenum.LottoRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class profitMarginCalculationTest {

    Calculation calculation;
    @BeforeEach
    void config(){
        calculation = new profitMarginCalculation();
    }

    @DisplayName("8개중 1등 하나만 당첨되는 경우")
    @Test
    void winOnlyOneInEight(){
        List<LottoRanking> lottoRankings = new ArrayList<>(List.of(LottoRanking.FIRST, LottoRanking.DEFAULT,
                LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT
        ,LottoRanking.DEFAULT));

        Assertions.assertThat(calculation.getCalculation(lottoRankings)).isEqualTo(250000000);
    }

    @DisplayName("8개중 8개 전부 당첨되지 않는 경우")
    @Test
    void noWinInEight(){
        List<LottoRanking> lottoRankings = new ArrayList<>(List.of(LottoRanking.DEFAULT, LottoRanking.DEFAULT,
                LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT
                ,LottoRanking.DEFAULT));

        Assertions.assertThat(calculation.getCalculation(lottoRankings)).isEqualTo(0);
    }

    @DisplayName("8개중 1개는 2등 2개는 5등 나머지는 당첨되지 않는 경우")
    @Test
    void oneSecondTwoFifthLastNoInEight(){
        List<LottoRanking> lottoRankings = new ArrayList<>(List.of(LottoRanking.SECOND, LottoRanking.FIFTH,
                LottoRanking.FIFTH,LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT,LottoRanking.DEFAULT
                ,LottoRanking.DEFAULT));

        Assertions.assertThat(calculation.getCalculation(lottoRankings)).isEqualTo(30010000 / 8);
    }
}