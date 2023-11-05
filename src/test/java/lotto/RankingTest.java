package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RankingTest {
    @DisplayName("일치횟수가 6개고, 보너스 숫자와 일치하면 FIRST를 찾는다")
    @Test
    void findFirst() {
        int count = 6;
        boolean hasBonusNumber = true;
        Ranking ranking = Ranking.find(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("일치횟수가 5개고, 보너스 숫자와 일치하면 SECOND를 찾는다")
    @Test
    void findSecond() {
        int count = 5;
        boolean hasBonusNumber = true;
        Ranking ranking = Ranking.find(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("일치횟수가 5개고, 보너스 숫자와 일치하지 않으면 THIRD를 찾는다")
    @Test
    void findThird() {
        int count = 5;
        boolean hasBonusNumber = false;
        Ranking ranking = Ranking.find(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("일치횟수가 2개고, 보너스 숫자와 일치하면 NONE을 찾는다")
    @Test
    void findNONE() {
        int count = 2;
        boolean hasBonusNumber = true;
        Ranking ranking = Ranking.find(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.NONE);
    }
}
