package lotto.lotto.controller;

import lotto.lotto.dto.LottoDto;
import lotto.lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void createRandomLottos(int count) {
        lottoService.createLottos(count);
    }

    public List<LottoDto> getRandomLottos() {
        return lottoService.getLottos();
    }
}
