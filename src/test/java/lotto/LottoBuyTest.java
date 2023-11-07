package lotto;

import lotto.domain.LottoBuy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyTest {
    @DisplayName("로또 구매 금액 입력이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoByNotUnit() {
        assertThatThrownBy(() -> new LottoBuy(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액에 해당하는 로또 수량이 계산이 된다")
    @Test
    void buyLottoGetQuantity() {
        LottoBuy lottoBuy = new LottoBuy(1000);
        assertThat(lottoBuy.getQuantity()).isEqualTo(1);
    }
}
