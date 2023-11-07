package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputMapper;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        InputMapper inputMapper = new InputMapper();
        LottoView lottoView = new LottoView(inputMapper);
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoView, lottoService);
        lottoController.run();
    }
}
