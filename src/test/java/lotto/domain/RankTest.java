package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("매치 개수와 보너스 번호 여부로 Rank 객체를 생성한다.")
    @ParameterizedTest
    @MethodSource("createRankFixture")
    void valueOf(int matchCount, boolean isBonus, Rank expected) {
        // given & when
        Rank rank = Rank.valueOf(matchCount, isBonus);

        // then
        assertThat(rank).isEqualTo(expected);
    }

    private static Stream<Arguments> createRankFixture() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(0, false, Rank.MISS)
        );
    }
}
