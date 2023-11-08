package domain;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.caclulator.MatchCalculator;
import lotto.domain.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

public class MatchCalculatorTest {

    @ParameterizedTest
    @DisplayName("복권 Match 테스트")
    @MethodSource("provideLottoAndWinningNumbers")
    void CalculateMatchCountAndBonusMatch(Lotto userLotto, WinningNumbers winningNumbers,
            int expectedMatchCount, boolean expectedBonusMatch) {
        int matchCount = MatchCalculator.calculateMatchCount(userLotto, winningNumbers);
        boolean isBonusMatched = MatchCalculator.isBonusNumberMatched(userLotto, winningNumbers);

        assertThat(matchCount).isEqualTo(expectedMatchCount);
        assertThat(isBonusMatched).isEqualTo(expectedBonusMatch);
    }

    private static Stream<Arguments> provideLottoAndWinningNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7), 6, false),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 7, 8)), 5), 4, true),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 13), 0, false)
        );
    }
}