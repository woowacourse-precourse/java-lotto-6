package lotto.controller;

import lotto.dto.LottoGameInfo;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottoResult;
import lotto.util.LottoShop;
import lotto.view.input.LottoNumberInputView;
import lotto.view.input.LottoShopInput;

public class LottoInputController {

    private final LottoShopInput lottoShopInput;
    private final LottoNumberInputView lottoNumberInputView;

    public LottoInputController(LottoShopInput lottoShopInput, LottoNumberInputView lottoNumberInputView) {
        this.lottoShopInput = lottoShopInput;
        this.lottoNumberInputView = lottoNumberInputView;
    }

    public LottoGameInfo createLottoGame() {
        long amount = lottoShopInput.requestLottoPurchaseAmount();
        Lottos lottos = LottoShop.buyLottos(amount);
        return new LottoGameInfo(amount, lottos);
    }

    public LottoResult requestLottoResult() {
        Lotto winningLotto = requestWinningLotto();
        int bonusLottoNumber = requestBonusLottoNumber(winningLotto);
        return new LottoResult(winningLotto, bonusLottoNumber);
    }

    public Lotto requestWinningLotto() {
        return lottoNumberInputView.requestWinningLotto();
    }

    public int requestBonusLottoNumber(Lotto winningLotto) {
        return lottoNumberInputView.requestBonusLottoNumber(winningLotto);
    }

}
