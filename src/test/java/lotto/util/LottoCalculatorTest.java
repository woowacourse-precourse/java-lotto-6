package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WiningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {
    @DisplayName("로또 맞은 개수를을 전달한다.")
    @Test
    void createLottoResult() {
        assertThat(new LottoCalculator()
                .calculate(new LottoTicket(new LottoTicketMaker().make(3)),
                        new WiningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7))
                .keySet())
                .containsOnly(3, 4, 5, 6, 7);
    }

}
