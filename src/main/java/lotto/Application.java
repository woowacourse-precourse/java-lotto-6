package lotto;

import lotto.controller.LottoService;
import lotto.domain.LottoComputer;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoService lottoService = new LottoService(new InputView(), new OutputView(), new LottoComputer(),
                new LottoGenerator());
        lottoService.run();
    }
}