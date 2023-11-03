package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankingTest {

    @Test
    @DisplayName("올바른 등수를 찾는 테스트")
    void findRankingTest() {
        //given
        int three = 3;
        int four = 4;
        int five = 5;
        int six = 6;

        boolean hasBonus = true;
        boolean hasNotBonus = false;

        //when
        Ranking fifth = Ranking.findRanking(three, hasNotBonus);
        Ranking fourth = Ranking.findRanking(four, hasNotBonus);
        Ranking third = Ranking.findRanking(five, hasNotBonus);
        Ranking second = Ranking.findRanking(five, hasBonus);
        Ranking first = Ranking.findRanking(six, hasNotBonus);

        //then
        assertThat(fifth).isEqualTo(Ranking.FIFTH);
        assertThat(fourth).isEqualTo(Ranking.FOURTH);
        assertThat(third).isEqualTo(Ranking.THIRD);
        assertThat(second).isEqualTo(Ranking.SECOND);
        assertThat(first).isEqualTo(Ranking.FIRST);
    }

    @Test
    @DisplayName("당첨 결과와 횟수에 맞는 총 상금 계산 테스트")
    void multiplePrizeTest() {
        //given
        int zero = 0;
        int one = 1;
        int two = 2;

        //when
        double zero_first = Ranking.FIRST.multiplePrize(zero);
        double one_second = Ranking.SECOND.multiplePrize(one);
        double two_fourth = Ranking.FOURTH.multiplePrize(two);

        //then
        assertThat(zero_first).isEqualTo(0);
        assertThat(one_second).isEqualTo(30_000_000);
        assertThat(two_fourth).isEqualTo(100_000);
    }
}
