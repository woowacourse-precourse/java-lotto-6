package lotto;

import lotto.model.Lotto;
import lotto.model.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @Test
    @DisplayName("갯수 반환 테스트")
    void checkTotalRanking() {
        assertThat(Ranking.getCount(
                List.of(
                        Ranking.FORTH,
                        Ranking.FORTH,
                        Ranking.FORTH,
                        Ranking.FORTH,
                        Ranking.FIFTH,
                        Ranking.SECOND
                ), Ranking.FORTH))
                .isEqualTo(4);
    }

    @ParameterizedTest
    @MethodSource("provide_getScore_TestData")
    @DisplayName("랭킹을 제대로 리턴하는지 확인")
    void provideWinningNumber(int[] score, Ranking expectedResult) {
        assertThat(Ranking.getRank(score))
                .isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provide_getScore_TestData() {
        return Stream.of(
                Arguments.of(new int[]{6, 0}, Ranking.FIRST),
                Arguments.of(new int[]{5, 1}, Ranking.SECOND),
                Arguments.of(new int[]{5, 0}, Ranking.THIRD),
                Arguments.of(new int[]{4, 0}, Ranking.FORTH),
                Arguments.of(new int[]{3, 0}, Ranking.FIFTH),
                Arguments.of(new int[]{2, 0}, Ranking.EMPTY),
                Arguments.of(new int[]{1, 0}, Ranking.EMPTY),
                Arguments.of(new int[]{0, 1}, Ranking.EMPTY)
        );
    }
}
