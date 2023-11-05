package lotto.controller;

import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.util.LottoShop;
import lotto.view.input.LottoNumberInputView;
import lotto.view.input.LottoGameStartInput;

public class LottoInputController {

    private final LottoGameStartInput lottoGameStartInput;
    private final LottoNumberInputView lottoNumberInputView;

    public LottoInputController() {
        this.lottoGameStartInput = new LottoGameStartInput();
        this.lottoNumberInputView = new LottoNumberInputView();
    }

    public LottoGameInfo createLottoGame() {
        long amount = lottoGameStartInput.requestLottoPurchaseAmount();
        Lottos lottos = LottoShop.buyLottos(amount);
        return new LottoGameInfo(amount, lottos);
    }

    public LottoResult requestLottoResult() {
        Lotto winningLotto = requestWinningLotto();
        int bonusLottoNumber;
        try {
            bonusLottoNumber = requestBonusLottoNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusLottoNumber = requestBonusLottoNumber(winningLotto);
        }
        return new LottoResult(winningLotto, bonusLottoNumber);
    }

    public Lotto requestWinningLotto() {
        return lottoNumberInputView.requestWinningLotto();
    }

    public int requestBonusLottoNumber(Lotto winningLotto) {
        return lottoNumberInputView.requestBonusLottoNumber(winningLotto);
    }

}
