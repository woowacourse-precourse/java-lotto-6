package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.InvalidUnitOfMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("1000원으로 나누어 떨어지지 않을 시 예외 발생함")
    @Test
    void createMoneyByNotThousandUnit() {
        assertThatThrownBy(() -> new Money(9999))
                .isInstanceOf(InvalidUnitOfMoneyException.class);
    }

    @DisplayName("구매 단위 정상 작동 확인")
    @Test
    void getNumberOfLottoTicket() {
        Money money = new Money(5000);
        assertThat(money.getNumberOfLottoTicket())
                .isEqualTo(5);
    }
}
