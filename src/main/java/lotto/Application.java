package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoMachine;
import lotto.service.LottoMachineService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachineService lottoMachineService = new LottoMachineService(new LottoMachine());
        Controller controller = new Controller(inputView, outputView, lottoMachineService);
        controller.execute();
    }
}
