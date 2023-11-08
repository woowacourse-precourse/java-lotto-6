package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {
    @DisplayName("로또 금액이 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void inputNotNumberAmount() {
        assertThatThrownBy(() -> new LottoBuyer().buyLotto("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생")
    @Test
    void inputNotDividedUpAmount() {
        assertThatThrownBy(() -> new LottoBuyer().buyLotto("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 음수일 경우 예외가 발생")
    @Test
    void inputNotPositiveNumber() {
        assertThatThrownBy(() -> new LottoBuyer().buyLotto("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 정상 발행 되었는지 확인한다")
    @Test
    void verifyPublishingLotto() {
        LottoBuyer buyer = new LottoBuyer();
        Lotto lotto = new Lotto(List.of(6, 1, 4, 5, 12, 41));

        buyer.addMyLottos(lotto);
        Lotto compareLotto = buyer.getMyLottos().get(0);

        assertThat(compareLotto.getNumbers()).containsExactly(6, 1, 4, 5, 12, 41);
    }
}
