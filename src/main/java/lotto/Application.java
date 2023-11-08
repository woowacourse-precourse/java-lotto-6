package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.util.generator.RandomNumberGenerator;
import lotto.view.UserIoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        UserIoManager userIoManager = new UserIoManager(new InputView(), new OutputView());
        LottoController lottoController = new LottoController(userIoManager, new RandomNumberGenerator());
        lottoController.run();

        Console.close();
    }
}
