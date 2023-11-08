package lotto.controller;

import lotto.domain.lotto.Cash;
import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.util.LottoShop;
import lotto.view.input.ConsoleInput;

public class LottoInputController {

    private final ConsoleInput inputView;

    public LottoInputController(ConsoleInput inputView) {
        this.inputView = inputView;
    }

    public LottoGameInfo createLottoGame() {
        Cash cash = inputView.requestLottoCash();
        Lottos lottos = LottoShop.buyLottos(cash);
        return new LottoGameInfo(cash, lottos);
    }

    public LottoResult requestLottoResult() {
        Lotto winningLotto = requestWinningLotto();
        int bonusLottoNumber = requestBonusLottoNumber(winningLotto);
        return new LottoResult(winningLotto, bonusLottoNumber);
    }

    private Lotto requestWinningLotto() {
        return inputView.requestWinningLotto();
    }

    private int requestBonusLottoNumber(Lotto winningLotto) {
        return inputView.requestBonusLottoNumber(winningLotto);
    }

}
