package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchCheckerTest {
    @Test
    @DisplayName("당첨 번호와 비교하여 로또 등수를 매기는 테스트")
    void getResult_ShouldReturnCorrectRankCount() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<LottoRank, Integer> result = getLottoRankIntegerMap(winningNumbers);
        
        assertThat(result.get(LottoRank.NONE)).isEqualTo(1);
        assertThat(result.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
    }

    private static Map<LottoRank, Integer> getLottoRankIntegerMap(List<Integer> winningNumbers) {
        int bonusNumber = 7;
        LottoMatchChecker lottoMatchChecker = new LottoMatchChecker(winningNumbers, bonusNumber);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)), // NO WIN
                new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)),  // FIFTH
                new Lotto(Arrays.asList(1, 2, 3, 4, 15, 16)),   // FOURTH
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 17)),    // THIRD
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),     // SECOND
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))      // FIRST
        );

        return lottoMatchChecker.getResult(lottos);
    }
}
