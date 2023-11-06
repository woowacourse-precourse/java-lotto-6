package lotto.view.input;

import lotto.domain.lotto.Lotto;

public class ProxyInputView implements ConsoleInput {

    private final LottoGameInputView lottoGameInputView;

    public ProxyInputView() {
        lottoGameInputView = new LottoGameInputView();
    }

    @Override
    public long requestLottoPurchaseAmount() {
        try {
            return lottoGameInputView.requestLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return lottoGameInputView.requestLottoPurchaseAmount();
        }
    }

    @Override
    public Lotto requestWinningLotto() {
        try {
            return lottoGameInputView.requestWinningLotto();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return lottoGameInputView.requestWinningLotto();
        }
    }

    @Override
    public int requestBonusLottoNumber(Lotto winningLotto) {
        try {
            return lottoGameInputView.requestBonusLottoNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return lottoGameInputView.requestBonusLottoNumber(winningLotto);
        }
    }
}
