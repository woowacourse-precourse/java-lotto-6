package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        LottoPurchaseAmount validPurchaseAmount = lottoService.getValidPurchaseAmount();
        LottoTicketCount ticketCount = lottoService.getTicketCount(validPurchaseAmount);
        LottoBundle lottoBundle = lottoService.getLottoBundle(ticketCount);
        WinningNumbers validWinningNumbers = lottoService.getValidWinningNumbers();
        BonusNumber validBonusNumber = lottoService.getValidBonusNumber(validWinningNumbers);
        LottoResult lottoResult = lottoService.getLottoResult(lottoBundle, validWinningNumbers, validBonusNumber);
        lottoService.showProfitRate(lottoResult,validPurchaseAmount);
    }
}
