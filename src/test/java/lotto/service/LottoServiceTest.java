package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.model.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발행 성공")
    void createLottoTickets() {
        LottoTickets lottoTickets = lottoService.createLottoTickets(8);
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(8);
    }
}