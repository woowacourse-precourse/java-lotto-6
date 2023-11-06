package lotto;

import model.Purchase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasePriceTest {

    @Test
    void 구매금액입력(){
        Purchase purchase = new Purchase();
        purchase.Number(14000);
        int result = purchase.getPurchaseCount();
        assertThat(result).isEqualTo(14);
    }
}
