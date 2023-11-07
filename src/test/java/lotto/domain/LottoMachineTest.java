package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @Test
    @DisplayName("주어진 값으로 우승 로또를 만든다.")
    void makeWinningLotto() {
        Lotto winningLotto = lottoMachine.makeWinningLotto("1, 2, 3, 4, 5, 6");
        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
