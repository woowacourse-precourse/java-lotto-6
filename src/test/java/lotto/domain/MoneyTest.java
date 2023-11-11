package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void buyLottoNotMultipleOf1000() {
        Assertions.assertThatThrownBy(() -> {
            new Money(1500);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 미만인 경우 예외 발생가 발생한다.")
    @Test
    void buyLottoUnder1000() {
        Assertions.assertThatThrownBy(() -> {
            new Money(500);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000의 배수인 경우 정상 동작한다.")
    @Test
    void buyLottoMultipleOf1000() {
        new Money(5000);
    }

}