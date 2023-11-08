package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @DisplayName("로또 당첨 결과를 정확히 계산")
    @Test
    void calculateResults() {
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;
        int totalAmountSpent = 2000;

        Results results = new Results(purchasedLottos, winningLotto, bonusNumber, totalAmountSpent);

        assertThat(results.getCount(Ranking.FIRST)).isEqualTo(1);
        assertThat(results.getTotalPrize()).isGreaterThan(0);
        assertThat(results.calculateEarningsRate()).isGreaterThan(0);
    }
}
