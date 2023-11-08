package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LottoOrderTest {

    @DisplayName("구입 가격이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createLottoOrderByNonUnitOf1000Won() {
        // given
        final long purchasePrice = 1004;
        PurchaseLotto mockPurchaseLotto = Mockito.mock(PurchaseLotto.class);

        // when & then
        assertThatThrownBy(() -> new LottoOrder(purchasePrice, mockPurchaseLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_PRICE_UNIT.getDesc());
    }

    @DisplayName("구입 가격이 0원일 경우 예외가 발생한다.")
    @Test
    void createLottoOrderBy0Won() {
        // given
        final long purchasePrice = 0;
        PurchaseLotto mockPurchaseLotto = Mockito.mock(PurchaseLotto.class);

        // when & then
        assertThatThrownBy(() -> new LottoOrder(purchasePrice, mockPurchaseLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_PURCHASE_PRICE_UNIT.getDesc());
    }

    @DisplayName("구입 가격과 총 당첨 금액을 이용해 수익률을 계산한다.")
    @Test
    void calculateGainRatioByPurchasePriceAndTotalWinningPrice() {
        //given
        final long purchasePrice = 8000;
        final List<List<Integer>> purchaseLottoNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
        final List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;
        final double predicationGainRatio = 62.5;

        LottoOrder lottoOrder = createLottoOrder(purchasePrice, purchaseLottoNumbers);
        WinningLotto winningLotto = createWinningLottoBy(winningLottoNumbers, bonusNumber);

        //when
        double gainRatio = lottoOrder.calculateGainRatio(winningLotto);

        //then
        assertThat(gainRatio).isEqualTo(predicationGainRatio);
    }

    @DisplayName("모든 등수별 당첨 개수를 계산한다.")
    @Test
    void calculateCountByAllRank() {
        //given
        final long purchasePrice = 2000;
        final List<List<Integer>> purchaseLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        final List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        LottoOrder lottoOrder = createLottoOrder(purchasePrice, purchaseLottoNumbers);
        WinningLotto winningLotto = createWinningLottoBy(winningLottoNumbers, bonusNumber);

        //when
        List<Long> countByAllRank = lottoOrder.calculateCountByAllRank(winningLotto);

        //then
        assertThat(countByAllRank).containsExactly(0L, 0L, 0L, 1L, 1L);
    }

    private LottoOrder createLottoOrder(Long purchasePrice, List<List<Integer>> numbers) {
        PurchaseLotto purchaseLotto = createPurchaseLotto(numbers);
        return new LottoOrder(purchasePrice, purchaseLotto);
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