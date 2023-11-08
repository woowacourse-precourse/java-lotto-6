package lotto.domain.lotto;

import lotto.service.manager.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class RankTest {
    @DisplayName("추첨 결과 맞은 숫자 개수에 따른 순위 반환: 2등 결과 테스트 제외")
    @Test
    void findRankWithoutSecondRank() {
        boolean didHitsBonusNumber = false;
        List<Integer> countForRanks = List.of(3, 4, 5, 6);

        List<Rank> expectedRanks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.FIRST);

        int size = countForRanks.size();
        for (int i = 0; i < size; i++) {
            Integer count = countForRanks.get(i);
            Rank expected = expectedRanks.get(i);

            Rank result = Rank.findRank(count, didHitsBonusNumber);
            Assertions.assertThat(result).isEqualTo(expected);
        }

        Rank secondRank = Rank.findRank(5, true);
        Assertions.assertThat(secondRank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("맞은 숫자 개수와 보너스 숫자 일치 여부에 따른 순위 반환: 2등")
    @Test
    void findRankOnlySecondRank() {
        Rank secondRank = Rank.findRank(5, true);
        Assertions.assertThat(secondRank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("추첨 결과 맞은 숫자 개수에 따른 순위 반환: 해당사항 없을 때 null 반환")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 7})
    void findRankNull(int count) {
        Rank result = Rank.findRank(count, true);
        Assertions.assertThat(result).isNull();
    }
}