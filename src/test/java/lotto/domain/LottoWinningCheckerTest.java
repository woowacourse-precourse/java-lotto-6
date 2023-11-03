package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class LottoWinningCheckerTest {
    LottoWinningChecker lottoWinningChecker;

    static Stream<Arguments> lottoMatchTestArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(8, 9, 10, 11, 12, 7), LottoRank.NONE),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 14, 15, 7), LottoRank.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 15, 7), LottoRank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 16), LottoRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, List.of(1, 2, 3, 4, 5, 6), LottoRank.FIRST)
        );
    }

    @DisplayName("당첨 번호와 비교 결과 테스트")
    @ParameterizedTest(name = "{index} => 당첨번호: {0}, 보너스번호: {1}, 로또번호: {2}, 기대되는 순위: {3}")
    @MethodSource("lottoMatchTestArguments")
    void getMatchCount(List<Integer> winningNumber, int bonusNumber, List<Integer> lottoNumbers, LottoRank expectedRank) {
        lottoWinningChecker = new LottoWinningChecker(winningNumber, bonusNumber);
        LottoRank lottoRank = lottoWinningChecker.getRank(new Lotto(lottoNumbers));
        assertThat(lottoRank).isEqualTo(expectedRank);
    }
}
