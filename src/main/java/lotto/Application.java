package lotto;

import lotto.controller.LottoController;
import lotto.domain.LotteryMachine;
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        new LottoController(new InputViewImpl(), new OutputViewImpl(), new LotteryMachine()).run();
    }
}
