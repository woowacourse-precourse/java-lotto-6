package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseLottoTest {

    @DisplayName("구매 개수 만큼 자동 생성 로또를 구매한다.")
    @Test
    void purchaseAutoLottoByCount() {
        //given
        final long lottoCount = 5;

        //when
        PurchaseLotto purchaseLotto = PurchaseLotto.purchaseAutoLotto(lottoCount);

        //then
        assertThat(purchaseLotto.getPurchaseCount()).isEqualTo(lottoCount);
    }

    @DisplayName("구매한 로또들의 총 당첨 상금을 계산한다.")
    @Test
    void calculateTotalWinningPriceByWinningLotto() {
        //given
        final List<List<Integer>> purchaseLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        final List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;
        final long predicationTotalWinningPrice = Rank.FIRST.getWinningPrice() + Rank.SECOND.getWinningPrice();

        PurchaseLotto purchaseLotto = createPurchaseLotto(purchaseLottoNumbers);
        WinningLotto winningLotto = createWinningLottoBy(winningLottoNumbers, bonusNumber);

        //when
        long totalWinningPrice = purchaseLotto.calculateTotalWinningPrice(winningLotto);

        //then
        assertThat(totalWinningPrice).isEqualTo(predicationTotalWinningPrice);
    }

    @DisplayName("구매한 로또들의 당첨 등수별 개수를 계산한다.")
    @Test
    void calculateCountByWinningRank() {
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
        Map<Rank, Long> countByWinningRank = purchaseLotto.calculateCountByWinningRank(winningLotto);

        //then
        assertThat(countByWinningRank)
                .isNotEmpty()
                .containsKeys(Rank.FIRST, Rank.SECOND)
                .contains(
                        entry(Rank.FIRST, 1L),
                        entry(Rank.SECOND, 1L)
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