package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @DisplayName("정상적인 로또 번호로 당첨 번호를 입력하면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideSuccessWinningNumbers")
    void determineWinningNumbersSuccessTest(List<Integer> numbers) {
        WinningLotto winningLotto = new WinningLotto();
        assertThatCode(() -> winningLotto.determineWinningNumbers(numbers))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> provideSuccessWinningNumbers() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 4, 5, 6)),
                arguments(List.of(45, 44, 43, 42, 41, 40)),
                arguments(List.of(12, 34, 6, 7, 23, 45))
        );
    }

    @DisplayName("비정상적인 로또 번호로 당첨 번호를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideFailWinningNumbers")
    void determineWinningNumbersFailTest(List<Integer> numbers) {
        WinningLotto winningLotto = new WinningLotto();
        assertThatCode(() -> winningLotto.determineWinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideFailWinningNumbers() {
        return Stream.of(
                arguments(List.of(1, 1, 3, 4, 5, 6)),
                arguments(List.of(1, 1, 3, 4, 5, 6, 7)),
                arguments(List.of(46, 44, 43, 42, 41, 40)),
                arguments(List.of(0, 34, 6, 7, 23, 45)),
                arguments(List.of(-1, 34, 6, 7, 23, 45))
        );
    }

    @DisplayName("정상적인 보너스 번호를 입력하면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void determineBonusNumberSuccessTest(int inputBonusNumber) {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.determineWinningNumbers(List.of(2, 3, 4, 5, 6, 7));
        assertThatCode(() -> winningLotto.determineBonusNumber(inputBonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 범위를 벗어난 보너스 번호를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void determineBonusNumberFailTest(int inputBonusNumber) {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.determineWinningNumbers(List.of(2, 3, 4, 5, 6, 7));
        assertThatCode(() -> winningLotto.determineBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 이미 존재하는 보너스 번호를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    void determineBonusNumberDuplicatedTest(int inputBonusNumber) {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.determineWinningNumbers(List.of(2, 3, 4, 5, 6, 7));
        assertThatCode(() -> winningLotto.determineBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또들과 당첨 번호, 보너스 번호를 비교하여 등수를 매긴다.")
    @ParameterizedTest
    @MethodSource("determineRankTest")
    void determineRankTest(Lottos purchasedLottos, List<Integer> winningNumbers, int bonusNumber,
                           List<Integer> winCounts) {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.determineWinningNumbers(winningNumbers);
        winningLotto.determineBonusNumber(bonusNumber);
        RankResult result = winningLotto.determineRank(purchasedLottos);
        Map<RankPrize, Integer> rankResult = result.getRankResult();
        assertThat(rankResult.get(RankPrize.FIRST_PLACE)).isEqualTo(winCounts.get(0));
        assertThat(rankResult.get(RankPrize.SECOND_PLACE)).isEqualTo(winCounts.get(1));
        assertThat(rankResult.get(RankPrize.THIRD_PLACE)).isEqualTo(winCounts.get(2));
        assertThat(rankResult.get(RankPrize.FOURTH_PLACE)).isEqualTo(winCounts.get(3));
        assertThat(rankResult.get(RankPrize.FIFTH_PLACE)).isEqualTo(winCounts.get(4));
    }

    static Stream<Arguments> determineRankTest() {
        return Stream.of(
                arguments(new Lottos(
                                List.of(
                                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                        new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                                        new Lotto(List.of(1, 2, 3, 7, 8, 9))
                                )
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(1, 1, 1, 1, 1)
                ),
                arguments(new Lottos(
                                List.of(
                                        new Lotto(List.of(1, 13, 17, 21, 34, 43)),
                                        new Lotto(List.of(9, 11, 17, 24, 29, 38)),
                                        new Lotto(List.of(11, 31, 34, 43, 44, 45)),
                                        new Lotto(List.of(31, 43, 34, 45, 11, 7)),
                                        new Lotto(List.of(11, 19, 31, 34, 42, 44))
                                )
                        ),
                        List.of(11, 31, 34, 43, 44, 45),
                        7,
                        List.of(1, 1, 0, 1, 0)
                )
        );
    }
}
