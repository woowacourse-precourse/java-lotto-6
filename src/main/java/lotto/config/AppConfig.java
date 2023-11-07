package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    private LottoService lottoService() {
        return new LottoService(lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return LottoRepository.getInstance();
    }
}
