package lotto;

import lotto.application.LottoService;
import lotto.infra.LottoNumberGeneratorImpl;
import lotto.presentation.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService(new LottoNumberGeneratorImpl());
        LottoController lottoController = new LottoController(lottoService);


        lottoController.startGame();

    }
}
