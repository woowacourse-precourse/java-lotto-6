package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private static LottoMachine lottoMachine;

    @BeforeAll
    static void beforeAll() {
        lottoMachine = new LottoMachine(() -> List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("금액에 맞춰 로또를 생성한다.")
    void createLottoTickets() throws Exception {
        // given
        final LottoManager lottoManager = new LottoManager(lottoMachine);

        // when
        final List<Lotto> lottoTickets = lottoManager.createLottoTickets(14000);

        // then
        assertThat(lottoTickets).hasSize(14);
    }
}
