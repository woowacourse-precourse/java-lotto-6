package lotto.model.service;

import lotto.model.entity.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 생성 티켓수랑 일치")
    @Test
    void createLottos_ReturnsCorrectNumberOfLottos() {
        int ticketCount = 5;

        List<Lotto> lottos = lottoService.createLottos(ticketCount);

        assertThat(lottos).hasSize(ticketCount);

    }
}
