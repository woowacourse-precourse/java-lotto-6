package lotto.controller;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoService lottoService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
    }

    public void run() {
        presentLottos(buyLottoTicketProcess());
        presentLottoResult(compareLotto());
    }

    private List<Lotto> buyLottoTicketProcess() {
        Long amount = lottoInputView.getLottoPurchaseAmountInput();
        return lottoService.purchaseLotto(amount);
    }

    private void presentLottos(final List<Lotto> lottos) {
        lottoOutputView.presentLottoList(lottos);
    }

    private LottoResult compareLotto() {
        List<Integer> winningNumbers = lottoInputView.getWinningNumbers();
        Integer bonusNumber = lottoInputView.getBonusNumber();

        return lottoService.compareLotto(winningNumbers, bonusNumber);
    }

    private void presentLottoResult(final LottoResult lottoResult) {
        lottoOutputView.presentLottoResult(lottoResult);
    }
}
