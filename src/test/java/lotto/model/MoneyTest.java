package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("금액 입력이 1000이상 100,000이하의 정수가 아니면 예외가 발생한다")
    void createMoneyOutOfSize() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 이상 100,000원 이하로만 가능합니다");
    }

    @Test
    @DisplayName("입력된 금액이 1000원 단위가 아니면 예외가 발생한다")
    void createMoneyNotInUnit() {
        assertThatThrownBy(() -> new Money(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1000원 단위로만 가능합니다");
    }

    @Test
    @DisplayName("입력 금액에 맞게 로또 횟수를 계산해 준다")
    void calculateLottoCount() {
        assertThat(new Money(5000).getLottoCount())
                .isEqualTo(5);
    }
}