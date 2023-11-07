package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("숫자와 보너스가 일치하면 등수를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideMatchedNumberCountWithMatchBonus")
    void shouldReturnRankWhenMatchingCountWithBonus(int matchCount, boolean matchBonus, LottoRank expectedRank) {
        Optional<LottoRank> rank = LottoRank.find(matchCount, matchBonus);

        assertThat(rank).isNotNull();
        assertThat(rank.get()).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideMatchedNumberCountWithMatchBonus() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST_PRIZE),
                Arguments.of(5, true, LottoRank.SECOND_PRIZE),
                Arguments.of(5, false, LottoRank.THIRD_PRIZE),
                Arguments.of(4, false, LottoRank.FOURTH_PRIZE),
                Arguments.of(3, false, LottoRank.FIFTH_PRIZE)
        );
    }
}