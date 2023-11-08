package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class WinningStatisticsTest {
    @DisplayName("정상적으로 총 수익률이 출력되는지 확인")
    @Test
    void createSuccessStatisticPercentage() {
        int amount = 8000;
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("8, 21, 23, 41, 42, 43"));
            add(new Lotto("3, 5, 11, 16, 32, 38"));
            add(new Lotto("7, 11, 16, 35, 36, 44"));
            add(new Lotto("1, 8, 11, 31, 41, 42"));
            add(new Lotto("13, 14, 16, 38, 42, 45"));
            add(new Lotto("7, 11, 30, 40, 42, 43"));
            add(new Lotto("2, 13, 22, 32, 38, 45"));
            add(new Lotto("1, 3, 5, 14, 22, 45"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;

        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateNumberOfWins(lottos, lotto, bonus);
        assertThat(winningStatistics.calculateRateOfReturn(amount)).isEqualTo("62.5");
    }
    @DisplayName("정상적으로 등수 개수가 출력되는지 확인")
    @Test
    void createOrderSuccess() {
        List<Lotto> lottos = new ArrayList<>(){
            {
                add(new Lotto("1,2,3,4,5,6"));
                add(new Lotto("1,2,3,4,5,7"));
                add(new Lotto("1,2,3,4,5,8"));
                add(new Lotto("1,2,3,4,9,10"));
                add(new Lotto("1,2,3,8,9,10"));
            }
        };
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        HashMap<Rank, Integer> result = new HashMap<>() {{
            put(Rank.FIRST_PRIZE, 1);
            put(Rank.SECOND_PRIZE, 1);
            put(Rank.THIRD_PRIZE, 1);
            put(Rank.FOURTH_PRIZE, 1);
            put(Rank.FIFTH_PRIZE, 1);
            put(Rank.BLANK, 0);
        }};

        WinningStatistics winningStatistics =new WinningStatistics();
        winningStatistics.calculateNumberOfWins(lottos,lotto,bonus);
        Assertions.assertThat(winningStatistics.getWinningHistory()).isEqualTo(result);
    }

}