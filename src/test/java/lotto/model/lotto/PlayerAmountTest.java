package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerAmountTest {
    @DisplayName("사용자에게 로또 구입 금액을 입력 받고 로또 수량을 계산하여 사용자 로또 수량 객체 생성을 테스트한다.")
    @Test
    void createPlayerByValid() {
        PlayerAmount playerAmount = PlayerAmount.getInstance(1000);
        assertThat(playerAmount).isNotNull();
    }

    @DisplayName("로또 최소 구입 금액보다 적은 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void createPlayerAmountByInvalidMinimum() {
        assertThatThrownBy(() -> PlayerAmount.getInstance(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void createPlayerAmountByInvalidDivide() {
        assertThatThrownBy(() -> PlayerAmount.getInstance(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 로또 구입 금액을 입력 받고 로또 수량 계산을 테스트한다.")
    @Test
    void calculateAmountFromMoney() {
        PlayerAmount playerAmount = PlayerAmount.getInstance(1000);
        assertThat(playerAmount.getAmount()).isEqualTo(1);
    }
}