package lotto.controller;

import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.util.LottoShop;
import lotto.view.input.InputView;

public class LottoInputController {

    private final InputView inputView;

    public LottoInputController(InputView inputView) {
        this.inputView = inputView;
    }

    public LottoGameInfo createLottoGame() {
        long amount;
        Lottos lottos;

        try {
            amount = inputView.requestLottoPurchaseAmount();
            lottos = LottoShop.buyLottos(amount);
        } catch (IllegalArgumentException e) {
            inputView.printErrorMessage(e);
            amount = inputView.requestLottoPurchaseAmount();
            lottos = LottoShop.buyLottos(amount);
        }
        return new LottoGameInfo(amount, lottos);
    }

    public LottoResult requestLottoResult() {
        Lotto winningLotto = requestWinningLotto();
        int bonusLottoNumber = requestBonusLottoNumber(winningLotto);
        return new LottoResult(winningLotto, bonusLottoNumber);
    }

    private Lotto requestWinningLotto() {
        Lotto lotto;
        try {
            lotto = inputView.requestWinningLotto();
        } catch (IllegalArgumentException e) {
            inputView.printErrorMessage(e);
            lotto = inputView.requestWinningLotto();
        }
        return lotto;
    }

    private int requestBonusLottoNumber(Lotto winningLotto) {
        int bonusNumber;
        try {
            bonusNumber = inputView.requestBonusLottoNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            inputView.printErrorMessage(e);
            bonusNumber = inputView.requestBonusLottoNumber(winningLotto);
        }
        return bonusNumber;
    }

}
