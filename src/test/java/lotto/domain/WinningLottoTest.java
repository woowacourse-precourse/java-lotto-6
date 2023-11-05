package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @DisplayName("구매한 로또와 비교하여 당첨 등수를 계산한다.")
    @Test
    void calculateWinningRankRankByPurchaseLotto() {
        //given
        final Rank predicateRank = Rank.SECOND;
        final List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;
        final List<Integer> purchaseLottoNumber = List.of(2, 3, 4, 5, 6, 7);

        WinningLotto winningLotto = createWinningLottoBy(winningLottoNumbers, bonusNumber);
        Lotto purchaseLotto = createLottoBy(purchaseLottoNumber);

        //when
        Rank rank = winningLotto.calcuateWinningRank(purchaseLotto);

        //then
        assertThat(rank).isEqualByComparingTo(predicateRank);
    }

    private WinningLotto createWinningLottoBy(List<Integer> numbers, int bonusNumber) {
        Lotto winningLotto = createLottoBy(numbers);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Lotto createLottoBy(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}