package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningAmount;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto secondRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
    Lotto fourthRankLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
    Lotto fifthRankLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
    Lotto noRankLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

    @Test
    @DisplayName("purchaseLotto 메서드가 적절한 반환값을 반환한다.")
    void purchaseLotto() {
        Assertions.assertThat(LottoService.purchaseLotto(1000).size()).isEqualTo(1);
        Assertions.assertThat(LottoService.purchaseLotto(2000).size()).isEqualTo(2);
        Assertions.assertThat(LottoService.purchaseLotto(3000).size()).isEqualTo(3);
        Assertions.assertThat(LottoService.purchaseLotto(101000).size()).isEqualTo(101);
    }

    @Test
    @DisplayName("getRankOfLotto 메서드가 적절한 반환값을 반환한다.")
    void getRankOfLotto() {
        Assertions.assertThat(LottoService.getRankOfLotto(firstRankLotto, winningLotto)).isEqualTo(1);
        Assertions.assertThat(LottoService.getRankOfLotto(secondRankLotto, winningLotto)).isEqualTo(2);
        Assertions.assertThat(LottoService.getRankOfLotto(thirdRankLotto, winningLotto)).isEqualTo(3);
        Assertions.assertThat(LottoService.getRankOfLotto(fourthRankLotto, winningLotto)).isEqualTo(4);
        Assertions.assertThat(LottoService.getRankOfLotto(fifthRankLotto, winningLotto)).isEqualTo(5);
        Assertions.assertThat(LottoService.getRankOfLotto(noRankLotto, winningLotto)).isEqualTo(0);
    }

    @Test
    @DisplayName("rankToAmount 메서드가 적절한 반환값을 반환한다.")
    void rankToAmount() {
        Assertions.assertThat(LottoService.rankToAmount(1)).isEqualTo(WinningAmount.FIRST.getValue());
        Assertions.assertThat(LottoService.rankToAmount(2)).isEqualTo(WinningAmount.SECOND.getValue());
        Assertions.assertThat(LottoService.rankToAmount(3)).isEqualTo(WinningAmount.THIRD.getValue());
        Assertions.assertThat(LottoService.rankToAmount(4)).isEqualTo(WinningAmount.FOURTH.getValue());
        Assertions.assertThat(LottoService.rankToAmount(5)).isEqualTo(WinningAmount.FIFTH.getValue());
        Assertions.assertThat(LottoService.rankToAmount(0)).isEqualTo(WinningAmount.DEFAULT.getValue());
    }

    @Test
    @DisplayName("winningRate 메서드가 적절한 반환값을 반환한다.")
    void winningRate() {
        Assertions.assertThat(LottoService.winningRate(1000, 5000)).isEqualTo(5);
        Assertions.assertThat(LottoService.winningRate(1000, 0)).isEqualTo(0);
        Assertions.assertThat(LottoService.winningRate(1000, 1000)).isEqualTo(1);
    }
}