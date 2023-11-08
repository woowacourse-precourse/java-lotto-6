package lotto;

import lotto.controller.LottoGame;
import lotto.policy.LottoNumberGeneratePolicy;
import lotto.policy.LottoPricePolicy;
import lotto.policy.NaturalOrderSortPolicy;
import lotto.view.Console;
import lotto.view.MissionUtilsInputView;
import lotto.view.PrintStreamOutputView;

public class Application {
    public static void main(String[] args) {
        new LottoGame(
                new Console(
                        new MissionUtilsInputView(),
                        new PrintStreamOutputView()
                ), new LottoPricePolicy(), new LottoNumberGeneratePolicy(), new NaturalOrderSortPolicy()
        ).run();

    }
}
