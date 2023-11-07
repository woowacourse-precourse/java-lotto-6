package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void Enum에서_열거_상수로_상금_찾기() {
        int expect = 2000000000;
        int result = Rank.findPrizeMoney(Rank.FIRST);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void Enum에서_열거_상수로_랭크_찾기() {
        int count = 6;
        boolean hasBonus = true;
        Rank expect = Rank.FIRST;
        Rank result = Rank.findRank(count, hasBonus);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void count가_5일때_SECOND_THIED_구분() {
        int sameCount = 5;
        boolean SECOND_hasBonus = true;
        boolean THIED_hasBonus = false;

        Rank SECOND_expect = Rank.SECOND;
        Rank SECOND_result = Rank.findRank(sameCount, SECOND_hasBonus);
        Rank THIED_expect = Rank.THIRD;
        Rank THIED_result = Rank.findRank(sameCount, THIED_hasBonus);

        assertThat(SECOND_result).isEqualTo(SECOND_expect);
        assertThat(THIED_result).isEqualTo(THIED_expect);
    }


}