package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseNumberTest {

    @DisplayName("구입 번호를 생성한다.")
    @Test
    public void purchaseNumber() {
        PurchaseNumber purchaseNumber = new PurchaseNumber(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))
        );
        assertThat(purchaseNumber.getNumbersValue()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("구입 번호가 6글자가 아니면 예외가 발생한다.")
    @Test
    public void purchaseNumberLength() {
        assertThatThrownBy(
                () -> {
                    new PurchaseNumber(List.of(
                            new LottoNumber(1),
                            new LottoNumber(2),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(6)));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    public void purchaseNumberDuplicated() {
        assertThatThrownBy(
                () -> {
                    new PurchaseNumber(List.of(
                            new LottoNumber(1),
                            new LottoNumber(4),
                            new LottoNumber(3),
                            new LottoNumber(4),
                            new LottoNumber(5),
                            new LottoNumber(6)));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
