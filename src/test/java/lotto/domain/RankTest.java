package lotto.domain;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("낙첨일 때 올바르게 객체를 생성한다.")
    public void failRankTest(int matchedCount) {
        Rank rank = Rank.of(matchedCount, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    @DisplayName("1, 4, 5등일 때 올바르게 객체를 생성한다.")
    public void rankTest(int matchedCount) {
        Map<Integer, Rank> map = Map.ofEntries(
                entry(3, Rank.FIFTH),
                entry(4, Rank.FOURTH),
                entry(6, Rank.FIRST)
        );
        Rank desiredRank = map.get(matchedCount);

        // given
        Rank actualRank = Rank.of(matchedCount, false);

        assertThat(actualRank).isEqualTo(desiredRank);
    }

    @Test
    @DisplayName("2등일 때, 정확하게 객체를 생성한다.")
    public void bonusTest() {
        final Rank second = Rank.of(5, true);
        assertThat(second).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등일 때, 정확하게 객체를 생성한다.")
    public void thirdTest() {
        final Rank third = Rank.of(5, false);
        assertThat(third).isEqualTo(Rank.THIRD);
    }

}
