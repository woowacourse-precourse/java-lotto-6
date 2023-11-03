package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoOutputView lottoOutputView = new LottoOutputView();

    private final LottoService lottoService = new LottoService();

    public void run() {
        buyLottoTicketProcess();
        compareLotto();
    }

    private void compareLotto() {
        List<String> winningNumbers = lottoInputView.getWinningNumbers();
        Integer bonusNumber = lottoInputView.getBonusNumber();

        lottoService.compareLotto(winningNumbers, bonusNumber);
    }

    private void buyLottoTicketProcess() {
        Long amount = lottoInputView.getLottoPurchaseAmountInput();
        List<Lotto> lottos = lottoService.purchaseLotto(amount);
        lottoOutputView.presentLottoList(lottos);
    }

}
