package lotto;

import domain.PurchaseInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수 값을 입력하면 IllegalArgumentException 발생")
    void minus_money(){
        PurchaseInput purchaseInput = new PurchaseInput();
        assertThatThrownBy(() -> purchaseInput.readPurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~999 사이의 값 입력하면 IllegalArgumentException 발생")
    @Test
    void purchaseAmountBelow1000() {
        PurchaseInput purchaseInput = new PurchaseInput();
        assertThatThrownBy(() -> purchaseInput.readPurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 값 입력하면 IllegalArgumentException 발생")
    @Test
    void purchaseAmountNotMultipleOf1000() {
        PurchaseInput purchaseInput = new PurchaseInput();
        assertThatThrownBy(() -> purchaseInput.readPurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값 입력하면 IllegalArgumentException 발생")
    @Test
    void purchaseAmountNotANumber() {
        PurchaseInput purchaseInput = new PurchaseInput();
        assertThatThrownBy(() -> purchaseInput.readPurchaseAmount("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}