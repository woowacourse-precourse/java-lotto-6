package lotto;

import lotto.Domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchasePriceTest {
    @DisplayName("정수가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void createInputNotInteger() {
        assertThatThrownBy(() -> Parser.parsePurchaseAmount("f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수를 입력할 경우 예외가 발생한다.")
    @Test
    void createNotDivisibleBy1000() {
        assertThatThrownBy(() -> new PurchasePrice(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로만 구매할 수 있습니다.\n");
    }

    @DisplayName("금액을 입력할 경우 정확한 복권 개수를 도출하는 지 테스트")
    @Test
    void findLottoAmount() {
        PurchasePrice purchasePrice = new PurchasePrice(54000);
        assertThat(purchasePrice.findLottoQuantity())
                .isEqualTo(54);
    }
}
