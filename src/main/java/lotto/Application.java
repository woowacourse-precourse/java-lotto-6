package lotto;

import lotto.controller.LottoGame;
import lotto.view.Console;
import lotto.view.MissionUtilsInputView;
import lotto.view.PrintStreamOutputView;

public class Application {
    public static void main(String[] args) {
        new LottoGame(
                new Console(
                        new MissionUtilsInputView(),
                        new PrintStreamOutputView()
                )
        ).run();

    }
}
