package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("구입 금액이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void createMoneyByNonNumeric() {
        assertThatThrownBy(() -> new Money("1000t"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createMoneyByNonThousandUnit() {
        assertThatThrownBy(() -> new Money("5100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원일 경우 예외가 발생한다.")
    @Test
    void createMoneyByZero() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 구입 금액일 시 정상적으로 구입 금액이 생성된다.")
    @Test
    void createValidMoney() {
        assertThatCode(() -> new Money("5000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 개수가 정상적으로 생성되는지 확인한다.")
    @Test
    void createLottoCount() {
        Money money = new Money("8000");
        long expectedLottoCount = money.getMoney() / 1000;

        assertThat(money.getLottoCount()).isEqualTo(expectedLottoCount);
    }
}
