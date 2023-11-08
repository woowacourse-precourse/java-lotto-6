package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasedLottoTest {
    Lotto winningLotto;
    BonusNumber bonusNumber;

    @BeforeEach
    void setWinningLotto() {
        winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        bonusNumber = new BonusNumber(winningLotto,7);
    }

    @DisplayName("구입한 로또 당첨 결과 테스트")
    @Test
    void purchasedLottoGetWinningResultTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Lotto> lottos = List.of(lotto);
        PurchasedLotto purchasedLotto = new PurchasedLotto(lottos);

        List<Integer> result = purchasedLotto.createGamePrizeIndexValues(winningLotto, bonusNumber);

        assertThat(result).isEqualTo(List.of(0));
    }

    @DisplayName("구입한 로또 당첨 결과 테스트2")
    @Test
    void purchasedLottoGetWinningResultTest2() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lotto2 = new Lotto(List.of(1,2,3,14,15,17));
        List<Lotto> lottos = List.of(lotto, lotto2);
        PurchasedLotto purchasedLotto = new PurchasedLotto(lottos);

        List<Integer> result = purchasedLotto.createGamePrizeIndexValues(winningLotto, bonusNumber);

        assertThat(result).isEqualTo(List.of(1, 4));
    }
}
