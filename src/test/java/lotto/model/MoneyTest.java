package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    public void getTicketAmountTest() {
        int given = 1000;
        int target = 1;
        assertThat(Money.getTicketAmount(given)).isEqualTo(target);
    }

    @Test
    @DisplayName("1000 으로 나뉘지 않는 경우")
    public void moneyUnitTest() {
        int givenMoney = 11020;
        assertThatThrownBy(() -> Money.checkMoney(givenMoney)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Money.checkMoney(givenMoney)).hasMessage("[ERROR]" + givenMoney);
    }
}