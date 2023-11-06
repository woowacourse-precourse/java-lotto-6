package lotto.view.input;

import lotto.domain.lotto.Lotto;

public class ProxyInputView implements ConsoleInput {

    private final LottoGameInputView lottoGameInputView;

    public ProxyInputView() {
        lottoGameInputView = new LottoGameInputView();
    }

    /**
     * retry 기능 생각하고 적용해보기
     * 이 때 retry 넘어서 예외가 나면 똑같이 사용자 입력을 잘못한 예외니까 똑같이 해도될거 같다.
     */
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
