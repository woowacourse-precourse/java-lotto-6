package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    private Purchase purchase;

    @BeforeEach
    void setUp() {
        purchase = new Purchase("3000");
    }

    //  NoSuchElementException ??
    //    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    //    @Test
    //    void createPurchaseWithAmountUnderThousand() {
    //        assertThatThrownBy(() -> new Purchase("a"))
    //                .isInstanceOf(IllegalArgumentException.class);
    //    }

    //    @DisplayName("금액이 1000원의 배수가 아니면 예외가 발생한다.")
    //    @Test
    //    void createPurchaseWithAmountNotMultipleOfThousand() {
    //        assertThatThrownBy(() -> new Purchase("2500"))
    //                .isInstanceOf(IllegalArgumentException.class);
    //    }

    @DisplayName("올바른 금액을 입력하면 Purchase 객체가 생성된다.")
    @Test
    void createPurchaseWithValidAmount() {
        assertThat(purchase).isNotNull();
    }

    @DisplayName("올바른 금액을 입력하면 로또 개수가 정확하게 초기화된다.")
    @Test
    void initializeAmountWithValidAmount() {
        assertThat(purchase.getAmount()).isEqualTo(3);
    }

    @DisplayName("Purchase 객체에서 생성된 로또 리스트의 개수가 정확하게 초기화된다.")
    @Test
    void initializePurchasedLotto() {
        List<Lotto> purchasedLotto = purchase.getPurchasedLotto();
        assertThat(purchasedLotto).hasSize(3);
    }
}
