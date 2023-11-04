package lotto.convertTest;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {
    @Test
    void 돈_로또_티켓_변환_테스트(){
        String input = "3000";
        Money money = new Money(input);
        assertThat(money.getLottoTickets()).isEqualTo(3);
    }
}
