package lotto;

import lotto.controller.LottoController;
import lotto.domain.RandomLottoGenerator;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        LottoService lottoService = new LottoService(new RandomLottoGenerator());
        LottoController lottoController = new LottoController(lottoView, lottoService);

        lottoController.play();
    }
}
