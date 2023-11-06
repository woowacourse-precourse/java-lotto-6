package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("각 등수별 정보를 가진 메시지를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideWinCountsAndMessage")
    void shouldCreateMessageWithEachLottoRank(LottoRank rank, String expectedMessage, int winCount) {
        String message = rank.getMessage(winCount);
        assertThat(message).isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> provideWinCountsAndMessage() {
        return Stream.of(
                Arguments.of(LottoRank.FIRST_PRIZE, "6개 일치 (2,000,000,000원) - 1개", 1),
                Arguments.of(LottoRank.SECOND_PRIZE, "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개", 2),
                Arguments.of(LottoRank.THIRD_PRIZE, "5개 일치 (1,500,000원) - 3개", 3),
                Arguments.of(LottoRank.FOURTH_PRIZE, "4개 일치 (50,000원) - 4개", 4),
                Arguments.of(LottoRank.FIFTH_PRIZE, "3개 일치 (5,000원) - 5개", 5)
        );
    }

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