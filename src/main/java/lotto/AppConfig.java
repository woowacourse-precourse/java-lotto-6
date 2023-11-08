package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryLottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.LottoView;


public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoService(), lottoView());
    }

    public LottoView lottoView() {
        return new LottoView();
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }

    public LottoRepository lottoRepository() {
        return new MemoryLottoRepository();
    }
}
