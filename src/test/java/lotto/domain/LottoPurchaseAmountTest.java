package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {

    @DisplayName("로또 구매 금액이 설정된 최소 가격보다 적거나, 설정된 최소 가격으로 나누어 떨어지지 않으면 예외를 발생한다.")
    @Test
    void buyLottoWithWrongAmountofMoney() {
        assertAll(
                () -> assertThatThrownBy(() -> LottoPurchaseAmount.valueOf(900)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoPurchaseAmount.valueOf(1100)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("아직 로또를 구매할 수 있는 금액이 남아있다면 true를, 없다면 false를 반환한다.")
    @Test
    void canBuyLotto() {
        LottoPurchaseAmount moneyLeft = LottoPurchaseAmount.valueOf(1000);

        assertThat(moneyLeft.isBuyable()).isTrue();
    }

    @DisplayName("로또구매 후 로또 하나의 가격만큼 차감한다.")
    @Test
    void subtractLottoPriceAmount() {
        LottoPurchaseAmount moneyLeft = LottoPurchaseAmount.valueOf(1000);
        moneyLeft.subtractOnePriceUnit();

        assertThat(moneyLeft.isBuyable()).isFalse();
    }
}