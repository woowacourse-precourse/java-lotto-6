package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.constant.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "10000,10"})
    void 금액에_해당하는_만큼_로또_발행(int amount, int expected) {
        List<Lotto> lottos = LottoMachine.issueLotto(amount / Number.PRICE.getValue());

        assertThat(lottos.size()).isEqualTo(expected);
    }
}