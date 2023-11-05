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
        Ranking ranking = Ranking.valudOf(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("일치횟수가 5개고, 보너스 숫자와 일치하면 SECOND를 찾는다")
    @Test
    void findSecond() {
        int count = 5;
        boolean hasBonusNumber = true;
        Ranking ranking = Ranking.valudOf(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("일치횟수가 5개고, 보너스 숫자와 일치하지 않으면 THIRD를 찾는다")
    @Test
    void findThird() {
        int count = 5;
        boolean hasBonusNumber = false;
        Ranking ranking = Ranking.valudOf(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("일치횟수가 2개고, 보너스 숫자와 일치하면 Ranking에서 값을 찾을 수 없다.")
    @Test
    void findNothing() {
        int count = 2;
        boolean hasBonusNumber = true;
        Ranking ranking = Ranking.valudOf(count, hasBonusNumber);

        assertThat(ranking).isEqualTo(null);
    }

    @DisplayName("2등을 2번 한 경우의 결과 메시지 확인")
    @Test
    void checkSecondMessage() {
        String result = Ranking.SECOND.getResult(2);

        assertThat(result).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n");
    }

    @DisplayName("3등을 1번 한 경우의 결과 메시지 확인")
    @Test
    void checkThirdMessage() {
        String result = Ranking.THIRD.getResult(1);

        assertThat(result).isEqualTo("5개 일치 (1,500,000원) - 1개\n");
    }
}
