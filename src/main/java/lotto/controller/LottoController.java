package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWallet;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView consoleLottoView;
    private final LottoService lottoService;

    public LottoController(LottoView consoleLottoView, LottoService lottoService) {
        this.consoleLottoView = consoleLottoView;
        this.lottoService = lottoService;
    }

    public void startGame() {
        LottoWallet lottoWallet = purchaseLotto();
        consoleLottoView.displayPurchased(lottoWallet);

        List<Integer> inputWinningNumbers = consoleLottoView.getWinningNumbers();
        Integer bonusNumber = consoleLottoView.getBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers, bonusNumber);

        
    }

    private LottoWallet purchaseLotto() {
        try {
            int purchaseAmount = consoleLottoView.getPurchaseAmount();
            return lottoService.purchase(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }


}
