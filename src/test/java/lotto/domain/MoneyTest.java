package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.system.LottoRankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("1000원으로 나누어 떨어지지 않을 때 예외가 발생한다.")
    @Test
    void createMoneyByNotDivisible() {
        assertThatThrownBy(() -> Money.from(12060))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("충분한 돈이 없을 경우 예외가 발생한다.")
    @Test
    void createMoneyByNotEnough() {
        assertThatThrownBy(() -> Money.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 개수")
    @Test
    void countPurchased() {
        assertThat(Money.from(7000).countPurchase())
                .isEqualTo(7);
    }

    @DisplayName("총 수익률")
    @Test
    void totalProfit() {
        assertThat(Money.from(2000).getProfitMarginAsFormat(WinningStats.of(PurchasedLottos.of(List.of(
                        Lotto.of(List.of(1, 2, 3, 4, 11, 12)),
                        Lotto.of(List.of(11, 12, 1, 2, 3, 4)))),
                WinningNumbersWithBonus.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), Ball.from(7)))))
                .isEqualTo((double) (LottoRankConstant.FOURTH_PRIZE.getPrize() * 2) / 2000 * 100);
    }
}
