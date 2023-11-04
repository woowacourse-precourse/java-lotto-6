package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @DisplayName("사용자에게 로또 구입 금액을 입력 받고 로또 수량을 계산하여 사용자 객체 생성을 테스트한다.")
    @Test
    void createPlayerByValidMoney() {
        Player player = Player.from(1000);
        assertThat(player).isNotNull();
    }

    @DisplayName("사용자에게 로또 최소 구입 금액보다 적은 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void createPlayerByMinimumMoney() {
        assertThatThrownBy(() -> Player.from(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 1000원으로 나누어 떨어지지 않는 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void createPlayerByInvalidDivideMoney() {
        assertThatThrownBy(() -> Player.from(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}