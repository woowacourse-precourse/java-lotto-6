package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Utils.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @DisplayName("당첨 로또와 현재 로또 당첨 결과 계산")
    @Test
    void matchCount() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparableLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));

        var matchCount = calculator.matchCount(winningLotto, comparableLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("로또 번호에 보너스 번호가 있는지 확인")
    @Test
    void containBonus() {
        Lotto comparableLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var bonus = 6;

        assertThat(calculator.containBonus(comparableLotto, bonus)).isTrue();
    }

    @DisplayName("로또 당첨금 결과 계산")
    @Test
    void addPrize() {
        List<Lotto> purchasedLotteries = new ArrayList<>();
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 9, 10, 11)));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        var totalPrize = 0;

        for (Lotto lotto : purchasedLotteries) {
            var rank = Rank.calculate(calculator.matchCount(lotto, winningLotto), calculator.containBonus(lotto, 13));
            calculator.addPrize(rank);
            totalPrize += Rank.getPrize(rank);
        }

        assertThat(totalPrize).isEqualTo(1555000);
    }

    @DisplayName("총 수익률 계산")
    @Test
    void calculateYield() {
        List<Lotto> purchasedLotteries = new ArrayList<>();
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 9, 10, 11)));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));

        for (Lotto lotto : purchasedLotteries) {
            var rank = Rank.calculate(calculator.matchCount(lotto, winningLotto), calculator.containBonus(lotto, 13));
            calculator.addPrize(rank);
        }
        var yieldText = calculator.calculateYield(3000);

        assertThat(yieldText).isEqualTo("51833.3");
    }
}