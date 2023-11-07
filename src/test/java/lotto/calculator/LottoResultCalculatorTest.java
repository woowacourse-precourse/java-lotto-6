package lotto.calculator;

import lotto.domain.Lotto;
import lotto.domain.winningnumber.WinningNumbers;
import lotto.domain.calculator.LottoResultCalculator;
import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {

    @DisplayName("로또 결과가 정확히 나오는지 계산한다.")
    @Test
    void 로또_결과_계산() {

        LottoResultCalculator resultCalculator = new LottoResultCalculator();

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),  // 5등
                new Lotto(Arrays.asList(1, 2, 10, 11, 12, 13)) // 실패
        );

        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 10);

        Map<Rank, Integer> results = resultCalculator.calculateResults(lottos, winningNumbers);

        Map<Rank, Integer> expectedResults = new EnumMap<>(Rank.class);
        expectedResults.put(Rank.FIRST, 1);
        expectedResults.put(Rank.SECOND, 1);
        expectedResults.put(Rank.THIRD, 1);
        expectedResults.put(Rank.FIFTH, 1);
        expectedResults.put(Rank.FAIL, 1);

        assertThat(results).containsExactlyInAnyOrderEntriesOf(expectedResults);
    }
}
