package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public Lottos createLottoTicket() {
        return lottoService.generateLottoTicket();
    }

}
