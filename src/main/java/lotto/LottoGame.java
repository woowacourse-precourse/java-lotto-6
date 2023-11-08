package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.BuyCash;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class LottoGame {

    private final LottoGameController controller;

    public LottoGame() {
        controller = new LottoGameController();
    }

    public void start() {
        BuyCash buyCash = controller.inputBuyCash();
        Lottos lottos = controller.purchaseLotto(buyCash);
        controller.printBuyLottosInformation(lottos);

        WinningLotto winningLotto = inputWinningLotto();

        Result result = controller.getResult(lottos, winningLotto);
        controller.printWinningResult(result, buyCash);
    }

    private WinningLotto inputWinningLotto() {
        WinningLotto winningLotto;
        Lotto winningNumbers = controller.inputWinningLotto();

        while (true) {
            try {
                LottoNumber bonusNumber = controller.inputBonusNumber();
                winningLotto = new WinningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return winningLotto;
    }
}
