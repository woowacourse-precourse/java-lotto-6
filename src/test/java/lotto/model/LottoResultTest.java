package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("5등 두번 당첨 시 총 만원 반환해야한다")
    void calculatePriceTest() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lottos lottos = Lottos.of(List.of(lotto1, lotto2));
        List<Integer> winningNumbers = List.of(1, 2, 3, 40, 41, 42);
        Integer bonusNumber = 43;
        WinningNumbers winningNumber = WinningNumbers.from(winningNumbers, bonusNumber);
        // when
        LottoResult lottoResult = LottoResult.of(lottos, winningNumber);
        long price = lottoResult.calculatePrice();
        // then
        Assertions.assertThat(price).isEqualTo(10000);
    }

    @Test
    @DisplayName("5등 두번 당첨 시 총 5등 당첨 횟수는 2번이어야한다.")
    void getRankCountTest() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lottos lottos = Lottos.of(List.of(lotto1, lotto2));
        List<Integer> winningNumbers = List.of(1, 2, 3, 40, 41, 42);
        Integer bonusNumber = 43;
        WinningNumbers winningNumber = WinningNumbers.from(winningNumbers, bonusNumber);
        // when
        LottoResult lottoResult = LottoResult.of(lottos, winningNumber);
        int count = lottoResult.getRankCount(PriceMoney.FIFTH);
        // then
        Assertions.assertThat(count).isEqualTo(2);
    }
}