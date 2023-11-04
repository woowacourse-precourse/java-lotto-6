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
        buyLottoTicketProcess();
        compareLotto();
    }

    private void compareLotto() {
        List<Integer> winningNumbers = lottoInputView.getWinningNumbers();
        Integer bonusNumber = lottoInputView.getBonusNumber();

        LottoResult lottoResult = lottoService.compareLotto(winningNumbers, bonusNumber);
        lottoOutputView.presentLottoResult(lottoResult);
    }

    private void buyLottoTicketProcess() {
        Long amount = lottoInputView.getLottoPurchaseAmountInput();
        List<Lotto> lottos = lottoService.purchaseLotto(amount);
        lottoOutputView.presentLottoList(lottos);
    }

}
