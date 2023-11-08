package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepository;
import lotto.repository.LottoWinningRepository;
import lotto.service.LottoService;
import lotto.util.RandomLottoGenerator;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new LottoService(new RandomLottoGenerator(), new LottoRepository(), new LottoWinningRepository()),
                new InputView(new InputValidator()),
                new OutputView());
        lottoController.run();
    }
}
