package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankCounterTest {

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