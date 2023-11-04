package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    private static Stream<Arguments> provideLottoRankTestCases() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(2, true, LottoRank.MISS),
                Arguments.of(1, true, LottoRank.MISS),
                Arguments.of(0, true, LottoRank.MISS)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 통계 테스트")
    @MethodSource("provideLottoRankTestCases")
    void invalidInputsTest7(int match, boolean hasBonusNumber, LottoRank expectedLottoRank) {
        LottoRank actualRank = LottoRank.getRank(match, hasBonusNumber);
        assertThat(actualRank).isEqualTo(expectedLottoRank);
    }
}