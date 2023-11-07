package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "5000, 5", "10000, 10"})
    @DisplayName("구입 금액만큼의 로또를 구입한다.")
    void buy(int amount, int expected) {
        Money money = new Money(amount);
        LottoTickets lottoTickets = lottoMachine.buy(money);
        assertThat(lottoTickets.getLottos()).hasSize(expected);
    }
}
