package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentTest {

    @DisplayName("로또 가격 단위에 맞지 않는 금액이면 예외가 발생한다.")
    @Test
    void createPaymentByIndivisibleAmount() {
        int indivisibleAmount = generateAmount(Constants.MIN_PURCHASE_QUANTITY, Constants.LOTTO_PRICE / 2);

        assertThatThrownBy(() -> new Payment(indivisibleAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 최소 구매 수량보다 적은 금액이면 예외가 발생한다.")
    @Test
    void createPaymentByTooLittleAmount() {
        int tooLittleAmount = generateAmount(Constants.MIN_PURCHASE_QUANTITY - 1, 0);

        assertThatThrownBy(() -> new Payment(tooLittleAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 최대 구매 수량보다 큰 금액이면 예외가 발생한다.")
    @Test
    void createPaymentByTooMuchAmount() {
        int tooLittleAmount = generateAmount(Constants.MAX_PURCHASE_QUANTITY + 1, 0);

        assertThatThrownBy(() -> new Payment(tooLittleAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 금액으로 인스턴스를 생성한다.")
    @Test
    void createPaymentByValidAmount() {
        int validAmount = generateAmount(Constants.MIN_PURCHASE_QUANTITY, 0);

        new Payment(validAmount);
    }

    @DisplayName("구매한 로또 개수를 계산한다.")
    @Test
    void calculatePurchaseLottoCount() {
        int amount = generateAmount(Constants.MIN_PURCHASE_QUANTITY, 0);
        Payment payment = new Payment(amount);

        int purchaseLottoCount = payment.calculatePurchaseLottoCount();

        assertThat(purchaseLottoCount).isEqualTo(1);
    }

    private int generateAmount(int purchaseQuantity, int additionalAmount) {
        return Constants.LOTTO_PRICE * purchaseQuantity + additionalAmount;
    }
}