package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.lottomanager.InsufficientMoneyException;
import lotto.exception.lottomanager.NonMultipleMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    LottoManager lottoManager = new LottoManager();

    @DisplayName("로또 판매 테스트")
    @Nested
    class LottoManagerSellTest {

        @DisplayName("지불한 금액이 로또 가격보다 작으면 예외가 발생한다.")
        @Test
        void sellLottoByMoneyUnderLottoPrice() {
            Money money = new Money(LottoManager.LOTTO_PRICE - 1);

            assertThatThrownBy(() -> lottoManager.sell(money))
                    .isInstanceOf(InsufficientMoneyException.class);
        }

        @DisplayName("지불한 금액이 로또 가격의 배수가 아니면 예외가 발생한다.")
        @Test
        void sellLottoByMoneyNotMultipleOfLottoPrice() {
            Money money = new Money(LottoManager.LOTTO_PRICE + 1);

            assertThatThrownBy(() -> lottoManager.sell(money))
                    .isInstanceOf(NonMultipleMoneyException.class);
        }
    }
}
