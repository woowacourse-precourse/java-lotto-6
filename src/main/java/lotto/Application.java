package lotto;

import lotto.controller.LottoProgram;
import lotto.controller.service.LottoService;
import lotto.utils.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoProgram lottoProgram = new LottoProgram(new InputView(), new OutputView()
                , new LottoService(new NumberGenerator()));
        lottoProgram.start();

    }
}
