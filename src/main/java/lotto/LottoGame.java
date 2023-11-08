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
        lottoGameController.printLottosInformation(lottos);

        WinningLotto winningLotto = inputWinningLotto();

        Result result = lottoGameController.getResult(lottos, winningLotto);
        lottoGameController.printWinningResult(result, buyCash);
    }

    private WinningLotto inputWinningLotto() {
        Lotto winningNumbers = lottoGameController.inputWinningNumbers();

        while (true) {
            try {
                LottoNumber bonusNumber = lottoGameController.inputBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}