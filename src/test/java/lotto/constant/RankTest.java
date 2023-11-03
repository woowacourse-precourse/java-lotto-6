package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @DisplayName("당첨 번호로 등수를 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("rankProvider")
    void of(int sameNumber, boolean hasBonus, Rank answer) {
        // given when
        Rank rank = Rank.of(sameNumber, hasBonus);

        // then
        assertThat(rank).isEqualTo(answer);
    }

    static Stream<Arguments> rankProvider() {
        return Stream.of(
                arguments(6, true, Rank.FIRST),
                arguments(6, false, Rank.FIRST),
                arguments(5, true, Rank.SECOND),
                arguments(5, false, Rank.THIRD),
                arguments(4, true, Rank.FOURTH),
                arguments(4, false, Rank.FOURTH),
                arguments(3, true, Rank.FIFTH),
                arguments(3, false, Rank.FIFTH),
                arguments(2, true, Rank.NONE),
                arguments(2, false, Rank.NONE),
                arguments(1, true, Rank.NONE),
                arguments(1, false, Rank.NONE),
                arguments(0, true, Rank.NONE),
                arguments(0, false, Rank.NONE)
        );
    }

}