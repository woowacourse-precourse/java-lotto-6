package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoDrawController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoDrawController lottoDrawController = new LottoDrawController(new InputView(), new OutputView());
        lottoDrawController.startDraw();
        Console.close();
    }

}
