package lotto;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoScoreTest {
    private static Stream<Arguments> 예상로또점수_예상점수() {
        return Stream.of(
                Arguments.of(0, 0, LottoScore.NOTHING_PLACE),
                Arguments.of(0, 1, LottoScore.NOTHING_PLACE),
                Arguments.of(1, 0, LottoScore.NOTHING_PLACE),
                Arguments.of(1, 1, LottoScore.NOTHING_PLACE),
                Arguments.of(2, 0, LottoScore.NOTHING_PLACE),
                Arguments.of(2, 1, LottoScore.NOTHING_PLACE),
                Arguments.of(3, 0, LottoScore.FIFTH_PLACE),
                Arguments.of(3, 1, LottoScore.FIFTH_PLACE),
                Arguments.of(3, 0, LottoScore.FIFTH_PLACE),
                Arguments.of(3, 1, LottoScore.FIFTH_PLACE),
                Arguments.of(4, 0, LottoScore.FOURTH_PLACE),
                Arguments.of(4, 1, LottoScore.FOURTH_PLACE),
                Arguments.of(5, 0, LottoScore.THIRD_PLACE),
                Arguments.of(5, 1, LottoScore.SECOND_PLACE),
                Arguments.of(6, 0, LottoScore.FIRST_PLACE),
                Arguments.of(6, 1, LottoScore.FIRST_PLACE)
        );
    }

    @ParameterizedTest
    @MethodSource("예상로또점수_예상점수")
    void 로또점수는_예상점수에_맞게_나와야한다(int matchLottoNumberCount, int matchBonusLottoNumberCount, LottoScore expectLottoScore) {
        Assertions.assertThat(LottoScore.getMatchLottoScore(matchLottoNumberCount, matchBonusLottoNumberCount))
                .isEqualTo(expectLottoScore);
    }
}