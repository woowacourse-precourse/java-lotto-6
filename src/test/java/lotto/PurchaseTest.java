package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PurchaseTest {
    @Test
    @DisplayName("Purchase 생성")
    void createPurchase() {
        String purchaseInput = "2000";
        Purchase purchase = new Purchase(purchaseInput);

        assertThat(purchase.getPurchaseAmount()).isEqualTo(2);
        assertThat(purchase.getMyLotto().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("금액 입력이 숫자가 아닌 경우")
    void validatePurchaseInput() {
        String purchaseInput = "not_a_number";

        assertThatThrownBy(() -> new Purchase(purchaseInput))
            .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("로또 번호 생성")
    void generateNumber() {
        Purchase purchase = new Purchase("5000");

        List<Integer> numbers = purchase.generateNumber();

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }
}
