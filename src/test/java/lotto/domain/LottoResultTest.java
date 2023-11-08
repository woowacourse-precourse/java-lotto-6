package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;
    private final Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final Lotto lottoWithFiveMatches = new Lotto(List.of(1, 2, 3, 4, 5, 10));
    private final Lotto lottoWithFourMatches = new Lotto(List.of(1, 2, 3, 4, 11, 12));
    private final Lotto lottoWithNoMatches = new Lotto(List.of(31, 32, 33, 34, 35, 36));

    @BeforeEach
    void setUp() {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);
        List<Lotto> lottos = List.of(lottoWithFiveMatches, lottoWithFourMatches, lottoWithNoMatches);
        lottoResult = new LottoResult(lottos, winningLotto);
    }

    @Test
    void countRank_forFiveMatches() {
        assertThat(lottoResult.countRank(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    void countRank_forFourMatches() {
        assertThat(lottoResult.countRank(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    void countRank_forNoMatches() {
        assertThat(lottoResult.countRank(Rank.NONE)).isEqualTo(1);
    }

    @Test
    void sumTotalPrizeMoney() {
        assertThat(lottoResult.sumTotalPrizeMoney()).isEqualTo(
                Rank.THIRD.getPrizeMoney() + Rank.FOURTH.getPrizeMoney());
    }

    @Test
    void calculateTotalPurchaseAmount() {
        assertThat(lottoResult.calculateTotalPurchaseAmount()).isEqualTo(3 * LOTTO_PRICE);
    }
}
