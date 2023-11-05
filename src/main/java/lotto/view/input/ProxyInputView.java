package lotto.view.input;

import lotto.domain.lotto.Lotto;

public class ProxyInputView implements InputView{

    private final LottoGameInputView lottoGameInputView;

    public ProxyInputView() {
        lottoGameInputView = new LottoGameInputView();
    }

    @Override
    public long requestLottoPurchaseAmount() {
        return lottoGameInputView.requestLottoPurchaseAmount();
    }

    @Override
    public Lotto requestWinningLotto() {
        return lottoGameInputView.requestWinningLotto();
    }

    @Override
    public int requestBonusLottoNumber(Lotto winningLotto) {
        return lottoGameInputView.requestBonusLottoNumber(winningLotto);
    }
}
