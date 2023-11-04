package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCounterTest {
    @DisplayName("생성자 호출시 모든 값이 0으로 초기화 된다.")
    @Test
    void initTest() {
        RankCounter rankCounter = new RankCounter();
        Arrays.stream(Rank.values())
                .forEach(rank -> assertCountZero(rankCounter, rank));
    }

    private void assertCountZero(RankCounter rankCounter, Rank rank) {
        assertThat(rankCounter.get(rank)).isEqualTo(0);
    }

    @DisplayName("count 메소드 호출시 값이 증가한다.")
    @Test
    void countRankTest() {
        RankCounter rankCounter = new RankCounter();
        int before = rankCounter.get(Rank.FIRST);
        rankCounter.increaseCount(Rank.FIRST);
        int after = rankCounter.get(Rank.FIRST);
        assertThat(after).isEqualTo(before + 1);
    }

    @DisplayName("불변성이 보장된다.")
    @Test
    void changeValueButConstant() {
        RankCounter rankCounter = new RankCounter();
        int countNumber = rankCounter.get(Rank.FIRST);
        rankCounter.increaseCount(Rank.FIRST);
        assertThat(countNumber).isEqualTo(0);
    }
}
