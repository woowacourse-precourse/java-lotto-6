package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankingCounterTest {

    @DisplayName("이름별로 호출한 수 만큼 증가")
    @ParameterizedTest
    @CsvSource({"FIFTH,0,0", "FOURTH,4,4"})
    void addCount(String name, int cnt, int expected) {
        RankingCounter rankingCounter = new RankingCounter();
        for (int i = 0; i < cnt; i++) {
            rankingCounter.addCount(Ranking.valueOf(name));
        }

        Assertions.assertThat(rankingCounter.getCounter().get(name)).isEqualTo(expected);
    }

    @DisplayName("카운터 결과로 금액 합산 테스트")
    @Test
    void getPrizeMoney() {
        RankingCounter rankingCounter = new RankingCounter();
        rankingCounter.addCount(Ranking.SECOND);
        rankingCounter.addCount(Ranking.FIRST);
        rankingCounter.addCount(Ranking.FIRST);

        Assertions.assertThat(rankingCounter.getPrizeMoney()).isEqualTo(4030000000L);
    }


}
