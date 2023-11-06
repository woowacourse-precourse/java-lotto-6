package lotto;

import lotto.model.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class PurchaseTest {

    @DisplayName("구입 금액에 0을 입력한 경우")
    @Test
    void createPurchaseZero() {
        assertThatThrownBy(() -> new Purchase("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자가 아닌 다른 문자를 입력한 경우")
    @Test
    void createPurchaseNotNumber() {
        assertThatThrownBy(() -> new Purchase("ayoung"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우")
    @Test
    void createPurchaseNoDivide1000() {
        assertThatThrownBy(() -> new Purchase("21024"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
