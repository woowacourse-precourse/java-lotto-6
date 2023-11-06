package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceTest {


    @DisplayName("구입 금액을 생성한다.")
    @Test
    public void purchaseNumber() {
        int price = 1000;
        PurchasePrice purchasePrice = new PurchasePrice(price);
        assertThat(purchasePrice.getPrice()).isEqualTo(price);
    }


    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    public void purchaseNumberUnit() {
        assertThatThrownBy(
            () -> {
                int price = 3200;
                PurchasePrice purchasePrice = new PurchasePrice(price);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    public void purchaseNumberUnder1000() {
        assertThatThrownBy(
            () -> {
                int price = 300;
                PurchasePrice purchasePrice = new PurchasePrice(price);
            }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
