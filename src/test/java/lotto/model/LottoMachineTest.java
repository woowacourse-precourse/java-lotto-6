package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "100000:100"}, delimiter = ':')
    void issue(int money, int expected) {
        LottoMachine lottoMachine = new LottoMachine(Price.LOTTO);
        assertThat(lottoMachine.issue(money).size()).isEqualTo(expected);
    }

}