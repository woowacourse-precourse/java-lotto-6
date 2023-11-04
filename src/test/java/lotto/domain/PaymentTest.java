package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.LottoConstraint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PaymentTest {

    @DisplayName("로또 가격 단위에 맞지 않는 금액이면 예외가 발생한다.")
    @Test
    void createPaymentByIndivisibleAmount() {
        int indivisibleAmount = generateAmount(
                LottoConstraint.MIN_PURCHASE_QUANTITY.getValue(),
                LottoConstraint.PRICE_PER_LOTTO.getValue() / 2
        );

        assertThatThrownBy(() -> new Payment(indivisibleAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 최소 구매 수량보다 적은 금액이면 예외가 발생한다.")
    @Test
    void createPaymentByTooLittleAmount() {
        int tooLittleAmount = generateAmount(
                LottoConstraint.MIN_PURCHASE_QUANTITY.getValue() - 1,
                0
        );

        assertThatThrownBy(() -> new Payment(tooLittleAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 최대 구매 수량보다 큰 금액이면 예외가 발생한다.")
    @Test
    void createPaymentByTooMuchAmount() {
        int tooLittleAmount = generateAmount(
                LottoConstraint.MAX_PURCHASE_QUANTITY.getValue() + 1,
                0
        );

        assertThatThrownBy(() -> new Payment(tooLittleAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 금액으로 인스턴스를 생성한다.")
    @Test
    void createPaymentByValidAmount() {
        int validAmount = generateAmount(
                LottoConstraint.MIN_PURCHASE_QUANTITY.getValue(),
                0
        );

        new Payment(validAmount);
    }

    @DisplayName("구매한 로또 개수를 계산한다.")
    @Test
    void calculatePurchaseLottoCount() {
        int amount = generateAmount(
                LottoConstraint.MIN_PURCHASE_QUANTITY.getValue(),
                0
        );
        Payment payment = new Payment(amount);

        int purchaseLottoCount = payment.calculatePurchaseLottoCount();

        assertThat(purchaseLottoCount).isEqualTo(1);
    }

    private int generateAmount(int purchaseQuantity, int additionalAmount) {
        return LottoConstraint.PRICE_PER_LOTTO.getValue() * purchaseQuantity + additionalAmount;
    }
}
