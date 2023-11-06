package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.PurchasePrice;
import lotto.util.InputTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest extends InputTest {
    @DisplayName("로또 구입 금액이 양의 1000의 배수가 아니면 재입력한다.")
    @Test
    void inputPriceUntilNumber() {
        run("string", "", null, " ", "0", "-1000", "12", "1000");
    }

    void compare() {
        PurchasePrice actual = inputPurchasePrice();
        PurchasePrice expected = PurchasePrice.from(1000);
        assertThat(actual).isEqualTo(expected);
    }

    @Override
    protected void runMethod() {
        compare();
    }
}
