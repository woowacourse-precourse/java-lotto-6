package lotto.view.input;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.Lotto;

public class ProxyInputView implements ConsoleInput {

    private final LottoGameInputView lottoGameInputView;

    public ProxyInputView() {
        lottoGameInputView = new LottoGameInputView();
    }

    @Override
    public Cash requestLottoCash() {
        try {
            return lottoGameInputView.requestLottoCash();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return requestLottoCash();
        }
    }

    @Override
    public Lotto requestWinningLotto() {
        try {
            return lottoGameInputView.requestWinningLotto();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return requestWinningLotto();
        }
    }

    @Override
    public int requestBonusLottoNumber(Lotto winningLotto) {
        try {
            return lottoGameInputView.requestBonusLottoNumber(winningLotto);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return requestBonusLottoNumber(winningLotto);
        }
    }
}
