package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.BuyCash;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class LottoGame {

    private final LottoGameController lottoGameController;

    public LottoGame(LottoGameController lottoGameController) {
        this.lottoGameController = lottoGameController;
    }

    public void start() {
        BuyCash buyCash = lottoGameController.inputBuyCash();
        Lottos lottos = lottoGameController.purchaseLotto(buyCash);
        lottoGameController.printBuyLottosInformation(lottos);

        WinningLotto winningLotto = inputWinningLotto();

        Result result = lottoGameController.getResult(lottos, winningLotto);
        lottoGameController.printWinningResult(result, buyCash);
    }

    private WinningLotto inputWinningLotto() {
        WinningLotto winningLotto;
        Lotto winningNumbers = lottoGameController.inputWinningLotto();

        while (true) {
            try {
                LottoNumber bonusNumber = lottoGameController.inputBonusNumber();
                winningLotto = new WinningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return winningLotto;
    }
}
