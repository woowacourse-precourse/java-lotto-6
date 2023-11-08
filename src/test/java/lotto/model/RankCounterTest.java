package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankCounterTest {
    @DisplayName("통계 결과를 올바르게 뽑아내는지 테스트")
    @Test
    void toStringTest() {
        Integer numberOfLottos = 10;
        List<Rank> ranks = List.of(Rank.THIRD, Rank.SECOND);
        RankCounter rankCounter = new RankCounter(ranks);

        String expected = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n";

        Assertions.assertThat(rankCounter.toString()).isEqualTo(expected);
    }
    @DisplayName("이익률을 올바르게 계산하는지 테스트한다.")
    @Test
    void computeBenefit() {
        Integer numberOfLottos = 10;
        List<Rank> ranks = List.of(Rank.THIRD, Rank.SECOND);
        RankCounter rankCounter = new RankCounter(ranks);

        Double benefit = rankCounter.computeBenefit(numberOfLottos);
        Assertions.assertThat(benefit).isEqualTo(315000.0);
    }
}