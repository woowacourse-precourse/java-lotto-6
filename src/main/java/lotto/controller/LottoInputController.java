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
        long amount;
        Lottos lottos;

        try {
            amount = lottoGameStartInput.requestLottoPurchaseAmount();
            lottos = LottoShop.buyLottos(amount);
        } catch (IllegalArgumentException e) {
            lottoGameStartInput.printErrorMessage(e);
            amount = lottoGameStartInput.requestLottoPurchaseAmount();
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
            lotto = lottoNumberInputView.requestWinningLotto();
        } catch (IllegalArgumentException e) {
            lottoNumberInputView.printErrorMessage(e);
            lotto = lottoNumberInputView.requestWinningLotto();
        }
        return lotto;
    }

    private int requestBonusLottoNumber(Lotto winningLotto) {
        int bonusNumber;
        try {
            bonusNumber = lottoNumberInputView.requestBonusLottoNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            lottoNumberInputView.printErrorMessage(e);
            bonusNumber = lottoNumberInputView.requestBonusLottoNumber(winningLotto);
        }
        return bonusNumber;
    }

}
