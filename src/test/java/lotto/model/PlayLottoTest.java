package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PlayLottoTest {
    @DisplayName("calculateLotto 메소드 테스트")
    @Test
    void testCalculateLotto() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)));
        List<Integer> answerNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Map<LottoResult, Integer> results = PlayLotto.calculateLotto(lottos, answerNumber, bonusNumber);

        assertThat(results.get(LottoResult.THREE_MATCHES)).isEqualTo(1);
        assertThat(results.get(LottoResult.FOUR_MATCHES)).isEqualTo(1);
        assertThat(results.get(LottoResult.FIVE_MATCHES)).isEqualTo(1);
        assertThat(results.get(LottoResult.FIVE_MATCHES_WITH_BONUS)).isEqualTo(1);
        assertThat(results.get(LottoResult.SIX_MATCHES)).isEqualTo(1);
        assertThat(results.get(LottoResult.NON_WINNING)).isEqualTo(1);
    }

    @DisplayName("로또 번호와 당첨 번호 간의 일치하는 번호 수를 정확하게 계산")
    @Test
    void testGetMatchCount() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(4, 5, 6, 7, 8, 9);

        int matchCount = PlayLotto.getMatchCount(lottoNumbers, winningNumbers);
        assertThat(matchCount).isEqualTo(3);

        // 추가적인 테스트 케이스
        winningNumbers = List.of(10, 11, 12, 13, 14, 15);
        matchCount = PlayLotto.getMatchCount(lottoNumbers, winningNumbers);
        assertThat(matchCount).isEqualTo(0);
    }

    @DisplayName("매치된 숫자와 보너스 번호에 따라 적절한 로또 결과를 반환")
    @Test
    void testDetermineLottoResult() {
        assertThat(PlayLotto.determineLottoResult(6, false)).isEqualTo(LottoResult.SIX_MATCHES);
        assertThat(PlayLotto.determineLottoResult(5, true)).isEqualTo(LottoResult.FIVE_MATCHES_WITH_BONUS);
        assertThat(PlayLotto.determineLottoResult(5, false)).isEqualTo(LottoResult.FIVE_MATCHES);
        assertThat(PlayLotto.determineLottoResult(4, false)).isEqualTo(LottoResult.FOUR_MATCHES);
        assertThat(PlayLotto.determineLottoResult(3, false)).isEqualTo(LottoResult.THREE_MATCHES);
        assertThat(PlayLotto.determineLottoResult(2, false)).isEqualTo(LottoResult.NON_WINNING);
    }

    @DisplayName("로또 매치 결과와 구매 금액을 바탕으로 수익률을 계산")
    @Test
    void testCalculateIncome() {
        Map<LottoResult, Integer> matchCounts = new EnumMap<>(LottoResult.class);
        matchCounts.put(LottoResult.THREE_MATCHES, 1);
        matchCounts.put(LottoResult.FOUR_MATCHES, 1);
        matchCounts.put(LottoResult.FIVE_MATCHES, 1);
        int purchaseAmount = 3000;

        double income = PlayLotto.calculateIncome(matchCounts, purchaseAmount);
        double expectedIncome = (5_000 + 50_000 + 1_500_000) / 3000.0 * 100;
        assertThat(income).isEqualTo(expectedIncome);
    }
}
