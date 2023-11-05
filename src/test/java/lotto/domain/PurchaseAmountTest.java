package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {
    @Test
    @DisplayName("로또 구입 금액 정상 입력")
    void receiveNormalAmountTest() {
        String amount = "2000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        assertThat(purchaseAmount.getAmount()).isEqualTo(2000);
    }

    @Test
    @DisplayName("로또 구입 금액 예외 - '\n'이 입력된 경우")
    void receiveEnterAmountTest() {
        String amount = "\n";

        assertThatThrownBy(() ->  new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 예외 - 아무것도 입력되지 않은 경우")
    void receiveEmptyAmountTest() {
        String amount = "";

        assertThatThrownBy(() ->  new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 예외 - 공백만 입력된 경우")
    void receiveSpaceAmountTest() {
        String amount = "  ";

        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 예외 - 숫자 이외의 문자가 입력된 경우")
    void receiveNotANumberAmountTest() {
        String amount = "1000a";

        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 예외 - 입력된 숫자의 단위가 1,000이 아닐 경우")
    void receiveNotDividedBy1000Test() {
        String amount = "1500";

        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액 예외 - 입력 값이 0원인 경우")
    void receiveZeroAmountTest() {
        String amount = "0";

        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
