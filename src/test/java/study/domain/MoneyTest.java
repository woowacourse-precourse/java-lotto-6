package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("돈은 1000원으로 나누어 떨어져야한다.")
    @Test
    void validate_1000으로_나누어_떨어지지_않는경우() {
        assertThatThrownBy(() -> new Money(1100L)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 이하의 돈이 들어오면 구매할 수 없다.")
    @Test
    void validate_한장도_못사는경우() {
        assertThatThrownBy(() -> new Money(0L)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000의 배수가 들어오는경우 정상 작동되는지 확인한다.")
    @Test
    void getMoney() {
        Money money = new Money(8000L);

        assertThat(money.getMoney()).isEqualTo(8000L);
    }

    @DisplayName("돈에 맞게 살 수 있는 로또 티켓수를 리턴해주는지 검사한다.")
    @Test
    void getTicket() {
        Money money = new Money(8000L);

        assertThat(money.getTicket()).isEqualTo(8L);
    }
}
