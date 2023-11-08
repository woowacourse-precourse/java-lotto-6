package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.LottoService;
import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine();
        LottoService lottoService = new LottoService(lottoMachine);

        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        lottoController.run();

        Console.close();
    }
}
