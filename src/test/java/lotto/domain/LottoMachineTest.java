package lotto.domain;

import lotto.port.LottoNumbersProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    private static class FixedLottoNumbersProvider implements LottoNumbersProvider {
        private int index = 0;
        private final List<Lotto> lottoList;

        public FixedLottoNumbersProvider(List<Lotto> lottoList) {
            this.lottoList = lottoList;
        }

        @Override
        public Lotto provideLottoNumbers() {
            return lottoList.get(index++);
        }
    }

    @DisplayName("로또 기계는 정확한 개수의 로또 티켓을 발행해야 한다")
    @Test
    void shouldIssueTickets() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoNumbersProvider lottoNumbersProvider = new FixedLottoNumbersProvider(
                Arrays.asList(lotto1, lotto2));

        LottoMachine lottoMachine = new LottoMachine(lottoNumbersProvider);

        List<Lotto> issuedTickets = lottoMachine.issueTickets(2);

        assertThat(issuedTickets).hasSize(2);
        assertThat(issuedTickets).containsExactly(lotto1, lotto2);
    }
}
