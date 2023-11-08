package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.Rank;
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
        EnumMap<Rank, Integer> result = rankCounter.getCountResult();
        assertThat(result.get(rank)).isEqualTo(0);
    }

    @DisplayName("count 메소드 호출시 값이 증가한다.")
    @Test
    void countRankTest() {
        //given
        RankCounter rankCounter = new RankCounter();
        EnumMap<Rank, Integer> before = rankCounter.getCountResult();
        int count = before.get(Rank.FIRST);

        //when
        rankCounter.increaseCount(Rank.FIRST);

        //then
        EnumMap<Rank, Integer> after = rankCounter.getCountResult();
        assertThat(after.get(Rank.FIRST)).isEqualTo(count + 1);
    }

    @DisplayName("불변성이 보장된다.")
    @Test
    void changeValueButConstant() {
        //given
        RankCounter rankCounter = new RankCounter();
        EnumMap<Rank, Integer> result = rankCounter.getCountResult();
        int count = result.get(Rank.FIRST);

        //when
        rankCounter.increaseCount(Rank.FIRST);

        //then
        assertThat(count).isEqualTo(0);
    }
}
