package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1-45 범위를 넘어가는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotInRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액만큼 로또를 구매하고 생성된 로또의 개수가 맞는지 확인한다.")
    @Test
    void purchaseLottosTest() {
        LottoMachine lottoMachine = new LottoMachine();
        int purchaseAmount = 10000;
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(purchaseAmount / 1000);
    }

    @DisplayName("주어진 로또가 어떤 등수인지 확인한다.")
    @Test
    void checkRankTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winning = new WinningLotto(winningLotto, 7);
        LottoRank rank = winning.checkRank(lotto);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusNumberOutOfRangeTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplicateWithWinningNumberTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}