package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.WinLotto;
import lotto.game.Calculator;
import lotto.game.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 등수")
    @Test
    void checkLottoWin() {
        WinLotto winLotto = new WinLotto(List.of(1,2,3,4,5,6),7);
        assertThat(winLotto.calculatePrize(new Lotto(List.of(1,2,3,4,5,6)),8)).isEqualTo(LottoPrize.CORRECT_6_NUMBERS);
        assertThat(winLotto.calculatePrize(new Lotto(List.of(1,2,3,4,5,9)),7)).isEqualTo(LottoPrize.CORRECT_5_NUMBERS_WITH_BONUS);
        assertThat(winLotto.calculatePrize(new Lotto(List.of(1,2,3,4,5,9)), 8)).isEqualTo(LottoPrize.CORRECT_5_NUMBERS);
        assertThat(winLotto.calculatePrize(new Lotto(List.of(1,2,3,4,10,9)), 8)).isEqualTo(LottoPrize.CORRECT_4_NUMBERS);
        assertThat(winLotto.calculatePrize(new Lotto(List.of(1,2,3,11,10,9)), 8)).isEqualTo(LottoPrize.CORRECT_3_NUMBERS);
        assertThat(winLotto.calculatePrize(new Lotto(List.of(1,13,12,11,10,9)), 8)).isEqualTo(LottoPrize.OTHERS);
    }

    @DisplayName("로또 수익률 계산")
    @Test
    void calculateProfit() {
        int profit = 5000;
        int money = 8000;
        assertThat(Calculator.calculateProfitRate(profit, money)).isEqualTo(62.5);
    }

}