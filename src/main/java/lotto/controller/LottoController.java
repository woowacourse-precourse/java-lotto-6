package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        long payment = InputView.getLottoPayment();
        LottoResult lottoResult = new LottoResult();
        List<Lotto> lottoList = lottoService.issueLottos(payment);


        OutputView.showPurchasedLotto(lottoList);

        WinningNumber winningNumber = getWinningNumber();
        List<Rank> ranks = lottoResult.getRanks(lottoList, winningNumber);


        OutputView.showLottoResult(payment, ranks);
    }

    public WinningNumber getWinningNumber() {
        List<Integer> winningNumber = InputView.getWinningNumber();

        Lotto lotto = new Lotto(winningNumber);
        int bonusNumber = InputView.getBonusNumber(winningNumber);

        return new WinningNumber(lotto, bonusNumber);
    }
}
