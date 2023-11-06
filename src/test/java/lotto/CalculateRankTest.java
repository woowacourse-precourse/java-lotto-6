package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.WinningLotto;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculateRankTest {
    public static final List<Integer> ANSWER_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    public static final BonusNumber ANSWER_BONUS_NUMBER = new BonusNumber(7);
    private final WinningLotto answerLotto = new WinningLotto(new Lotto(ANSWER_NUMBERS),  ANSWER_BONUS_NUMBER);

    @DisplayName("로또 번호와 당첨 번호를 비교하여 1~5 등수를 계산한다.")
    @ParameterizedTest
    @MethodSource("calculateRankProvider")
    void calculateRankTest(Lotto trialLotto, Rank targetRank) {
        Assertions.assertThat(answerLotto.calculateLottoRank(trialLotto))
                .isEqualTo(targetRank);
    }

    static Stream<Arguments> calculateRankProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 35, 7)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 33)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 45, 23)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(7, 2, 3, 4, 45, 23)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 34, 13, 44)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 7, 34, 13, 44)), Rank.FIFTH)
        );
    }

    @DisplayName("일치하는 등수가 없는 경우 No_RANK 이다.")
    @ParameterizedTest
    @MethodSource("calculateNoRankProvider")
    void calculateNoRankTest(Lotto trialLotto, Rank targetRank) {
        Assertions.assertThat(answerLotto.calculateLottoRank(trialLotto))
                .isEqualTo(targetRank);

    }

    static Stream<Arguments> calculateNoRankProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 11, 23, 36, 24)), Rank.NO_RANK),
                Arguments.of(new Lotto(List.of(1, 40, 11, 23, 36, 24)), Rank.NO_RANK),
                Arguments.of(new Lotto(List.of(24, 31, 11, 23, 36, 19)), Rank.NO_RANK)
        );
    }
}
