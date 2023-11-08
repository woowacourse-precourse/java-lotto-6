package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;
    private Lottos lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        ));
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    void 당첨_결과_보기() {
        lottoResult.calculateWinningResult(lottos, winningNumbers, bonusNumber);
        HashMap<Rank, Integer> result = lottoResult.getResult();
        assertThat(result.get(Rank.MATCH_6)).isEqualTo(1);
        assertThat(result.get(Rank.MATCH_0)).isEqualTo(1);
    }

    @Test
    void 수익률_보기() {
        lottoResult.calculateWinningResult(lottos, winningNumbers, bonusNumber);
        String profitRate = lottoResult.calculateProfitRate(2000);
        assertThat(profitRate).isEqualTo("100,000,000.0");
    }
}
