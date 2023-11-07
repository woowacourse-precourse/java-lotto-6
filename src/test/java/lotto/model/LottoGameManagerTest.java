package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoRanking;
import lotto.generator.RandomUniqueListGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameManagerTest {

    @DisplayName("로또 소유자와 당첨로또로 게임메니저를 생성한다.")
    @Test
    void of() {
        // given
        LottoOwner lottoOwner = getLottoOwner();
        WinningLotto winningLotto = getWinningLotto(List.of(1, 23, 4, 5, 6, 7));

        // when
        LottoGameManager result = LottoGameManager.of(lottoOwner, winningLotto);

        // then
        assertThat(result).hasFieldOrPropertyWithValue("lottoOwner", lottoOwner);
        assertThat(result).hasFieldOrPropertyWithValue("winningLotto", winningLotto);
    }

    private LottoOwner getLottoOwner() {
        PurchasePrice purchasePrice = PurchasePrice.from(1000);
        List<Lotto> randomLottos = Lotto.createRandomLottos(purchasePrice, new RandomUniqueListGenerator());
        LottoResult lottoResult = LottoResult.from(LottoRanking.convertValuesIntoCounters());
        return LottoOwner.of(purchasePrice, randomLottos, lottoResult);
    }

    private WinningLotto getWinningLotto(List<Integer> winningNumbers) {
        return WinningLotto.of(Lotto.from(winningNumbers), 2);
    }
}
