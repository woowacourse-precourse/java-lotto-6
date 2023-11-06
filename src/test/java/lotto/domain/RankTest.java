package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("정상적인 경우 상황에 맞는 로또 등수를 반환")
    @ParameterizedTest(name = "맞은개수: {0}, 보너스 일치 여부: {1} => {3}")
    @MethodSource("provideGetRankNormalInputArguments")
    void getRankNormalInput(int matchCount, boolean isMatchBonus, Rank expected, String expectedRankString) {
        Rank result = Rank.getRank(matchCount, isMatchBonus);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static List<Arguments> provideGetRankNormalInputArguments() {
        return List.of(
                Arguments.of(6, false, Rank.RANK_1, Rank.RANK_1.toString()),
                Arguments.of(5, true, Rank.RANK_2, Rank.RANK_2.toString()),
                Arguments.of(5, false, Rank.RANK_3, Rank.RANK_3.toString()),
                Arguments.of(4, true, Rank.RANK_4, Rank.RANK_4.toString()),
                Arguments.of(4, false, Rank.RANK_4, Rank.RANK_4.toString()),
                Arguments.of(3, true, Rank.RANK_5, Rank.RANK_5.toString()),
                Arguments.of(3, false, Rank.RANK_5, Rank.RANK_5.toString()),
                Arguments.of(2, true, Rank.UNRANK, Rank.UNRANK.toString()),
                Arguments.of(2, false, Rank.UNRANK, Rank.UNRANK.toString()),
                Arguments.of(1, true, Rank.UNRANK, Rank.UNRANK.toString()),
                Arguments.of(1, false, Rank.UNRANK, Rank.UNRANK.toString()),
                Arguments.of(0, true, Rank.UNRANK, Rank.UNRANK.toString()),
                Arguments.of(0, false, Rank.UNRANK, Rank.UNRANK.toString())
        );
    }

    @DisplayName("비정상적인 경우 UNRANK")
    @ParameterizedTest(name = "맞은개수: {0}, 보너스 일치 여부: {1} ({2})")
    @MethodSource("provideGetRankInvalidInputArguments")
    void getRankInvalidInput(int matchCount, boolean isMatchBonus, String message) {
        Rank result = Rank.getRank(matchCount, isMatchBonus);
        Assertions.assertThat(result).isEqualTo(Rank.UNRANK);
    }

    private static List<Arguments> provideGetRankInvalidInputArguments() {
        return List.of(
                Arguments.of(7, true, "맞은 개수가 6보다 큼"),
                Arguments.of(7, false, "맞은 개수가 6보다 큼"),
                Arguments.of(6, true, "로또 번호는 총 6개인데, 6개 + 1(보너스)개 가 맞음"),
                Arguments.of(-1, true, "맞은 개수가 음수"),
                Arguments.of(-1, false, "맞은 개수가 음수")
        );
    }
}