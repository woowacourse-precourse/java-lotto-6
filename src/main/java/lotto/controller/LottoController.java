package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private LottoView lottoView = new LottoView();
    private LottoService lottoService = new LottoService();

    public void runLotto(){
        String lottoPurchase = lottoView.inputLottoPurchase();
        int lottoPurchaseReturn = lottoService.getLottoCount(lottoPurchase);
        lottoView.printLottoPurchase(lottoPurchaseReturn);

        LottoMachine lottoMachine = lottoService.createLottoMachine(lottoPurchaseReturn);
        lottoView.printPublishedLotto(lottoMachine.getLottos());

        String winningNumber = lottoView.inputLottoWinningNumber();
        String bonusNumber = lottoView.inputLottoBonusNumber();
        lottoService.saveWinningAndBonusNumbers(lottoMachine, winningNumber, bonusNumber);

        lottoService.saveRankCount(lottoMachine);
    }
}
