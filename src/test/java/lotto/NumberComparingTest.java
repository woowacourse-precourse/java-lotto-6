package lotto;

import lotto.LottoEnum.Prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberComparingTest {
    @ParameterizedTest
    @MethodSource("getNumberOfMatchTestArguments")
    @DisplayName("getNumberOfMatchTest")
    public void getNumberOfMatchTest(List<Integer> lottoNumbers, int answer) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusWinningNumber = 7;

        NumberComparing numberComparing = new NumberComparing(winningNumbers, bonusWinningNumber);

        int result = numberComparing.getNumberOfMatch(new Lotto(lottoNumbers));

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> getNumberOfMatchTestArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 5),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(List.of(1, 2, 3, 34, 35, 7), 3),
                Arguments.of(List.of(1, 2, 33, 34, 35, 37), 2),
                Arguments.of(List.of(1, 12, 13, 14, 15, 17), 1),
                Arguments.of(List.of(10, 20, 30, 34, 35, 37), 0),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), 3)
        );
    }


    @ParameterizedTest
    @MethodSource("isMatchBonusWinningNumberTestArguments")
    @DisplayName("isMatchBonusWinningNumberTest")
    public void isMatchBonusWinningNumberTest(List<Integer> lottoNumbers, Boolean answer) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusWinningNumber = 7;

        NumberComparing numberComparing = new NumberComparing(winningNumbers, bonusWinningNumber);

        Boolean result = numberComparing.isMatchBonusWinningNumber(new Lotto(lottoNumbers));

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> isMatchBonusWinningNumberTestArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), false),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), true),
                Arguments.of(List.of(1, 2, 3, 34, 35, 7), true),
                Arguments.of(List.of(1, 2, 33, 34, 35, 37), false),
                Arguments.of(List.of(1, 12, 13, 14, 15, 17), false),
                Arguments.of(List.of(10, 20, 30, 34, 35, 37), false),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), true)
        );
    }

    @ParameterizedTest
    @MethodSource("getPrizeResultTestArguments")
    @DisplayName("getPrizeResultTest")
    public void getPrizeResultTest(List<Integer> lottoNumbers, Prize answer) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusWinningNumber = 7;

        NumberComparing numberComparing = new NumberComparing(winningNumbers, bonusWinningNumber);

        int numberOfMatch = numberComparing.getNumberOfMatch(new Lotto(lottoNumbers));
        Boolean isMatchBonusWinningNumber = numberComparing.isMatchBonusWinningNumber(new Lotto(lottoNumbers));

        Prize result = numberComparing.getPrizeResult(numberOfMatch, isMatchBonusWinningNumber);

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> getPrizeResultTestArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Prize.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), Prize.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), Prize.FOURTH),
                Arguments.of(List.of(1, 2, 3, 34, 35, 7), Prize.FIFTH),
                Arguments.of(List.of(1, 2, 33, 34, 35, 37), Prize.LOSE),
                Arguments.of(List.of(1, 12, 13, 14, 15, 17), Prize.LOSE),
                Arguments.of(List.of(10, 20, 30, 34, 35, 37), Prize.LOSE),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), Prize.FIFTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getPrizeResultsTestArguments")
    @DisplayName("getPrizeResultsTest")
    public void getPrizeResultsTest(List<Integer> lottoNumbersOne, List<Integer> lottoNumbersTwo, List<Prize> answer) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusWinningNumber = 7;

        NumberComparing numberComparing = new NumberComparing(winningNumbers, bonusWinningNumber);

        List<Lotto> lottos = List.of(new Lotto(lottoNumbersOne), new Lotto(lottoNumbersTwo));

        List<Prize> result = numberComparing.getPrizeResults(lottos);

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> getPrizeResultsTestArguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 8), List.of(Prize.SECOND, Prize.THIRD)),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), List.of(1, 2, 3, 34, 35, 7), List.of(Prize.FOURTH, Prize.FIFTH)),
                Arguments.of(List.of(1, 2, 33, 34, 35, 37), List.of(1, 12, 13, 14, 15, 17), List.of(Prize.LOSE, Prize.LOSE)),
                Arguments.of(List.of(10, 20, 30, 34, 35, 37), List.of(4, 5, 6, 7, 8, 9), List.of(Prize.LOSE, Prize.FIFTH))
        );
    }
}
