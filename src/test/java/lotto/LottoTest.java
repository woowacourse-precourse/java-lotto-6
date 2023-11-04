package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액을 지불하면 금액에 맞는 로또 개수를 반환한다.")
    @Test
    void purchaseLotto() {
        assertThat(Lotto.purchaseCount(3000)).isEqualTo(3);
    }

    @DisplayName("금액을 지불했을 때 나누어 떨어지지 않은 경우 예외가 발생한다.")
    @Test
    void purchaseLottoByExistRemainder() {
        assertThatThrownBy(() -> Lotto.purchaseCount(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}