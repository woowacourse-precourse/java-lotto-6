package lotto.domain;

import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    @DisplayName("당첨 순위와 일치하는 순위를 반환한다.")
    @ParameterizedTest
    @MethodSource("findByMatchCountAndBonusProvider")
    void findByMatchCountAndBonus(int matchCount, boolean bonus, Rank expected) {
        Rank rank = Rank.findByMatchCountAndBonus(matchCount, bonus);

        Assertions.assertThat(rank).isEqualTo(expected);
    }

    static Stream<Arguments> findByMatchCountAndBonusProvider() {
        return Stream.of(
                Arguments.of(6, true, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(3, true, Rank.FIFTH)
        );
    }

    @DisplayName("새로운 정답 시트를 생성한다.")
    @Test
    void createNewSheet() {
        Map<Rank, Integer> newSheet = Rank.createNewSheet();

        int sum = newSheet.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        Assertions.assertThat(sum).isEqualTo(0);
    }
}