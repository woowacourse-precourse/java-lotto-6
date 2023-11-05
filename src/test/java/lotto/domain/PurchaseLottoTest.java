package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseLottoTest {

    @DisplayName("구매 개수 만큼 자동 생성 로또를 구매한다.")
    @Test
    void purchaseAutoLottoByCount() {
        //given
        final int purchaseCount = 5;

        //when
        PurchaseLotto purchaseLotto = PurchaseLotto.purchaseAutoLotto(purchaseCount);

        //then
        assertThat(purchaseLotto.getAmount()).isEqualTo(purchaseCount);
    }

    @DisplayName("구매한 로또들을 당첨 로또와 비교하여 당첨 등수를 찾는다.")
    @Test
    void findWinningRanksByWinningLotto() {
        //given
        final List<List<Integer>> purchaseLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        final List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        PurchaseLotto purchaseLotto = createPurchaseLotto(purchaseLottoNumbers);
        WinningLotto winningLotto = createWinningLottoBy(winningLottoNumbers, bonusNumber);

        //when
        List<Rank> rankResults = purchaseLotto.getWinningRankResults(winningLotto);

        //then
        assertThat(rankResults).containsExactly(
                Rank.FIRST, Rank.SECOND
        );
    }

    private PurchaseLotto createPurchaseLotto(List<List<Integer>> numbers) {
        List<Lotto> lottos = numbers.stream()
                .map(this::createLottoBy)
                .collect(Collectors.toList());
        return new PurchaseLotto(lottos);
    }

    private WinningLotto createWinningLottoBy(List<Integer> numbers, int bonusNumber) {
        Lotto winningLotto = createLottoBy(numbers);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Lotto createLottoBy(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}